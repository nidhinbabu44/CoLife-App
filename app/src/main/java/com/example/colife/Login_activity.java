package com.example.colife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
EditText e1,e2;
AppCompatButton b1,b2;
String getusername, getPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText) findViewById(R.id.userid);
        e2=(EditText) findViewById(R.id.passwordid);
        b1=(AppCompatButton) findViewById(R.id.butlogin);
        b2=(AppCompatButton) findViewById(R.id.butreg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getusername=e1.getText().toString();
                getPassword=e2.getText().toString();



            }
        });
    }
}