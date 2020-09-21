package com.base.bawbaw.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.PetExec;
import com.base.bawbaw.model.Pet;

public class ViewPetActivity extends AppCompatActivity {

    Context context;
    PetExec petExecView;

    Button gender,name,bDay,weight,height,color,spot,sign,breed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pet);

        context = this;
        petExecView = new PetExec(context);

        name = findViewById(R.id.ViewPetName);
        bDay = findViewById(R.id.ViewBirthDate);
        gender = findViewById(R.id.ViewPetGender);
        weight = findViewById(R.id.ViewPetWeight);
        height = findViewById(R.id.ViewPetHeight);
        breed = findViewById(R.id.ViewPetBreed);
        color = findViewById(R.id.ViewPetColor);
        spot = findViewById(R.id.ViewPetSpots);
        sign = findViewById(R.id.ViewPetSign);

        final String id = getIntent().getStringExtra("id");

        Pet viewPet = petExecView.viewSinglePet(Integer.parseInt(id));

        name.setText(viewPet.getName());
        bDay.setText(viewPet.getBirthday());
        gender.setText(viewPet.getGender());
        weight.setText(String.valueOf(viewPet.getWight()));
        height.setText(String.valueOf(viewPet.getHeight()));
        color.setText(viewPet.getColour());
        breed.setText(viewPet.getBreed());
        spot.setText(viewPet.getSpots());
        sign.setText(viewPet.getSigns());



    }
}