package com.example.colife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegisterActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
AppCompatButton b1;
String getName,getEmail,getPass,getConfPass;
    DataBaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        e1=(EditText) findViewById(R.id.nameuser);
        e2=(EditText) findViewById(R.id.emailuser);
        e3=(EditText) findViewById(R.id.passuser);
        e4=(EditText) findViewById(R.id.passconfuser);
        b1=(AppCompatButton) findViewById(R.id.regbutuser);
        dbhelper=new DataBaseHelper(this);
        dbhelper.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=e1.getText().toString();
                getEmail=e2.getText().toString();
                getPass=e3.getText().toString();
                getConfPass=e4.getText().toString();
                boolean result=dbhelper.insertData(getName,getEmail,getPass,getConfPass);
                if(result==true)
                {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    Toast.makeText(getApplicationContext(), "Succefully Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}