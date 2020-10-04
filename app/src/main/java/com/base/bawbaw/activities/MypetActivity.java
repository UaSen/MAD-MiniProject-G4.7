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
import android.widget.PopupMenu;
import android.widget.Toast;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.PetExec;
import com.base.bawbaw.model.Owner;
import com.base.bawbaw.model.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.R.layout.simple_dropdown_item_1line;
import static com.base.bawbaw.activities.AddpetPhotoActivity.imageViewToByte;

public class MypetActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    EditText addName, addBirth, addWeight, addHeight, addColor, addSpots, addSigns;
    private int mYear, mMonth, mDay;
    Button savePet, addPetGender;
    private PetExec petExec;
    ImageView mImageView, backList;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypet);

        context = this;

        petExec = new PetExec(context);

        savePet = findViewById(R.id.btnSave);
        addName = findViewById(R.id.AddPetName);
        addBirth = (EditText) findViewById(R.id.AddBirthDate);
        addWeight = findViewById(R.id.AddPetWeight);
        addHeight = findViewById(R.id.AddPetHeight);
        addColor = findViewById(R.id.AddPetColor);
        addSpots = findViewById(R.id.AddPetSpots);
        addSigns = findViewById(R.id.AddPetSign);
        addPetGender = findViewById(R.id.AddpetGender);

        mImageView = findViewById(R.id.camera);
        backList = findViewById(R.id.backList);

        //get menu items for breed and store in a array
        final String[] addPetBreedMenu = getResources().getStringArray(R.array.BreedMenu);

        /** view data picker when clicking the birth date option **/
        addBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view == addBirth) {

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
                                    addBirth.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);

                    //show data picker
                    datePickerDialog.show();
                }
            }
        });


        /** Array adapter for show breed list **/

        ArrayAdapter<String> AddPetBreedAdapter = new ArrayAdapter<String>(getApplicationContext(), simple_dropdown_item_1line, addPetBreedMenu);
        final AutoCompleteTextView AddPetBreedView = (AutoCompleteTextView) findViewById(R.id.AddPetBreed);

        //set threshold for 1 to get menu list by entering one letter
        AddPetBreedView.setThreshold(1);
        AddPetBreedView.setAdapter(AddPetBreedAdapter);
        AddPetBreedView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Toast.makeText(getApplicationContext(), (CharSequence) arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();

            }

        });


        savePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //store user input values in variables
                String nameAdd = addName.getText().toString();
                String birthAdd = addBirth.getText().toString();
                String weightAdd = addWeight.getText().toString();
                String heightAdd = addHeight.getText().toString();
                String breedAdd = AddPetBreedView.getText().toString();
                String genderAdd = addPetGender.getText().toString();
                String colorAdd = addColor.getText().toString();
                String spotsAdd = addSpots.getText().toString();
                String signsAdd = addSigns.getText().toString();

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
                    date = formatter.parse(birthAdd);
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

                    startActivity(new Intent(context, MypetActivity.class));
                    finish();

                } else {

                    //store values to the object
                    Pet pet = new Pet(nameAdd, birthAdd, Float.parseFloat(weightAdd), Float.parseFloat(heightAdd), breedAdd, genderAdd, colorAdd, spotsAdd, signsAdd, null);

                    //send values to the insert method
                    petExec.addPetDetails(pet);

                    //navigate to main activity
                    startActivity(new Intent(context, PetlistActivity.class));
                    finish();
                }

            }
        });

        //navigate to petList activity by pressing back arrow image
        backList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context, PetlistActivity.class));
            }
        });


    }

    /**
     * get popup menu for gender
     **/
    public void showPopUpAddGenderMenu(View v) {
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
                addPetGender.setText("male");
                return true;
            case R.id.female:
                addPetGender.setText("female");
                return true;
            default:
                return false;
        }
    }


}