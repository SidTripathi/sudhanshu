package com.example.sid.minim;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sid on 1/9/2017.
 */

public class MyDb {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    public MyDb(Context context)
    {
        myHelper = new MyHelper(context,"tech.db",null,1);
    }
    public void open()
    {
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    public void insert(String rollno,String name,String mobile,String email,String course,String subject,String date)
    {
        ContentValues cv = new ContentValues();
        cv.put("srollno",rollno.toLowerCase());
        cv.put("sname",name.toLowerCase());
        cv.put("smobile",mobile);
        cv.put("semail",email.toLowerCase());
        cv.put("scourse",course.toLowerCase());
        cv.put("ssubject",subject.toLowerCase());
        cv.put("sdate",date.toLowerCase());
        sqLiteDatabase.insert("student",null,cv);
    }
    public Cursor queryStudent()
    {
        Cursor c = null;
        c = sqLiteDatabase.query("student",null,null,null,null,null,null);
        return c;
    }
    public Cursor getByname(String nam)
    {
        Cursor c = null;
        if(nam!=null) {
            c = sqLiteDatabase.query("student", null, "sname =?", new String[]{nam}, null, null, null);
        }
        return c;
    }
    public Cursor getBymobile(String mobile)
    {
        Cursor c = null;
        if(mobile!=null) {
            c = sqLiteDatabase.query("student", null, "smobile =?", new String[]{mobile}, null, null, null);
        }
        return c;
    }

    public void close()
    {
        sqLiteDatabase.close();
    }
    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("create table student(_id integer primary key,srollno varchar unique ,sname text,smobile varchar,"+
                    "semail varchar,scourse text,ssubject text,sdate text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


        }
    }
}
