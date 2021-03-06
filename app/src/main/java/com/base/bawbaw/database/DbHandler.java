/**
 * Baw Baw 2020
 *
 * @author Senarathna A.M.U.A.
 * IT19214030
 * Y2S2 4.
 * MAD
 *
 */

package com.base.bawbaw.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import static com.base.bawbaw.database.Query.BawBaw.DATABASE_NAME;



public class DbHandler extends SQLiteOpenHelper {


    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**  create tables in the database if not created **/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /** create owner table **/
        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_CREATE_QUERY);

        /** create pet table **/
        sqLiteDatabase.execSQL(Query.BawBaw.PET_TABLE_CREATE_QUERY);

        /** create image table **/
       sqLiteDatabase.execSQL(Query.BawBaw.IMAGE_TABLE_CREATE_QUERY);

       /** create expenses table **/
        sqLiteDatabase.execSQL(Query.BawBaw.EXPENSES_TABLE_CREATE_QUERY);

        /** create vaccination table **/
        sqLiteDatabase.execSQL(Query.BawBaw.VACCINATION_TABLE_CREATE_QUERY);

        /** create expenses table **/
        sqLiteDatabase.execSQL(Query.BawBaw.VET_TABLE_CREATE_QUERY);

        /** create vet appointment table **/
        sqLiteDatabase.execSQL(Query.BawBaw.TABLE_CREATE_QUERY_APPOINTMENT);

    }


    /**  drop tables in the database if existed **/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        /** drop owner table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_DROP_QUERY);

        /** drop owner table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.PET_TABLE_DROP_QUERY);

        /** drop image table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.IMAGE_TABLE_DROP_QUERY);

        /** drop expenses table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.EXPENS_TABLE_DROP_QUERY);

        /** drop vaccination table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.VACCINATION_TABLE_DROP_QUERY);

        /** drop vat table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.VET_TABLE_DROP_QUERY);

        /** drop vet appointment table if exist **/
        sqLiteDatabase.execSQL(Query.BawBaw.VAT_APP_TABLE_DROP_QUERY);

        /** Create tables again **/
        onCreate(sqLiteDatabase);

    }




}
