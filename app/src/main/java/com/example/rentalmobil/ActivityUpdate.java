package com.example.rentalmobil;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityUpdate extends Activity implements View.OnClickListener {
    private EditText emailText;
    private EditText tanggalText;
    private Button updateBtn, deleteBtn;
    private EditText namaText;
    private EditText nohpText;
    private long _id;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Update Data");
        setContentView(R.layout.activity_update);
        dbManager = new DBManager(this);
        dbManager.open();
        namaText = (EditText) findViewById(R.id.nama_edittext);
        emailText = (EditText) findViewById(R.id.email_edittext);
        nohpText = (EditText) findViewById(R.id.nohp_edittext);
        tanggalText= (EditText) findViewById(R.id.tanggal_edittext);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        /* Membuat objek Intent dengan nilai yang dikirim objek Intent yang telah memanggil kelas ini sebelumnya */
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String nama = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String nohp = intent.getStringExtra("nohp");
        String tanggal = intent.getStringExtra("tanggal");
        _id = Long.parseLong(id);
        namaText.setText(nama);
        emailText.setText(email);
        nohpText.setText(nohp);
        tanggalText.setText(tanggal);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }
    // Pemilihan untuk tombol yang disentuh user (update/ delete)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Pilihan Update
            case R.id.btn_update:
                String nama = namaText.getText().toString();
                String email = emailText.getText().toString();
                String nohp = nohpText.getText().toString();
                String tanggal = tanggalText.getText().toString();
                dbManager.update(_id, nama, email, nohp, tanggal);
                this.returnHome();
                Toast.makeText(getApplicationContext(),"Update Successfully", Toast.LENGTH_LONG).show();
                break;
            // Pilihan Update
            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                Toast.makeText(getApplicationContext(),"Canceled Succesfully", Toast.LENGTH_LONG).show();
                break;


        }

    }
    // Fungsi untuk kembali ke halaman awal
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ActivityDataRental.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}

