package com.base.bawbaw.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.AppointmentAdapter;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.vetAppointmentmodel;


import java.util.ArrayList;
import java.util.List;

public class appointmentlistActivity extends AppCompatActivity {

    Button btn;
    Button btn1;
    Button btn2;
    private ListView listView;
    private TextView count;
    private vetExec dbHandler;
    Context context;
    private ImageView imageView;
    private ImageView imageview1;
    private List<vetAppointmentmodel> toDos;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentlist);
        context=this;
        imageView=findViewById(R.id.addappointment);
        imageview1=findViewById(R.id.imageicomeback);
       // count=findViewById(R.id.appointmentcount);
        listView=findViewById(R.id.appointmentlist);
        dbHandler = new vetExec(context);
        toDos = new ArrayList<>();
        toDos = dbHandler.getAllToDos();





        AppointmentAdapter adapter= new AppointmentAdapter(context,R.layout.single_appointment,toDos);

        listView.setAdapter(adapter);

        //get counts from the appointment table
       // int countAppointments=dbHandler.countAppointments();
       // count.setText("You have " +countAppointments+ " Appointments to attend");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final vetAppointmentmodel vetAppointmentmodel= toDos.get(position);
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle(vetAppointmentmodel.getTitle());
                builder.setMessage(vetAppointmentmodel.getVname());



                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dbHandler.deleteAppointment(vetAppointmentmodel.getAid());
                            startActivity(new Intent(context,appointmentlistActivity.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(context,edit_appointment.class);
                                intent.putExtra("id", String.valueOf(vetAppointmentmodel.getAid()));
                                startActivity(intent);
                    }
                });

                builder.show();


            }
        });

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    protected void onResume() {

        super.onResume();
        btn=findViewById(R.id.add);




       // listview1.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   Intent intent= new Intent(appointmentlistActivity.this,addAppointmentActivity.class);
               // startActivity(intent);


           // }
        //});


        imageView.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
               Intent intent= new Intent(appointmentlistActivity.this,addAppointmentActivity.class);
              startActivity(intent);


           }
     });

    }
}