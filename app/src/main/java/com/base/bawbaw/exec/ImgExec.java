package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;
import com.base.bawbaw.model.Image;
import com.base.bawbaw.model.Owner;
import com.base.bawbaw.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class ImgExec extends DbHandler {

    public ImgExec(@Nullable Context context) {
        super(context);
        DbHandler dbHandler = new DbHandler(context);
    }

    /**
     * Insert values in image table
     * image model class object
     *
     * @param image
     * @return
     */
    public void insertOwnerData(byte[] image) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(Query.BawBaw.IMAGE_OWNER, image);


        try {
            //save data to table
            sqLiteDatabase.insert(Query.BawBaw.IMAGE_TABLE, null, contentValues);

            //connection close because running connection can make interrupts
            sqLiteDatabase.close();

        } catch (SQLiteException e) {

            sqLiteDatabase.close();

        }
    }

    /**
     * check owner image data is exists in the database
     *
     * @param
     * @return count
     */
    public int checkImageExists() {

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


        String query = Query.BawBaw.SELECT_ALL_IMAGE_TABLE;
        Cursor cursor;


        cursor = sqLiteDatabase.rawQuery(query, null);

        //return number of rows
        return cursor.getCount();

    }


    /**
     * update pet image data in the database
     *
     * @param image
     * @return
     */

    public void updateOwnerData(byte[] image) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.IMAGE_OWNER, image);

        //update the database table
        sqLiteDatabase.update(Query.BawBaw.IMAGE_TABLE, contentValues, Query.BawBaw.IMAGE_ID + " = ?", new String[]{String.valueOf(1)});
        sqLiteDatabase.close();

    }

    /**
     * view particular owner image is exists in the database
     *
     * @param
     * @return Image
     */
    public Image viewOwnerImage() {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try {

            //create courser object and pass particular owner id to get specific owner image
            Cursor cursor = sqLiteDatabase.query(Query.BawBaw.IMAGE_TABLE, new String[]{Query.BawBaw.IMAGE_ID, Query.BawBaw.IMAGE_OWNER,},
                    Query.BawBaw.IMAGE_ID + "= ?",
                    new String[]{String.valueOf(1)},
                    null,
                    null,
                    null);

            //declare Owner type variable to store owner details
            Image image;

            if (cursor != null) {

                cursor.moveToFirst();

                image = new Image(
                        cursor.getInt(0),
                        cursor.getBlob(1)

                );

                return image;

            }
            cursor.close();

        } catch (SQLiteException e) {

            e.printStackTrace();
            sqLiteDatabase.close();
        }

        return null;


    }

    //deleteData
    public void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM images WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();

    }


}
