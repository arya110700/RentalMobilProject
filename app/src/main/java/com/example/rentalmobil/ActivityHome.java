package com.example.rentalmobil;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ActivityHome extends AppCompatActivity {

    private CardView btnLis;
    private CardView btnRenta;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnRenta = (CardView) findViewById(R.id.btnRental);
        btnRenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityHome.this, TypeActivity.class);
                startActivity(i);
            }

        });

        btnLis = (CardView) findViewById(R.id.btnList);
        btnLis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityHome.this, ActivityDataRental.class);
                startActivity(i);
            }

        });

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityHome.this, LoginActivity.class);
                startActivity(i);
            }

        });


    }



}

