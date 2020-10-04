package com.base.bawbaw.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.vetAppointmentmodel;


import java.util.Calendar;

public class addAppointmentActivity extends AppCompatActivity {




    Button saveAppointment;

    private EditText title, name,datetxt,time,notes;
    private vetExec dbHandler;
    private Context context;
    private int mDate,mMonth,mYear;
    private ImageView imageView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        imageView=findViewById(R.id.addappointback);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //input criterias
        saveAppointment = findViewById(R.id.addapt8);
        title=findViewById(R.id.addapt9);
        name=findViewById(R.id.addapt1);
        datetxt=findViewById(R.id.addapt2);
        time=findViewById(R.id.addapt3);
        notes=findViewById(R.id.addapt4);

        context=this;

        dbHandler=new vetExec(context);




        saveAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userTitle=title.getText().toString();
                String aName=name.getText().toString();
                String userDate=datetxt.getText().toString();
                String userTime=time.getText().toString();
                String userANote=notes.getText().toString();
                long started = System.currentTimeMillis();


                vetAppointmentmodel addappointment=new vetAppointmentmodel(userTitle,aName,userDate,userTime,userANote,started,0);

                //insert

                dbHandler.addvetappointment(addappointment);


                Context context = getApplicationContext();
                CharSequence message = "Details will be Saved";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);

                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 0);

                Intent intent = new Intent(addAppointmentActivity.this, appointmentlistActivity.class);
                startActivity(intent);

            }
        });

        datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar date= Calendar.getInstance();
                mDate= date.get(Calendar.DATE);
                mMonth=date.get(Calendar.MONTH);
                mYear=date.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(addAppointmentActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datetxt.setText(dayOfMonth+"-"+month+"-"+year);
                    }
                },mYear,mMonth,mDate);
                datePickerDialog.show();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(addAppointmentActivity.this, appointmentlistActivity.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Add Vet";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);

                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 0);

            }
        });


    }


    protected void onResume() {

        super.onResume();












    }
}