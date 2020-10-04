package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;

public class ExpenView extends AppCompatActivity {

    private TextView D1,D2,D3,D4,D5,P1,P2,P3,P4,P5,Total;
    private Button historyButton, deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expen_view);



        final MediaPlayer Expenmp = MediaPlayer.create(this, R.raw.multimedia_button_click_029); // adding sound to button click

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 1st line
        D1 = findViewById(R.id.expTextView12);
        P1 = findViewById(R.id.expTextView17);

        String DES1 = getIntent().getStringExtra("Add one");
        String PRI1 = getIntent().getStringExtra("price one");

        D1.setText(DES1);
        P1.setText(PRI1);

        // 2nd line
        D2 = findViewById(R.id.expTextView11);
        P2 = findViewById(R.id.expTextView5);

        String DES2 = getIntent().getStringExtra("Add two");
        String PRI2 = getIntent().getStringExtra("price two");

        D2.setText(DES2);
        P2.setText(PRI2);

        // 3rd line
        D3 = findViewById(R.id.expTextView13);
        P3 = findViewById(R.id.expTextView16);

        String DES3 = getIntent().getStringExtra("Add three");
        String PRI3 = getIntent().getStringExtra("price three");

        D3.setText(DES3);
        P3.setText(PRI3);

        // 4th line
        D4 = findViewById(R.id.expTextView7);
        P4 = findViewById(R.id.expTextView15);

        String DES4 = getIntent().getStringExtra("Add four");
        String PRI4 = getIntent().getStringExtra("price four");

        D4.setText(DES4);
        P4.setText(PRI4);

        // 5th line
        D5 = findViewById(R.id.expTextView9);
        P5 = findViewById(R.id.expTextView14);

        String DES5 = getIntent().getStringExtra("Add five");
        String PRI5 = getIntent().getStringExtra("price five");

        D5.setText(DES5);
        P5.setText(PRI5);

        //total//

        Total = findViewById(R.id.expTextView20);
        String TOT = getIntent().getStringExtra("total");
        Total.setText(TOT);

        //-----------------------------------------------------------------------------//

        // Edit button
        historyButton = (Button)findViewById(R.id.expButton2);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expenmp.start();
                Intent intent = new Intent(ExpenView.this, ViewList.class);
                startActivity(intent);


                Context context = getApplicationContext();
                CharSequence message = "You are in the history";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

            }
        });

        // Delete button
       /* deleteButton = (Button)findViewById(R.id.expButton3);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence message = "Data has been deleted";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

            }
        });  */




    }
}