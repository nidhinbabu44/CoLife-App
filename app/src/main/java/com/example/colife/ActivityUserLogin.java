package com.example.colife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityUserLogin extends AppCompatActivity {
    EditText e1, e2;
    AppCompatButton b1, b2;
    String getUsername, getPassword, preferenceValue ;
    SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        e1=(EditText) findViewById(R.id.userid);
        e2=(EditText) findViewById(R.id.passwordid);
        b1=(AppCompatButton) findViewById(R.id.butlogin);
        b2=(AppCompatButton) findViewById(R.id.butreg);
        myPreference=getSharedPreferences("login",MODE_PRIVATE);
        preferenceValue=myPreference.getString("username",null);
        if (preferenceValue!=null)
        {
            Intent i=new Intent(getApplicationContext(),UserActivityHome.class);
            startActivity(i);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsername=e1.getText().toString();
                getPassword=e2.getText().toString();
                if(getUsername.equals("user1@gmail.com")&&getPassword.equals("12345"))
                {
                    SharedPreferences.Editor myEdit=myPreference.edit();
                    myEdit.putString("email",getUsername);
                    myEdit.commit();

                    Intent i=new Intent(getApplicationContext(),UserActivityHome.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Credinentals", Toast.LENGTH_SHORT).show();
                }
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),UserRegisterActivity.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}