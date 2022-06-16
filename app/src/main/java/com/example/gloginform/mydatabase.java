package com.example.gloginform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class mydatabase extends SQLiteOpenHelper {
    private static final String database="database.db";
    public mydatabase(@Nullable Context context){
        super(context,database,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query2 = "create table Staff(Name text,Mobile_No text primary key,Address text,Password text)";
        String query1 = "create table Proprietor(Name text,Mobile_No text primary key,Address text,Password text,FirmName text)";
        sqLiteDatabase.execSQL(query2);
        sqLiteDatabase.execSQL(query1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1)
    {
        sqLiteDatabase.execSQL("drop table if exists Staff");
        sqLiteDatabase.execSQL("drop table if exists Proprietor");

        onCreate(sqLiteDatabase);
    }
    public boolean insertsrec(String sname, String smobno, String spswd, String sadd)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues obj = new ContentValues();
        obj.put("Name",sname);
        obj.put("Address",sadd);
        obj.put("Mobile_No",smobno);
        obj.put("Password",spswd);

        long rec=db.insert("Staff",null,obj);
        if(rec == -1)
            return false;
        else
            return true;
    }
    public boolean insertprec(String pname, String pmobno, String ppswd, String padd, String frmnm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues obj = new ContentValues();
        obj.put("Name", pname);
        obj.put("Address", padd);
        obj.put("Mobile_No", pmobno);
        obj.put("Password", ppswd);
        obj.put("FirmName", frmnm);

        long rec = db.insert("Proprietor", null, obj);
        if (rec == -1)
            return false;
        else
            return true;
    }
    public boolean checkStaff(String phone,String pass)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("Staff",new String[]{"Name","Mobile_No","Address","Password"},"Mobile_No=? and Password=?",new String[]{phone, pass},null,null,null);
        if(cursor!=null && cursor.moveToFirst())
        {
            return true;
        }
        return false;
    }

    public boolean checkProp(String phone,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Proprietor", new String[]{"Name","Mobile_No","Address","Password","FirmName"}, "Mobile_No=? and Password=?", new String[]{phone, pass}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        return false;
    }
    public ArrayList<StaffModel> getStaff()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<StaffModel> value = new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from Staff",null);
        if(cursor.moveToFirst())
        {
            do{
                    StaffModel obj=new StaffModel();
                    obj.setName(cursor.getString(0));
                    obj.setMob(cursor.getString(1));
                    obj.setAddress(cursor.getString(2));
                    obj.setFirmname(cursor.getString(3));
                    value.add(obj);

            }while(cursor.moveToNext());
        }
        return value;
    }

    public ArrayList<PropModel> getProp()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<PropModel>value=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from Proprietor",null);
        if(cursor.moveToFirst())
        {
            do{
                PropModel obj=new PropModel();
                obj.setName(cursor.getString(0));
                obj.setMob(cursor.getString(1));
                obj.setAddress(cursor.getString(2));
                obj.setPassword(cursor.getString(3));
                obj.setFirmName(cursor.getString(4));
                value.add(obj);

            }while(cursor.moveToNext());
        }
        return value;
    }

//    public boolean deleterec(String name)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from Staff where name=?",new String[]{name});
//        if(cursor.getCount()>0)
//        {
//            long r = db.delete("Student","name=?",new String[]{name});
//            if(r==-1)
//                return false;
//            else
//                return true;
//        }
//        return false;
//    }

//    public Cursor readalldata(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String qry="select * from Staff";
//        Cursor cursor=db.rawQuery(qry,null);
//        return cursor;
//    }

}

