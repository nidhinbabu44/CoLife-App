package com.example.colife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TestActivityHome extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
AppCompatButton b1;
EditText e1;
String getEmail, getSpin, preferenceValue;
Spinner spinner;
    SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_home);
        b1=(AppCompatButton)findViewById(R.id.subbuttest);
        e1=(EditText)findViewById(R.id.emailth);
        spinner=(Spinner)findViewById(R.id.spin);
        myPreference=getSharedPreferences("login",MODE_PRIVATE);
        preferenceValue=myPreference.getString("email",null);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmail=e1.getText().toString();
                getSpin = spinner.getSelectedItem().toString();

                SharedPreferences.Editor myEdit=myPreference.edit();
                myEdit.putString("email",getEmail);
                myEdit.commit();


                Intent i = new Intent(TestActivityHome.this,UserActivityHome.class);
                i.putExtra("keyname",getEmail);
                i.putExtra("keyspinname",getSpin);
                startActivity(i);

            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}