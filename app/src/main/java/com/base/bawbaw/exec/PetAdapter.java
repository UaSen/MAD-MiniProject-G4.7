package com.base.bawbaw.exec;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.base.bawbaw.R;
import com.base.bawbaw.activities.MypetActivity;
import com.base.bawbaw.model.Pet;

import java.util.List;

public class PetAdapter extends ArrayAdapter<Pet> {

    private Context context;
    private int resource;
    List<Pet> pets;
    PetExec petExec;

    Button btn1,btn2,btn3,btn4,btnSave;


    public PetAdapter(@NonNull Context context, int resource, @NonNull List<Pet> pets) {
        super(context, resource, pets);

        this.context = context;
        this.resource = resource;
        this.pets = pets;

        petExec = new PetExec(this.context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //page eke java design ekam convert krgnnw
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);
        btn1 = row.findViewById(R.id.viewPetBtn);

        TextView petName = row.findViewById(R.id.petListViewName);

        final Pet pet = pets.get(position);
        petName.setText(pet.getName());


//        btn1.setOnClickListener(new View.OnClickListener() {
//
//                 @Override
//                 public void onClick(View view) {
//
//
//                     Pet viewPet = petExec.viewSinglePet(pet.getPetId());
//
//                     Intent petView = new Intent(context, MypetActivity.class);
//                     context.startActivity(petView);
//
//
//
//        }
//    });


        return row;
    }
}
