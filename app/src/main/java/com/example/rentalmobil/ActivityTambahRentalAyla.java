package com.example.rentalmobil;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityTambahRentalAyla extends Activity implements ViewStub.OnClickListener {
    private Button addTodoBtn;
    private EditText namaEditText;
    private EditText emailEditText;
    private EditText nohpEditText;
    private EditText tanggalEditText;
    private DBManager dbManager;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText tvDateResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tambah Data");
        setContentView(R.layout.activity_ayla);
        namaEditText = (EditText) findViewById(R.id.nama_edittext);
        emailEditText = (EditText) findViewById(R.id.email_edittext);
        nohpEditText = (EditText) findViewById(R.id.nohp_edittext);
        tanggalEditText =(EditText) findViewById(R.id.tanggal_edittext);

        namaEditText.setError(null);
        emailEditText.setError(null);
        nohpEditText.setError(null);
        tanggalEditText.setError(null);


        addTodoBtn = (Button) findViewById(R.id.add_record);
        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvDateResult = (EditText) findViewById(R.id.tanggal_edittext);
        tvDateResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });


    }

    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:
                final String nama = namaEditText.getText().toString();
                final String email = emailEditText.getText().toString();
                final String nohp = nohpEditText.getText().toString();
                final String tanggal = tanggalEditText.getText().toString();
                if(namaEditText.getText().length()==0)
                {
                    namaEditText.setError("Isi ini");
                }
                else if (emailEditText.getText().length()==0)
                {
                    emailEditText.setError("Isi ini");
                }
                else if (nohpEditText.getText().length()==0)
                {
                    nohpEditText.setError("Isi ini");
                }

                else if (tanggalEditText.getText().length()==0)
                {
                    tanggalEditText.setError("Isi ini");
                }



                else
                {
                    dbManager.insert(nama, email, nohp, tanggal);
                    Intent main = new Intent(ActivityTambahRentalAyla.this, ActivityDataRental.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(main);
                    Toast.makeText(getApplicationContext(),"Boking Sukses", Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}

