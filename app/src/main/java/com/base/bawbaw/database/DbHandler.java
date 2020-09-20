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
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.base.bawbaw.database.Query.BawBaw.DATABASE_NAME;



public class DbHandler extends SQLiteOpenHelper {


    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**  create tables in the database if not created **/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_CREATE_QUERY);
        sqLiteDatabase.execSQL(Query.BawBaw.PET_TABLE_CREATE_QUERY);

        System.out.println("query table - "+Query.BawBaw.PET_TABLE_CREATE_QUERY);

//        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_CREATE_QUERY);
//        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_CREATE_QUERY);
//        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_CREATE_QUERY);


    }


    /**  drop tables in the database if existed **/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        //Drop older table if existed
        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_DROP_QUERY);
        sqLiteDatabase.execSQL(Query.BawBaw.PET_TABLE_DROP_QUERY);
//        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_DROP_QUERY);
//        sqLiteDatabase.execSQL(Query.BawBaw.OWNER_TABLE_DROP_QUERY);



        //Create tables again
        onCreate(sqLiteDatabase);

    }

}
