package com.example.colife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivityHome extends AppCompatActivity {
    private static final String LOG_TAG = "LOG_TAG";
    TextView t1,t2;
String getEmail,getSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        t1=(TextView) findViewById(R.id.test1);
        t2=(TextView) findViewById(R.id.test2);



        getEmail=getIntent().getStringExtra("keyname");
        getSpin=getIntent().getStringExtra("keyspinname");

        t1.setText(getEmail);
        t2.setText(getSpin);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(LOG_TAG,"In Saved Instance State");
        t1=(TextView) findViewById(R.id.test1);
        t2=(TextView) findViewById(R.id.test2);

        CharSequence writtenData = t1.getText();
        writtenData = t2.getText();
        outState.putCharSequence("MySavedData",writtenData);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(LOG_TAG,"In Restore Instance State");
        CharSequence storeddata = savedInstanceState.getCharSequence("MySavedData");
        t1=(TextView) findViewById(R.id.test1);
        t2=(TextView) findViewById(R.id.test2);
        t1.setText(storeddata);
        t2.setText(storeddata);

    }
}