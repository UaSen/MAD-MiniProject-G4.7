package com.base.bawbaw.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.BmiExec;
import com.base.bawbaw.model.Bmi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.R.layout.simple_dropdown_item_1line;

public class CalcBmiActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ImageView imageView;
    Button calcBmi, petGender, alertBtn;
    Context context = this;

    EditText selectDate, weight, height;
    private int mYear, mMonth, mDay;

    TextView textView1, textView2;

    BmiExec bmiExec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_bmi);

        context = this;

        //get interface ids
        calcBmi = findViewById(R.id.btnBmi);
        petGender = findViewById(R.id.petGender);
        selectDate = (EditText) findViewById(R.id.birthDate);
        weight = findViewById(R.id.petWeight);
        height = findViewById(R.id.petHeight);

        //image for back press
        imageView = findViewById(R.id.backHome);

        //get menu items for breed and store in a array
        final String[] breedMenu = getResources().getStringArray(R.array.BreedMenu);

        /** view data picker when clicking the birth date option **/
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (view == selectDate) {

                    //get year,month and day of the birth day
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                    //text format
                                    selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);


                                }
                            }, mYear, mMonth, mDay);

                    //show data picker
                    datePickerDialog.show();
                }
            }
        });


        /** Array adapter for show breed list **/

        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(getApplicationContext(), simple_dropdown_item_1line, breedMenu);
        final AutoCompleteTextView breedView = (AutoCompleteTextView) findViewById(R.id.petBreed);

        //set threshold for 1 to get menu list by entering one letter
        breedView.setThreshold(1);
        breedView.setAdapter(breedAdapter);
        breedView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Toast.makeText(getApplicationContext(), (CharSequence) arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();

            }

        });

        //bmi calculating toast
        calcBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String checkPetGender = petGender.getText().toString();
                String checkSelectDate = selectDate.getText().toString();
                String checkWeight = weight.getText().toString();
                String checkHeight = height.getText().toString();
                String checkBreedView = breedView.getText().toString();

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
                    date = formatter.parse(checkSelectDate);
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


                //check input areas empty or not for calculation
                if (checkPetGender.isEmpty() || checkSelectDate.isEmpty() || checkWeight.isEmpty() || checkHeight.isEmpty() || checkBreedView.isEmpty()) {

                    //display toast message if at least one input area is empty
                    Context context = getApplicationContext();
                    CharSequence message = "Fill empty Fields";

                    int duration = Toast.LENGTH_SHORT;
                    Toast toast1 = Toast.makeText(context, message, duration);

                    toast1.show();
                    toast1.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);


                } else if (date.after(dateCurrent)) {
                    //validate birth date

                    //display toast message if birth date in invalid
                    Context context = getApplicationContext();
                    CharSequence message = "Enter valid Birthday";

                    int duration = Toast.LENGTH_LONG;
                    Toast toast1 = Toast.makeText(context, message, duration);

                    toast1.show();
                    toast1.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);

                } else {

                    float dogWeight = Float.parseFloat(weight.getText().toString());
                    float dogHeight = Float.parseFloat(height.getText().toString());

                    String dogGender = petGender.getText().toString();
                    String dogBreed = breedView.getText().toString();

                    //pass data to the bmiExec object by using overloaded constructor without id
                    bmiExec = new BmiExec(dogWeight, dogHeight, dogBreed, dogGender);

                    //calculate bmi and store in float variable
                    float bmiD = bmiExec.calculateBmi(dogWeight, dogHeight);

                    //check range of the dong and store in integer variable
                    int range = bmiExec.healthRange(dogBreed, dogGender, dogWeight);

                    String setRange;

                    if (range == 1) {
                        setRange = "Under Weight";
                    } else if (range == 2) {
                        setRange = "Over Range";
                    } else if (range == 3) {
                        setRange = "Normal Range";
                    } else {
                        setRange = "Error";
                    }


                    //show custom dialog box analysing bmi
                    showCustomDialog(bmiD, dogBreed, dogGender, setRange);

                }


            }
        });

        //navigate to main activity by pressing back arrow image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context, MainActivity.class));
            }
        });

    }

    /**
     * show custom dialog box
     **/
    private void showCustomDialog(float bmiD, String dogBreed, String dogGender, String setRange) {


        //before inflating the custom alert dialog layout, we will get the current activity view group
        ViewGroup viewGroup = findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);
        textView1 = dialogView.findViewById(R.id.alertText);
        textView2 = dialogView.findViewById(R.id.bmiRange);
        textView1.setText("BMI - " + bmiD + "\n" + "Breed  - " + dogBreed + "\n" + "Gender - " + dogGender);
        textView2.setText("Your dog in \n" + setRange);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        alertBtn = dialogView.findViewById(R.id.dialogBtnok);

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //navigate to bmi activity
                startActivity(new Intent(context, CalcBmiActivity.class));
                finish();

            }
        });
    }

    /**
     * get popup menu for gender
     **/
    public void showPopUpGenderMenu(View v) {
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
                petGender.setText("male");
                return true;
            case R.id.female:
                petGender.setText("female");
                return true;
            default:
                return false;
        }
    }


}