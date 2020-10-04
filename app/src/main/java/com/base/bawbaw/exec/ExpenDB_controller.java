package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;

public class ExpenDB_controller extends DbHandler {

    public ExpenDB_controller(@Nullable Context context) {
        super(context);

        DbHandler dbHandler = new DbHandler(context);
    }

//   private static final String TAG = "ExpenDB_controller";
//
//    public static final String DATABASE_NAME = "myExpen.db";
//
//    private static final String EXPEN_TABLE = "Expenses";
//    private static final String COL1 = "ID";
//    private static final String COL2 = "DESCRIPTION1";
//    private static final String COL3 = "PRICE1";
//    private static final String COL4 = "DESCRIPTION2";
//    private static final String COL5 = "PRICE2";
//    private static final String COL6 = "DESCRIPTION3";
//    private static final String COL7 = "PRICE3";
//    private static final String COL8 = "DESCRIPTION4";
//    private static final String COL9 = "PRICE4";
//    private static final String COL10 = "DESCRIPTION5";
//    private static final String COL11 = "PRICE5";
//    private static final String COL12 = "TOTAL";


    // inserting data to the table and checking whether the data got inserted

    public boolean addInfo(String EXdes1, String EXpri1, String EXdes2, String EXpri2, String EXdes3, String EXpri3, String EXdes4, String EXpri4, String EXdes5, String EXpri5, String EXtotal){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Query.BawBaw.COL2, EXdes1);
        values.put(Query.BawBaw.COL3, EXpri1);
        values.put(Query.BawBaw.COL4, EXdes2);
        values.put(Query.BawBaw.COL5, EXpri2);
        values.put(Query.BawBaw.COL6, EXdes3);
        values.put(Query.BawBaw.COL7, EXpri3);
        values.put(Query.BawBaw.COL8, EXdes4);
        values.put(Query.BawBaw.COL9, EXpri4);
        values.put(Query.BawBaw.COL10, EXdes5);
        values.put(Query.BawBaw.COL11, EXpri5);
        values.put(Query.BawBaw.COL12, EXtotal);

        long result = sqLiteDatabase.insert(Query.BawBaw.EXPEN_TABLE, null, values);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    // read data from the table
    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + Query.BawBaw.EXPEN_TABLE;
        Cursor data = sqLiteDatabase.rawQuery(query,null);
        return data;
    }

    // returns the ID that matches the TOTAL passed in
    public Cursor getDataID(String TOTAL){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " + Query.BawBaw.COL1 + " FROM " + Query.BawBaw.EXPEN_TABLE +
                " WHERE " + Query.BawBaw.COL12 + " = ' " + TOTAL + " ' ";
        Cursor data = sqLiteDatabase.rawQuery(query,null);
        return data;


    }

    //update the TOTAL field
    public void updateTotal(String newTotal, int id, String oldTotal ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE" + Query.BawBaw.EXPEN_TABLE + " SET " + Query.BawBaw.COL12 +
                " = '" + newTotal + "' WHERE " + Query.BawBaw.COL1 + " = '" + id + "'" +
                " AND " + Query.BawBaw.COL12 + " = '" + oldTotal + "'";
        Log.d(Query.BawBaw.TAG, "updateTotal: query: " + query);
        Log.d(Query.BawBaw.TAG, "updateTotal: Setting total to " + newTotal);
        db.execSQL(query);
    }

    //delete from database
    public void deleteTotal(int id, String TOTAL){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM" + Query.BawBaw.EXPEN_TABLE + " WHERE "
                + Query.BawBaw.COL1 + " = '" + id + "'" +
                " AND " + Query.BawBaw.COL12 + " = '" + TOTAL + "'";
        Log.d(Query.BawBaw.TAG, "deleteTotal: query: " + query);
        Log.d(Query.BawBaw.TAG, "deleteTotal: Setting total to " + TOTAL + " from database.");
        db.execSQL(query);
    }
}
