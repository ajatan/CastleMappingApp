package com.example.castlemappingapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String Table_NAME = "castlemappings";
    private static final String title = "";
    private static final String subtitle = "";
    private static final int v = 0;
    private static final int v1 = 0;
    public DatabaseHelper(Context context) {
        super(context,Table_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = String.format("CREATE TABLE%s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %sTEXT", Table_NAME, subtitle);
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i,int i2) {
        db.execSQL(String.format("DROP IF TABLE EXISTS%s", Table_NAME));
        onCreate(db);

    }
    public boolean appData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(subtitle,item);

        Log.d(TAG,"appData: Adding " + item + " to " + Table_NAME);

        long result = db.insert(Table_NAME,null,contentValues);
        if (result== -1) {
            return false;
        } else {
            return true;
        }
    }

}