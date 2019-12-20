package com.example.rentalmobil;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDataRental extends AppCompatActivity {

    private DBManager dbManager;private ListView listView;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] {
            DatabaseHelper._ID,DatabaseHelper.Nama, DatabaseHelper.Email, DatabaseHelper.Nohp, DatabaseHelper.Tanggal
    }
            ;
    final int[] to = new int[] {
            R.id.id, R.id.nama, R.id.email,R.id.nohp, R.id.tanggal
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Memilih layout
        setContentView(R.layout.datarental_activity);
        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        /* Adapter untuk menunjuk data di databaseuntuk di tampilkan dalam list siswa yang mana data tersebutmenunjuk ke fragment dari ListView */
        adapter = new SimpleCursorAdapter(this, R.layout.fragment_activity, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        // OnCLickListiner untuk Data Siswa yang telah ada di database
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                // Mengambil nilai list yang dipilih
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView namaTextView = (TextView) view.findViewById(R.id.nama);
                TextView emailTextView = (TextView) view.findViewById(R.id.email);
                TextView nohpTextView = (TextView) view.findViewById(R.id.nohp);
                TextView tanggalTextView = (TextView) view.findViewById(R.id.tanggal);

                // Menyimpan nilai list yang di pilih ke variabel
                String id = idTextView.getText().toString();
                String nama = namaTextView.getText().toString();
                String email = emailTextView.getText().toString();
                String nohp = nohpTextView.getText().toString();
                String tanggal = tanggalTextView.getText().toString();

                // Proses Intent untuk mengirim data ke halaman Edit
                Intent modify_intent = new Intent(getApplicationContext(), ActivityUpdate.class);
                modify_intent.putExtra("nama", nama);
                modify_intent.putExtra("email", email);
                modify_intent.putExtra("nohp", nohp);
                modify_intent.putExtra("tanggal", tanggal);
                modify_intent.putExtra("id", id);
                startActivity(modify_intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Intent add_mem = new Intent(this, TypeActivity.class);
            startActivity(add_mem);
        }else if(id==R.id.homeee){
            startActivity(new Intent(getBaseContext(),
                    ActivityHome.class));
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}

