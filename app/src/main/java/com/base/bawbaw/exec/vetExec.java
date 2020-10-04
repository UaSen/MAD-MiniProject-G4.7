package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;
import com.base.bawbaw.model.addvetmodel;
import com.base.bawbaw.model.vetAppointmentmodel;


import java.util.ArrayList;
import java.util.List;

public class vetExec extends DbHandler {


    public vetExec(@Nullable Context context) {
        super(context);

        DbHandler dbHandler = new DbHandler(context);
    }

    //insert data into vet table
    public void addvet(addvetmodel addvetinary){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(Query.BawBaw.V_NAME,addvetinary.getName());
        contentValues.put(Query.BawBaw.V_EMAIL,addvetinary.getEmail());
        contentValues.put(Query.BawBaw.V_ADDRESS,addvetinary.getAddress());
        contentValues.put(Query.BawBaw.V_WORKHOURS,addvetinary.getWorkhours());
        contentValues.put(Query.BawBaw.V_CONTACTNUMBER,addvetinary.getContactumber());
        contentValues.put(Query.BawBaw.V_NOTES,addvetinary.getNotes());
        contentValues.put(Query.BawBaw.V_STARTED,addvetinary.getStarted());
        contentValues.put(Query.BawBaw.V_FINISHED,addvetinary.getFinished());

        //save
        db.insert(Query.BawBaw.VET_TABLE,null,contentValues);

        //close
        db.close();

    }


    //add details into appointment table
    public void addvetappointment(vetAppointmentmodel addappointment){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues appointmentValues = new ContentValues();
        appointmentValues.put(Query.BawBaw.A_TITLE, addappointment.getTitle());
        appointmentValues.put(Query.BawBaw.A_VNAME, addappointment.getVname());
        appointmentValues.put(Query.BawBaw.A_DATE, addappointment.getDate());
        appointmentValues.put(Query.BawBaw.A_TIME, addappointment.getTime());
        appointmentValues.put(Query.BawBaw.A_ANOTES, addappointment.getAnotes());
        appointmentValues.put(Query.BawBaw.V_STARTED, addappointment.getStarted());
        appointmentValues.put(Query.BawBaw.V_FINISHED, addappointment.getFinished());

        //save details to the table
        db.insert(Query.BawBaw.APP_TABLE,null,appointmentValues);
        //close
        db.close();

    }

    //count no of appointments
    public int countAppointments(){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + Query.BawBaw.APP_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        //return number of rows
        return cursor.getCount();

    }


    public List<vetAppointmentmodel> getAllToDos()
    {
        List<vetAppointmentmodel> toDos = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + Query.BawBaw.APP_TABLE;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){

            do{
                //create new object
                vetAppointmentmodel toDo = new vetAppointmentmodel();

                //get data
                toDo.setAid(cursor.getInt(0));
                toDo.setTitle(cursor.getString(1));
                toDo.setVname(cursor.getString(2));
                toDo.setDate(cursor.getString(3));
                toDo.setTime(cursor.getString(4));
                toDo.setAnotes(cursor.getString(5));
                toDo.setStarted(cursor.getLong(6));
                toDo.setFinished(cursor.getLong(7));

                //todos = obj.objs.

                toDos.add(toDo);
            }while(cursor.moveToNext());

        }
        return toDos;

    }


    public void deleteAppointment(int id){
                SQLiteDatabase db = getWritableDatabase();
                db.delete(Query.BawBaw.APP_TABLE,Query.BawBaw.A_ID +"=?", new String[]{String.valueOf(id)});
                db.close();

    }


    public vetAppointmentmodel getSingleAppointment(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(Query.BawBaw.APP_TABLE,new String[]{Query.BawBaw.A_ID,Query.BawBaw.A_TITLE,Query.BawBaw.A_VNAME,Query.BawBaw.A_DATE,Query.BawBaw.A_TIME,Query.BawBaw.A_ANOTES,Query.BawBaw.V_STARTED, Query.BawBaw.V_FINISHED},Query.BawBaw.A_ID +"=?",new String[]{String.valueOf(id)},null,null,null);

        vetAppointmentmodel appoint;
        if(cursor != null)
        {
                cursor.moveToFirst();
                appoint=new vetAppointmentmodel(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getLong(6),
                    cursor.getLong(7)
                );

                return appoint;

        }
        return null;

    }


    public int updateSingleAppointment(vetAppointmentmodel appoint){
        SQLiteDatabase db =getWritableDatabase();


        ContentValues appointmentValues = new ContentValues();
        appointmentValues.put(Query.BawBaw.A_TITLE, appoint.getTitle());
        appointmentValues.put(Query.BawBaw.A_VNAME, appoint.getVname());
        appointmentValues.put(Query.BawBaw.A_DATE, appoint.getDate());
        appointmentValues.put(Query.BawBaw.A_TIME, appoint.getTime());
        appointmentValues.put(Query.BawBaw.A_ANOTES, appoint.getAnotes());
        appointmentValues.put(Query.BawBaw.V_STARTED, appoint.getStarted());
        appointmentValues.put(Query.BawBaw.V_FINISHED, appoint.getFinished());

        int status = db.update(Query.BawBaw.APP_TABLE,appointmentValues,Query.BawBaw.A_ID+"=?", new String[]{String.valueOf(appoint.getAid())});

        db.close();
        return status;

    }





    public List<addvetmodel> getAllVet(){

        List<addvetmodel> addVets = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+Query.BawBaw.VET_TABLE;

         Cursor cursor = db.rawQuery(query,null);

         if(cursor.moveToFirst()){
             do{
                 addvetmodel addVet=new addvetmodel();

                 addVet.setId(cursor.getInt(0));
                 addVet.setName(cursor.getString(1));
                 addVet.setEmail(cursor.getString(2));
                 addVet.setAddress(cursor.getString(3));
                 addVet.setWorkhours(cursor.getString(4));
                 addVet.setContactumber(cursor.getString(5));
                 addVet.setNotes(cursor.getString(6));
                 addVet.setStarted(cursor.getLong(7));
                 addVet.setFinished(cursor.getLong(8));
                 addVets.add(addVet);
             }while(cursor.moveToNext());

         }

         return addVets;
    }


    public void deleteVet(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Query.BawBaw.VET_TABLE,Query.BawBaw.V_ID+"=?", new String[]{String.valueOf(id)});
        db.close();


    }

    public addvetmodel getSingleVet(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(Query.BawBaw.VET_TABLE,new String[]{Query.BawBaw.V_ID,Query.BawBaw.V_NAME,Query.BawBaw.V_EMAIL,Query.BawBaw.V_ADDRESS,Query.BawBaw.V_WORKHOURS,Query.BawBaw.V_CONTACTNUMBER,Query.BawBaw.V_NOTES,Query.BawBaw.V_STARTED,Query.BawBaw.V_FINISHED},Query.BawBaw.V_ID+"=?",new String[]{String.valueOf(id)},null,null,null);

        addvetmodel addVet;
        if (cursor != null)
        {
            cursor.moveToFirst();

            addVet= new addvetmodel(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getLong(7),
                    cursor.getLong(8)
            );
            return addVet;
        }
            return null;

    }


    public int updateSingleVet(addvetmodel addVet){
        SQLiteDatabase db =  getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(Query.BawBaw.V_NAME,addVet.getName());
        contentValues.put(Query.BawBaw.V_EMAIL,addVet.getEmail());
        contentValues.put(Query.BawBaw.V_ADDRESS,addVet.getAddress());
        contentValues.put(Query.BawBaw.V_WORKHOURS,addVet.getWorkhours());
        contentValues.put(Query.BawBaw.V_CONTACTNUMBER,addVet.getContactumber());
        contentValues.put(Query.BawBaw.V_NOTES,addVet.getNotes());
        contentValues.put(Query.BawBaw.V_STARTED,addVet.getStarted());
        contentValues.put(Query.BawBaw.V_FINISHED,addVet.getFinished());

        int status = db.update(Query.BawBaw.VET_TABLE,contentValues,Query.BawBaw.V_ID +"=?",new String[]{String.valueOf(addVet.getId())});

        db.close();
        return status;

    };


}
