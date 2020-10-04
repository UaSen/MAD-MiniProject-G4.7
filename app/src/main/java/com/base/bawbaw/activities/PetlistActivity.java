package com.base.bawbaw.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.PetAdapter;
import com.base.bawbaw.exec.PetExec;
import com.base.bawbaw.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetlistActivity extends AppCompatActivity {

    ImageView imageView, listback;

    private ListView listView;
    Context context;
    private List<Pet> petList;

    Pet pet;
    PetExec petExec;
    Button btn1, btn2, btn3, btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petlist);

        //declare view by getting id
        listView = findViewById(R.id.listViewPet);
        petList = new ArrayList<>();
        imageView = findViewById(R.id.addPetIcon);
        listback = findViewById(R.id.listBack);

        //set application context
        context = this;

        //create pet Execution object
        petExec = new PetExec(context);

        //get pet list to show in list view
        petList = petExec.getAllPetList();

        //set adapter using pet list
        PetAdapter petAdapter = new PetAdapter(context, R.layout.activity_pet_list_view, petList);

        //set adapter to list view
        listView.setAdapter(petAdapter);

        //navigate to add new pet
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent petAdd = new Intent(getApplicationContext(), MypetActivity.class);
                startActivity(petAdd);
            }
        });

        //navigate to back
        listback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, MainActivity.class));
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //parent view
                View parentRow = (View) view.getParent();

                btn1 = parentRow.findViewById(R.id.viewPetBtn);
                btn2 = parentRow.findViewById(R.id.updatePetBtn);
                btn3 = parentRow.findViewById(R.id.delPetBtn);
                btn4 = parentRow.findViewById(R.id.addPhotoBtn);

                //get position to identify pet
                pet = petList.get(position);


                btn1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finish();


                        Intent petView = new Intent(context, ViewPetActivity.class);

                        petView.putExtra("id", String.valueOf(pet.getPetId()));

                        context.startActivity(petView);

                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finish();

                        Intent petView = new Intent(context, UpdatePetActivity.class);

                        petView.putExtra("id", String.valueOf(pet.getPetId()));

                        context.startActivity(petView);

                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        finish();

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        builder.setMessage("Are you sure?");

                        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                petExec.deletePet(pet.getPetId());
                                startActivity(new Intent(context, PetlistActivity.class));

//                                Intent petView = new Intent(context, PetlistActivity.class);

//                                petView.putExtra("id",String.valueOf(pet.getPetId()));

//                                context.startActivity(petView);

                            }


                        });

                        AlertDialog alert = builder.create();
                        alert.show();

//                        builder.show();


                    }


                });

                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();

                        Intent imgView = new Intent(context, AddpetPhotoActivity.class);

                        imgView.putExtra("id", String.valueOf(pet.getPetId()));

                        context.startActivity(imgView);


                    }
                });

            }
        });


    }


}






