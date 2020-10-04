package com.base.bawbaw.exec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.database.Query;
import com.base.bawbaw.model.Owner;
import com.base.bawbaw.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetExec extends DbHandler {

    /**
     * constructor for PetExec class,creating db handler object by passing context
     **/
    public PetExec(@Nullable Context context) {
        super(context);
        DbHandler dbHandler = new DbHandler(context);
    }

    /**
     * Insert values in pet table
     * pet model class object
     *
     * @param pet
     * @return
     */
    public void addPetDetails(Pet pet) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.PET_NAME, pet.getName());
        contentValues.put(Query.BawBaw.PET_BIRTH, pet.getBirthday());
        contentValues.put(Query.BawBaw.PET_WEIGHT, pet.getWight());
        contentValues.put(Query.BawBaw.PET_HEIGHT, pet.getHeight());
        contentValues.put(Query.BawBaw.PET_BREED, pet.getBreed());
        contentValues.put(Query.BawBaw.PET_GENDER, pet.getGender());
        contentValues.put(Query.BawBaw.PET_COLOR, pet.getColour());
        contentValues.put(Query.BawBaw.PET_SPOTS, pet.getSpots());
        contentValues.put(Query.BawBaw.PET_SIGNS, pet.getSigns());
        contentValues.put(Query.BawBaw.IMAGE_STORE, pet.getImage());

        try {
            //save data to table
            sqLiteDatabase.insert(Query.BawBaw.PET_TABLE, null, contentValues);

            //connection close because running connection can make interrupts
            sqLiteDatabase.close();

        } catch (SQLiteException e) {

            sqLiteDatabase.close();

        }

    }

    /**
     * view values in pet table in a list
     * pet model class object
     *
     * @param
     * @return Pet
     */

    public List<Pet> getAllPetList() {

        List<Pet> pet = new ArrayList<>();

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


        //select all pet data
        Cursor cursor = sqLiteDatabase.rawQuery(Query.BawBaw.SELECT_ALL_PET_TABLE, null);

        if (cursor.moveToFirst()) {

            do {

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
                petGetVal.setImage(cursor.getBlob(10));

                pet.add(petGetVal);
            }
            while (cursor.moveToNext());

        }
        return pet;
    }


    /**
     * check particular pet data is exists in the database
     *
     * @param id
     * @return pet
     */
    public Pet viewSinglePet(int id) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(Query.BawBaw.PET_TABLE, new String[]{Query.BawBaw.PET_ID, Query.BawBaw.PET_NAME, Query.BawBaw.PET_BIRTH, Query.BawBaw.PET_WEIGHT, Query.BawBaw.PET_HEIGHT, Query.BawBaw.PET_BREED, Query.BawBaw.PET_GENDER, Query.BawBaw.PET_COLOR, Query.BawBaw.PET_SPOTS, Query.BawBaw.PET_SIGNS},
                Query.BawBaw.PET_ID + "= ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        Pet pet;

        if (cursor != null) {
            cursor.moveToFirst();

            pet = new Pet(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getFloat(3),
                    cursor.getFloat(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9)
            );

            return pet;

        }

        return null;

    }

    /**
     * update pet data in the database
     *
     * @param pet
     * @return
     */

    public void updatePetDetails(Pet pet) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.PET_NAME, pet.getName());
        contentValues.put(Query.BawBaw.PET_BIRTH, pet.getBirthday());
        contentValues.put(Query.BawBaw.PET_WEIGHT, pet.getWight());
        contentValues.put(Query.BawBaw.PET_HEIGHT, pet.getHeight());
        contentValues.put(Query.BawBaw.PET_BREED, pet.getBreed());
        contentValues.put(Query.BawBaw.PET_GENDER, pet.getGender());
        contentValues.put(Query.BawBaw.PET_COLOR, pet.getColour());
        contentValues.put(Query.BawBaw.PET_SPOTS, pet.getSpots());
        contentValues.put(Query.BawBaw.PET_SIGNS, pet.getSigns());

        //update the database table
        sqLiteDatabase.update(Query.BawBaw.PET_TABLE, contentValues, Query.BawBaw.PET_ID + " = ?", new String[]{String.valueOf(pet.getPetId())});
        sqLiteDatabase.close();

    }

    /**
     * delete pet data is exists in the database
     *
     * @param id
     * @return
     */
    public void deletePet(int id) {

        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(Query.BawBaw.PET_TABLE, Query.BawBaw.PET_ID + " =?", new String[]{String.valueOf(id)});

        sqLiteDatabase.close();


    }


    /**
     * check owner data is exists in the database
     *
     * @param
     * @return count
     */
    public int checkPetExists() {

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //select all values of the owner table
        String query = Query.BawBaw.SELECT_ALL_PET_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        //return number of rows
        return cursor.getCount();

    }


    /**
     * check pet image data is exists in the database
     *
     * @param id
     * @return count
     */
    public int checkImageExists(int id) {

        // Gets the data repository in read mode
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + Query.BawBaw.PET_TABLE + " WHERE " + Query.BawBaw.PET_ID + " = " + id;
        Cursor cursor;

        cursor = sqLiteDatabase.rawQuery(query, null);

        //return number of rows
        return cursor.getCount();

    }


    /**
     * update pet image data in the database
     *
     * @param image,id
     * @return
     */

    public void updateData(byte[] image, int id) {


        // Gets the data repository in write mode
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();

        contentValues.put(Query.BawBaw.IMAGE_STORE, image);

        //update the database table
        sqLiteDatabase.update(Query.BawBaw.PET_TABLE, contentValues, Query.BawBaw.PET_ID + " = ?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();


    }


}
