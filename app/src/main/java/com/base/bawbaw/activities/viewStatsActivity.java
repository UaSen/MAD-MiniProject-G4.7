package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetExec;

public class viewStatsActivity extends AppCompatActivity {

    TextView count;
    private vetExec dbHandler;
    Context context;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);
        context=this;
        imageView=findViewById(R.id.backstats);

        dbHandler = new vetExec(context);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         count=findViewById(R.id.textView6);
         int countAppointments=dbHandler.countAppointments();
         count.setText("You have " +countAppointments+ " Appointments to attend");



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(viewStatsActivity.this, MainActivity.class);
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



}