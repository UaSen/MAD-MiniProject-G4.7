package com.base.bawbaw.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.VacDbHandler;
import com.base.bawbaw.model.vaccineModel;

public class vaccines5 extends AppCompatActivity {

    EditText vacName, vacNotes;
    ImageButton vacBack1;
    Button saveVac, cancelVac;
    private VacDbHandler vacDbHandler;
    private Context vacCont;
    private long vacUpdated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines5);

        vacCont= this;
        vacDbHandler= new VacDbHandler(vacCont);

        vacName= findViewById(R.id.vacName);
        vacNotes= findViewById(R.id.vacNotes);
        vacBack1= findViewById(R.id.vacBackBtn);
        saveVac= findViewById(R.id.vacSaveBtn);
        cancelVac= findViewById(R.id.vacCancelBtn);

        final String vacID= getIntent().getStringExtra("vacID");
        final vaccineModel vaccineModel= vacDbHandler.getSingleVac(Integer.parseInt(vacID));
        vacName.setText(vaccineModel.getVacName());
        vacNotes.setText(vaccineModel.getVacDes());

        //System.out.println(vacID);

        vacBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(vaccines5.this);

                builder.setTitle("Alert!");
                builder.setMessage("The changes you made will not be saved. Are you sure you want to cancel modification?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        vaccines5.this.finish();

                        Intent intent = new Intent(getApplicationContext(), Vaccines1.class);
                        startActivity(intent);

                        Context context = getApplicationContext();
                        CharSequence message = "Action suspended...";

                        int duration = Toast.LENGTH_SHORT;
                        Toast toast1 = Toast.makeText(context, message, duration);

                        toast1.show();
                        toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        saveVac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vTitle= vacName.getText().toString();
                String vDes= vacNotes.getText().toString();
                vacUpdated= System.currentTimeMillis();

                vaccineModel vacModel= new vaccineModel(Integer.parseInt(vacID), vTitle, vDes, vacUpdated, 0);
                int vacState= vacDbHandler.updateVaccine(vacModel);
                System.out.println(vacState);

                Intent intent = new Intent(getApplicationContext(), Vaccines1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Saved successfully..";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });

        cancelVac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Vaccines1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Cancelled...";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });

    }
}