package com.example.primeraapp.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.primeraapp.DB.ContactsContract.*;
import com.example.primeraapp.MODEL.Contact;

import java.util.ArrayList;


public class ContactsDBHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ContactsEntry.TABLE_NAME + "(" +
            ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContactsEntry.COLUMN_NAME_TITLE + " TEXT," +
            ContactsEntry.COLUMN_DATE_TITLE+" TEXT," +
            ContactsEntry.COLUMN_DESCRIPTION+" TEXT);";


    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertContact(SQLiteDatabase db, Contact c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ContactsEntry.COLUMN_NAME_TITLE, c.getEquipo());
            values.put(ContactsEntry.COLUMN_DATE_TITLE, c.getFecha());
            values.put(ContactsEntry.COLUMN_DESCRIPTION, c.getDescipcion());
            db.insert(ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }
    public ArrayList<Contact> getAllData(SQLiteDatabase sqLiteDatabase) {
        ArrayList<Contact> NBA = new ArrayList<>();
        sqLiteDatabase = this.getWritableDatabase();
        String SELECT_QUERY = "select id, title, date, description from " + ContactsEntry.TABLE_NAME + ";";
        //this cursor will navigate through the db
        Cursor c = sqLiteDatabase.rawQuery(SELECT_QUERY, null);
        Log.i("nameSQL", "" + c.getCount());
        if(c.moveToFirst()) {
            do{
                Contact form = new Contact();
                form.setId(c.getInt(0));
                form.setEquipo(c.getString(1));
                form.setFecha(c.getString(2));
                form.setDescipcion(c.getString(3));
                Log.i("nameSQL", c.getInt(0) + "" + c.getString(1) + "" + c.getString(2) + "" + c.getString(3));
                NBA.add(form);
            }while (c.moveToNext());
        }
        c.close();
        return NBA;
    }
    public void delete(SQLiteDatabase basededatos){
        basededatos.execSQL("delete from " + ContactsEntry.TABLE_NAME);
    }



}
