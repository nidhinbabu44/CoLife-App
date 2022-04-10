package com.example.colife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class testloginActivity extends AppCompatActivity {
    EditText e1, e2;
    AppCompatButton b1, b2;
    String getusername, getPassword, preferenceValue ;
    SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlogin);
        e1=(EditText) findViewById(R.id.useridtest);
        e2=(EditText) findViewById(R.id.passwordidtest);
        b1=(AppCompatButton) findViewById(R.id.butlogintest);
        b2=(AppCompatButton) findViewById(R.id.butregtest);
        myPreference=getSharedPreferences("login",MODE_PRIVATE);
        preferenceValue=myPreference.getString("username",null);
        if (preferenceValue!=null)
        {
            Intent i=new Intent(getApplicationContext(),TestActivityHome.class);
            startActivity(i);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getusername=e1.getText().toString();
                getPassword=e2.getText().toString();
                if(getusername.equals("test1@gmail.com")&&getPassword.equals("12345"))
                {
                    SharedPreferences.Editor myEdit=myPreference.edit();
                    myEdit.putString("email",getusername);
                    myEdit.commit();

                    Intent i=new Intent(getApplicationContext(),TestActivityHome.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Credinentals", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}