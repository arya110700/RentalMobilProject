package com.example.rentalmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DBLogin db;
    EditText e1, e2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBLogin(this);
        e1 = (EditText) findViewById(R.id.emaillogin);
        e2 = (EditText) findViewById(R.id.passlogin);
        b1 = (Button) findViewById(R.id.login);
        t1 = (TextView) findViewById(R.id.txtregis);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(email, password);
                if (chkemailpass == true)
                {
                    Intent in = new Intent(LoginActivity.this, ActivityHome.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(), "Succesfully Login", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
