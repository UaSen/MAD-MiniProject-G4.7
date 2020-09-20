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
import com.base.bawbaw.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetExec extends DbHandler {

    /** constructor for PetExec class,creating db handler object by passing context **/
    public PetExec(@Nullable Context context) {
        super(context);
        DbHandler dbHandler = new DbHandler(context);
    }

    /** add pet details method for inserting owner details passing pet model class object **/
    public void addPetDetails (Pet pet){

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.PET_NAME,pet.getName());
        contentValues.put(Query.BawBaw.PET_BIRTH,pet.getBirthday());
        contentValues.put(Query.BawBaw.PET_WEIGHT,pet.getWight());
        contentValues.put(Query.BawBaw.PET_HEIGHT,pet.getHeight());
        contentValues.put(Query.BawBaw.PET_BREED,pet.getBreed());
        contentValues.put(Query.BawBaw.PET_GENDER,pet.getGender());
        contentValues.put(Query.BawBaw.PET_COLOR,pet.getColour());
        contentValues.put(Query.BawBaw.PET_SPOTS,pet.getSpots());
        contentValues.put(Query.BawBaw.PET_SIGNS,pet.getSigns());

        System.out.println(pet.getName());
        System.out.println(pet.getBirthday());
        System.out.println(pet.getWight());
        System.out.println(pet.getHeight());
        System.out.println(pet.getBreed());
        System.out.println(pet.getGender());
        System.out.println(pet.getColour());
        System.out.println(pet.getSpots());
        System.out.println(pet.getSigns());

        try {
            //save data to table
            sqLiteDatabase.insert(Query.BawBaw.PET_TABLE,null,contentValues);

            System.out.println("query - "+Query.BawBaw.PET_TABLE);

            //connection close because running connection can make interrupts
            sqLiteDatabase.close();

        } catch (SQLiteException e) {

            sqLiteDatabase.close();

        }

    }

    public List<Pet> getAllPetList() {

        List<Pet> pet = new ArrayList<>();

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(Query.BawBaw.SELECT_ALL_PET_TABLE, null);

        if (cursor.moveToFirst()) {

            do{

            Pet petGetVal = new Pet();

            petGetVal.setPetId(cursor.getInt(0));
            petGetVal.setName(cursor.getString(1));
            petGetVal.setBirthday(cursor.getString(2));
            petGetVal.setWight(cursor.getFloat(3));
            petGetVal.setHeight(cursor.getFloat(4));
            petGetVal.setBreed(cursor.getString(5));
            petGetVal.setGender(cursor.getString(6));
            petGetVal.setColour(cursor.getString(7));
            petGetVal.setSpots(cursor.getString(8));
            petGetVal.setSigns(cursor.getString(9));

            pet.add(petGetVal);
        }
        while (cursor.moveToNext()) ;

    }
        return pet;
    }


}
