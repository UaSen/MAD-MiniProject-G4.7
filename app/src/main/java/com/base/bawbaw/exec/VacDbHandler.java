package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;
import com.base.bawbaw.model.vaccineModel;

import java.util.ArrayList;
import java.util.List;

public class VacDbHandler extends DbHandler {


    public VacDbHandler(@Nullable Context context) {
        super(context);

        DbHandler dbHandler = new DbHandler(context);
    }

    public void addVaccine(vaccineModel vacModel){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        ContentValues vacContentValues= new ContentValues();

        vacContentValues.put(Query.BawBaw.VACTITLE, vacModel.getVacName());
        vacContentValues.put(Query.BawBaw.VACDES, vacModel.getVacDes());
        vacContentValues.put(Query.BawBaw.VACSTART, vacModel.getVacStart());
        vacContentValues.put(Query.BawBaw.VACEND, vacModel.getVacEnd());

        sqLiteDatabase.insert(Query.BawBaw.vacTableName,null,vacContentValues);
        sqLiteDatabase.close();
    }

    public List<vaccineModel> getAllVacs(){
        List<vaccineModel> vaccineModels = new ArrayList();
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        String vacQuery = "SELECT * FROM " +Query.BawBaw.vacTableName;

        Cursor vacCursor = sqLiteDatabase.rawQuery(vacQuery, null);

        if (vacCursor.moveToFirst()){
            do{
                vaccineModel vacModels = new vaccineModel();
                vacModels.setVacId(vacCursor.getInt(0));
                vacModels.setVacName(vacCursor.getString(1));
                vacModels.setVacDes(vacCursor.getString(2));
                vacModels.setVacStart(vacCursor.getLong(3));
                vacModels.setVacEnd(vacCursor.getLong(4));

                vaccineModels.add(vacModels);

            } while (vacCursor.moveToNext());
        }
        return vaccineModels;
    }

    public void deleteVac(int vacId){
        SQLiteDatabase vacDb= getWritableDatabase();
        vacDb.delete(Query.BawBaw.vacTableName, "VACID =?", new String[]{String.valueOf(vacId)});
        vacDb.close();
    }

    public vaccineModel getSingleVac(int vID){
        SQLiteDatabase vacDB= getWritableDatabase();
        Cursor dbCursor= vacDB.query(Query.BawBaw.vacTableName, new String[]{Query.BawBaw.VACID, Query.BawBaw.VACTITLE, Query.BawBaw.VACDES, Query.BawBaw.VACSTART, Query.BawBaw.VACEND}, Query.BawBaw.VACID + "= ?", new String[]{String.valueOf(vID)}, null, null, null);

        vaccineModel vaccineModel;
        if(dbCursor != null){
            dbCursor.moveToFirst();
            vaccineModel= new vaccineModel(
                  dbCursor.getInt(0),
                  dbCursor.getString(1),
                  dbCursor.getString(2),
                  dbCursor.getLong(3),
                  dbCursor.getLong(4)
            );
            return vaccineModel;
        }
        return null;
    }

    public int updateVaccine(vaccineModel vaccineModel){
        SQLiteDatabase vacDB= getWritableDatabase();

        ContentValues vacContentValues= new ContentValues();

        vacContentValues.put(Query.BawBaw.VACTITLE, vaccineModel.getVacName());
        vacContentValues.put(Query.BawBaw.VACDES, vaccineModel.getVacDes());
        vacContentValues.put(Query.BawBaw.VACSTART, vaccineModel.getVacStart());
        vacContentValues.put(Query.BawBaw.VACEND, vaccineModel.getVacEnd());

        int vacStatus= vacDB.update(Query.BawBaw.vacTableName, vacContentValues, Query.BawBaw.VACID + " =?", new String[]{String.valueOf(vaccineModel.getVacId())});

        vacDB.close();
        return vacStatus;
    }
}
