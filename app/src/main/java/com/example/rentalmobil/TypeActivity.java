package com.example.rentalmobil;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeActivity extends AppCompatActivity {
    private Button Apv;
    private Button Avanza;
    private Button Ayla;
    private Button Fortuner;
    private Button Terios;
    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        Apv = (Button) findViewById(R.id.apv);
        Apv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityTambahRental.class);
                startActivity(i);
            }

        });

        Ayla = (Button) findViewById(R.id.ayla);
        Ayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityTambahRentalAyla.class);
                startActivity(i);
            }

        });

        Avanza = (Button) findViewById(R.id.avanza);
        Avanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityTambahRentalAvanza.class);
                startActivity(i);
            }

        });

        Fortuner = (Button) findViewById(R.id.fortuner);
        Fortuner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityTambahRentalFortuner.class);
                startActivity(i);
            }

        });

        Terios = (Button) findViewById(R.id.terios);
        Terios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityTambahRentalTerios.class);
                startActivity(i);
            }

        });

        Home = (Button) findViewById(R.id.homee);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TypeActivity.this, ActivityHome.class);
                startActivity(i);
            }

        });

    }
}
