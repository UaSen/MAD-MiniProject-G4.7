package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.vetAppointmentmodel;


public class edit_appointment extends AppCompatActivity {


    private EditText title, name,datetxt,time,notes;
    private vetExec dbHandler;
    private Context context;
    Button edit;

    private Long updatedate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appointment);
        context=this;
        dbHandler = new vetExec(context);


        title=findViewById(R.id.editapt9);
        name=findViewById(R.id.editapt1);
        datetxt=findViewById(R.id.editapt2);
        time=findViewById(R.id.editapt3);
        notes=findViewById(R.id.editapt4);
        edit=findViewById(R.id.editapt8);



        final String id = getIntent().getStringExtra("id");
        vetAppointmentmodel appoint= dbHandler.getSingleAppointment(Integer.parseInt(id));

        title.setText(appoint.getTitle());
        name.setText(appoint.getVname());
        datetxt.setText(appoint.getDate());
        time.setText(appoint.getTime());
        notes.setText(appoint.getAnotes());


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleTxt = title.getText().toString();
                String nameTxt=name.getText().toString();
                String dateText=datetxt.getText().toString();
                String timeText=time.getText().toString();
                String notesTxt=notes.getText().toString();
                updatedate= System.currentTimeMillis();

                vetAppointmentmodel appoint =  new vetAppointmentmodel(Integer.parseInt(id),titleTxt,nameTxt,dateText,timeText,notesTxt,updatedate,0);


                int state = dbHandler.updateSingleAppointment(appoint);
                System.out.println(state);
                startActivity(new Intent(context,appointmentlistActivity.class));
            }
        });



    }
}