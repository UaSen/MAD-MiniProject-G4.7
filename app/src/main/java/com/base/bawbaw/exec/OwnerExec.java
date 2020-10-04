/**
 * Baw Baw 2020
 *
 * @author Senarathna A.M.U.A.
 * IT19214030
 * Y2S2 4.
 * MAD
 */

package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;
import com.base.bawbaw.model.Owner;


public class OwnerExec extends DbHandler {

    /**
     * constructor for OwnerExec class,creating db handler object by passing context
     **/
    public OwnerExec(@Nullable Context context) {
        super(context);
        DbHandler dbHandler = new DbHandler(context);
    }

    /**
     * Insert values in owner table
     * owner model class object
     *
     * @param owner
     * @return
     */

    public void addOwnerDetails(Owner owner) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.OWNER_NAME, owner.getName());
        contentValues.put(Query.BawBaw.OWNER_ADDRESS, owner.getAddress());
        contentValues.put(Query.BawBaw.OWNER_AGE, owner.getAge());
        contentValues.put(Query.BawBaw.OWNER_MOBILE, owner.getMobile());

        try {
            //save data to table
            sqLiteDatabase.insert(Query.BawBaw.OWNER_TABLE, null, contentValues);

            //connection close because running connection can make interrupts
            sqLiteDatabase.close();

        } catch (SQLiteException e) {

            sqLiteDatabase.close();

        }

    }

    /**
     * check owner data is exists in the database
     *
     * @param
     * @return count
     */

    public int checkOwnerExists() {

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //select all values of the owner table
        String query = Query.BawBaw.SELECT_ALL_OWNER_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        //return number of rows
        return cursor.getCount();

    }

    /**
     * check particular owner data is exists in the database
     *
     * @param
     * @return owner
     */

    public Owner viewOnlyOwner() {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        try {

            //create courser object and pass particular owner id to get specific owner
            Cursor cursor = sqLiteDatabase.query(Query.BawBaw.OWNER_TABLE, new String[]{Query.BawBaw.OWNER_ID, Query.BawBaw.OWNER_NAME, Query.BawBaw.OWNER_ADDRESS, Query.BawBaw.OWNER_AGE, Query.BawBaw.OWNER_MOBILE},
                    Query.BawBaw.OWNER_ID + "= ?",
                    new String[]{String.valueOf(1)},
                    null,
                    null,
                    null);

            //declare Owner type variable to store owner details
            Owner owner;

            if (cursor != null) {

                cursor.moveToFirst();

                owner = new Owner(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4)
                );

                return owner;

            }
            cursor.close();

        } catch (SQLiteException e) {

            e.printStackTrace();
            sqLiteDatabase.close();
        }

        return null;


    }

    /**
     * update owner data in the database
     *
     * @param owner
     * @return
     */

    public void updateOwnerDetails(Owner owner) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.OWNER_NAME, owner.getName());
        contentValues.put(Query.BawBaw.OWNER_ADDRESS, owner.getAddress());
        contentValues.put(Query.BawBaw.OWNER_AGE, owner.getAge());
        contentValues.put(Query.BawBaw.OWNER_MOBILE, owner.getMobile());

        try {

            //update the database table
            sqLiteDatabase.update(Query.BawBaw.OWNER_TABLE, contentValues, Query.BawBaw.OWNER_ID + " = 1", null);
            sqLiteDatabase.close();

        } catch (SQLiteException e) {

            sqLiteDatabase.close();

        }

    }

}
