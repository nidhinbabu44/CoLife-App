package com.example.colife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    static String DBName="user.db";
    static String TableName="user";
    static String col1="ID";
    static String col2="Name";
    static String col3="Email";
    static String col4="Password";
    static String col5="ConfirmPassword";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=" create table " +
                TableName+ "("+col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text,"+
                col5+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String Name, String Email, String Password, String ConfirmPassword)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(col2, Name);
        c.put(col3, Email);
        c.put(col4, Password);
        c.put(col5, ConfirmPassword);
        long status=db.insert(TableName,null,c);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor searchData(String pcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+
                " where " +col2+"='"+pcode+"'";
        Log.d("qry",query);
        Cursor c= db.rawQuery(query,null);
        return c;

    }
}
