package com.base.bawbaw.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.VacDbHandler;
import com.base.bawbaw.exec.vacAdapter;
import com.base.bawbaw.model.vaccineModel;

import java.util.ArrayList;
import java.util.List;

public class Vaccines1 extends AppCompatActivity {

    ImageButton vacAdd;
    ListView vacList;
    Context vacContext;
    VacDbHandler vacDbHandler;
    List<vaccineModel> vacModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines1);
        vacContext=this;

        vacDbHandler= new VacDbHandler(vacContext);
        vacAdd = findViewById(R.id.vacAdd);
        vacList = findViewById(R.id.vacList);
        //vacContext= this;
        vacModels= new ArrayList<>();

        vacModels= vacDbHandler.getAllVacs();
        vacAdapter vacAdapter= new vacAdapter(vacContext, R.layout.vaccine_single, vacModels);
        vacList.setAdapter(vacAdapter);

        vacAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vacContext, vaccines2.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Loading page...";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });

        vacList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final vaccineModel vaccineModel= vacModels.get(i);

                AlertDialog.Builder vacBuilder= new AlertDialog.Builder(vacContext);
                vacBuilder.setTitle(vaccineModel.getVacName());
                vacBuilder.setMessage(vaccineModel.getVacDes());

                vacBuilder.setPositiveButton("Dosage Given", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        vaccineModel.setVacEnd(System.currentTimeMillis());
                        vacDbHandler.updateVaccine(vaccineModel);
                        Intent intent = new Intent(vacContext, Vaccines1.class);
                        startActivity(intent);
                    }
                });

                vacBuilder.setNegativeButton("Delete Vaccine", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        vacDbHandler.deleteVac(vaccineModel.getVacId());

                        Intent intent = new Intent(vacContext, Vaccines1.class);
                        startActivity(intent);
                    }
                });

                vacBuilder.setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(vacContext, vaccines5.class);
                        intent.putExtra("vacID", String.valueOf(vaccineModel.getVacId()));
                        startActivity(intent);
                    }
                });

                vacBuilder.show();
            }
        });
    }

}