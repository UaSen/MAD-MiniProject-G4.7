package com.base.bawbaw.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.PetAdapter;
import com.base.bawbaw.exec.PetExec;
import com.base.bawbaw.model.Pet;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class PetlistActivity extends AppCompatActivity{

    ImageView imageView;

    private ListView listView;
    Context context;
    private List<Pet> petList;
    PetExec petExec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petlist);

        listView = findViewById(R.id.listViewPet);
        petList = new ArrayList<>();
        imageView = findViewById(R.id.addPetIcon);
        context = this;

        petExec = new PetExec(context);
        petList = petExec.getAllPetList();

        PetAdapter petAdapter = new PetAdapter(context,R.layout.activity_pet_list_view,petList);

        listView.setAdapter(petAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent petAdd = new Intent(getApplicationContext(), MypetActivity.class);
                startActivity(petAdd);
            }
        });



    }








}