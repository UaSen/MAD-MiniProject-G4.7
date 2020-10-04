package com.base.bawbaw.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.OwnerExec;
import com.base.bawbaw.exec.PetExec;
import com.base.bawbaw.model.Owner;
import com.base.bawbaw.model.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.R.layout.simple_dropdown_item_1line;

public class UpdatePetActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Context context;

    EditText updateName, updateBirth, updateWeight, updateHeight, updateColor, updateSpots, updateSigns;
    private int mYear, mMonth, mDay;
    Button updatePet, updatePetGender;

    ImageView imageView;

    private PetExec petExecUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pet);

        context = this;
        petExecUpdate = new PetExec(context);

        updatePet = findViewById(R.id.btnUpdate);
        updateName = findViewById(R.id.UpdatePetName);
        updateBirth = (EditText) findViewById(R.id.UpdateBirthDate);
        updateWeight = findViewById(R.id.UpdatePetWeight);
        updateHeight = findViewById(R.id.UpdatePetHeight);
        updateColor = findViewById(R.id.UpdatePetColor);
        updateSpots = findViewById(R.id.UpdatePetSpots);
        updateSigns = findViewById(R.id.UpdatePetSign);
        updatePetGender = findViewById(R.id.UpdatePetGender);

        imageView = findViewById(R.id.backList);

        final AutoCompleteTextView UpdatePetBreedView = (AutoCompleteTextView) findViewById(R.id.UpdatePetBreed);

        final String id = getIntent().getStringExtra("id");

        Pet viewPet = petExecUpdate.viewSinglePet(Integer.parseInt(id));

        updateName.setText(viewPet.getName());
        updateBirth.setText(viewPet.getBirthday());
        updatePetGender.setText(viewPet.getGender());
        updateWeight.setText(String.valueOf(viewPet.getWight()));
        updateHeight.setText(String.valueOf(viewPet.getHeight()));
        updateColor.setText(viewPet.getColour());
        UpdatePetBreedView.setText(viewPet.getBreed());
        updateSpots.setText(viewPet.getSpots());
        updateSigns.setText(viewPet.getSigns());


        //get menu items for breed and store in a array
        final String[] updatePetBreedMenu = getResources().getStringArray(R.array.BreedMenu);

        updateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view == updateBirth) {

                    //get year,month and day of the birth day
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    //text format
                                    updateBirth.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);

                    //show data picker
                    datePickerDialog.show();
                }
            }
        });

        /** Array adapter for show breed list **/

        ArrayAdapter<String> AddPetBreedAdapter = new ArrayAdapter<String>(getApplicationContext(), simple_dropdown_item_1line, updatePetBreedMenu);


        //set threshold for 1 to get menu list by entering one letter
        UpdatePetBreedView.setThreshold(1);
        UpdatePetBreedView.setAdapter(AddPetBreedAdapter);
        UpdatePetBreedView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Toast.makeText(getApplicationContext(), (CharSequence) arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();

            }

        });


        updatePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pet pet;

                //store user input values in variables
                String nameUpdate = updateName.getText().toString();
                String birthUpdate = updateBirth.getText().toString();
                String weightUpdate = updateWeight.getText().toString();
                String heightUpdate = updateHeight.getText().toString();
                String breedUpdate = UpdatePetBreedView.getText().toString();
                String genderUpdate = updatePetGender.getText().toString();
                String colorUpdate = updateColor.getText().toString();
                String spotsUpdate = updateSpots.getText().toString();
                String signsUpdate = updateSigns.getText().toString();


                //format date
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                //get current date
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //store current date in a string for format
                String dateCurr = day + "-" + (month + 1) + "-" + year;

                ///declare date variable for birth date
                Date date = null;

                try {
                    //format birth date
                    date = formatter.parse(birthUpdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //declare date variable for current date
                Date dateCurrent = null;
                try {
                    //format current date
                    dateCurrent = formatter.parse(dateCurr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (date.after(dateCurrent)) {
                    //validate birth date

                    //display toast message if birth date in invalid
                    Context context = getApplicationContext();
                    CharSequence message = "Enter valid Birthday";

                    int duration = Toast.LENGTH_LONG;
                    Toast toast1 = Toast.makeText(context, message, duration);

                    toast1.show();
                    toast1.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);

                    startActivity(new Intent(context, UpdatePetActivity.class));
                    finish();

                } else {

                    //store values to the object
                    pet = new Pet(Integer.parseInt(id), nameUpdate, birthUpdate, Float.parseFloat(weightUpdate), Float.parseFloat(heightUpdate), breedUpdate, genderUpdate, colorUpdate, spotsUpdate, signsUpdate);

                    //send values to the insert method
                    petExecUpdate.updatePetDetails(pet);

                    //navigate to main activity
                    startActivity(new Intent(context, PetlistActivity.class));
                    finish();
                }


            }
        });

        //navigate to petList activity by pressing back arrow image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context, PetlistActivity.class));
            }
        });


    }

    /**
     * get popup menu for gender
     **/
    public void showPopUpUpdateGenderMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.gender_popup_menu);
        popup.show();
    }


    /**
     * popup menu view in the text
     **/
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.male:
                updatePetGender.setText("male");
                return true;
            case R.id.female:
                updatePetGender.setText("female");
                return true;
            default:
                return false;
        }
    }
}