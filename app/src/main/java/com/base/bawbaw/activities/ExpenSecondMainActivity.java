package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.ExpenDB_controller;

public class ExpenSecondMainActivity extends AppCompatActivity {

    private Button buttonSaveAndCal;
    private EditText d1,d2,d3,d4,d5,p1,p2,p3,p4,p5;
    private TextView mainTotal;
    Context context;
    ExpenDB_controller myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expen_second_main);

        context = this;
        myDB = new ExpenDB_controller(context);

        final MediaPlayer Expenmp = MediaPlayer.create(this, R.raw.multimedia_button_click_029); // adding sound to button click

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        d1 = findViewById(R.id.EXPeditTextTextPersonName3);
        p1 = findViewById(R.id.EXPeditTextTextPersonName2);
        d2 = findViewById(R.id.EXPeditTextTextPersonName4);
        p2 = findViewById(R.id.EXPeditTextTextPersonName8);
        d3 = findViewById(R.id.EXPeditTextTextPersonName5);
        p3 = findViewById(R.id.EXPeditTextTextPersonName10);
        d4 = findViewById(R.id.EXPeditTextTextPersonName6);
        p4 = findViewById(R.id.EXPeditTextTextPersonName11);
        d5 = findViewById(R.id.EXPeditTextTextPersonName7);
        p5 = findViewById(R.id.EXPeditTextTextPersonName12);

        mainTotal = findViewById(R.id.expTextViewMain2);

//        myDB = new ExpenDB_controller(this,"",null,1);

        buttonSaveAndCal = (Button)findViewById(R.id.expButton);

        buttonSaveAndCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Expenmp.start(); // implementing the button sound

                String des1 = d1.getText().toString();
                String pri1 = p1.getText().toString();

                String des2 = d2.getText().toString();
                String pri2 = p2.getText().toString();

                String des3 = d3.getText().toString();
                String pri3 = p3.getText().toString();

                String des4 = d4.getText().toString();
                String pri4 = p4.getText().toString();

                String des5 = d5.getText().toString();
                String pri5 = p5.getText().toString();

                // calculation part //

                if (p1.getText().toString().length() == 0){
                    p1.setText("0");                           // setting price area to 0 value if the field left empty to avoid crashing
                }
                if (p2.getText().toString().length() == 0){
                    p2.setText("0");                             // setting price area to 0 value if the field left empty to avoid crashing
                }
                if (p3.getText().toString().length() == 0){
                    p3.setText("0");                                // setting price area to 0 value if the field left empty to avoid crashing
                }
                if (p4.getText().toString().length() == 0){
                    p4.setText("0");                                 // setting price area to 0 value if the field left empty to avoid crashing
                }
                if (p5.getText().toString().length() == 0){
                    p5.setText("0");                                 // setting price area to 0 value if the field left empty to avoid crashing
                }


                int num1 = Integer.parseInt(p1.getText().toString());
                int num2 = Integer.parseInt(p2.getText().toString());
                int num3 = Integer.parseInt(p3.getText().toString());
                int num4 = Integer.parseInt(p4.getText().toString());
                int num5 = Integer.parseInt(p5.getText().toString());

                int sum = num1 + num2 + num3 + num4 + num5;
                mainTotal.setText(String.valueOf(sum));

                String tot = mainTotal.getText().toString();

                //database data insertion

                String EXdes1 = d1.getText().toString();
                String EXpri1 = p1.getText().toString();
                String EXdes2 = d2.getText().toString();
                String EXpri2 = p2.getText().toString();
                String EXdes3 = d3.getText().toString();
                String EXpri3 = p3.getText().toString();
                String EXdes4 = d4.getText().toString();
                String EXpri4 = p4.getText().toString();
                String EXdes5 = d5.getText().toString();
                String EXpri5 = p5.getText().toString();

                String EXtotal =  mainTotal.getText().toString();

                if(EXdes1.length() != 0 && EXdes2.length() != 0 && EXdes3.length() != 0 && EXdes4.length() != 0 && EXdes5.length() != 0){  // put EXpri as well incase something went wrong
                    AddData(EXdes1,EXpri1,EXdes2,EXpri2,EXdes3,EXpri3,EXdes4,EXpri4,EXdes5,EXpri5,EXtotal);
                    d1.setText("");
                    d2.setText("");
                    d3.setText("");
                    d4.setText("");
                    d5.setText("");
                    p1.setText("");
                    p2.setText("");
                    p3.setText("");
                    p4.setText("");
                    p5.setText("");
                    mainTotal.setText("");
                }else{
                    Toast.makeText(ExpenSecondMainActivity.this,"add something. Fill all the 5 fields",Toast.LENGTH_LONG).show();
                }



                Intent intent = new Intent(ExpenSecondMainActivity.this, ExpenView.class);
                intent.putExtra("Add one", des1);
                intent.putExtra("price one", pri1);
                intent.putExtra("Add two", des2);
                intent.putExtra("price two",pri2);
                intent.putExtra("Add three",des3);
                intent.putExtra("price three", pri3);
                intent.putExtra("Add four",des4);
                intent.putExtra("price four",pri4);
                intent.putExtra("Add five",des5);
                intent.putExtra("price five",pri5);

                intent.putExtra("total",tot);

                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Data saved and calculated";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();






            }
        });


    }
    
    // checking the data insertion with the ExpenDB_controller

    public void AddData(String EXdes1, String EXpri1, String EXdes2, String EXpri2, String EXdes3, String EXpri3, String EXdes4, String EXpri4, String EXdes5, String EXpri5, String EXtotal){
        boolean insertData = myDB.addInfo(EXdes1, EXpri1, EXdes2, EXpri2, EXdes3, EXpri3, EXdes4, EXpri4, EXdes5, EXpri5, EXtotal);

        if (insertData == true){
            Toast.makeText(ExpenSecondMainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ExpenSecondMainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
        }
    }
}
