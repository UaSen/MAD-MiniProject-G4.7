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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

//                arryalist eke mona todo ekat check kre kiyl gnne meke position eka arn ekat adalw dialog box eka pena ynne

                View parentRow = (View) view.getParent();

                Button btn1 = parentRow.findViewById(R.id.viewPetBtn);
                Button btn2 = parentRow.findViewById(R.id.updatePetBtn);
                Button btn3 = parentRow.findViewById(R.id.deletePetBtn);

                final Pet pet = petList.get(position);

                System.out.println("view btn po" + position);
                System.out.println("view btn " + btn1);

        btn1.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View view) {

                     Intent petView = new Intent(context, ViewPetActivity.class);

                     petView.putExtra("id",String.valueOf(pet.getPetId()));

                     context.startActivity(petView);

        }
    });

                btn2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Intent petView = new Intent(context, UpdatePetActivity.class);

                        petView.putExtra("id",String.valueOf(pet.getPetId()));

                        context.startActivity(petView);

                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

//                        builder.setTitle("Test");
                        builder.setMessage("Are you sure?");

                        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                petExec.deletePet(pet.getPetId());
                                startActivity(new Intent(context,MainActivity.class));

                            }
                        });

                        builder.show();




                        Intent petView = new Intent(context, PetlistActivity.class);

                        petView.putExtra("id",String.valueOf(pet.getPetId()));

                        context.startActivity(petView);

                    }
                });



            }
        });



    }




    }






