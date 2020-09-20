package com.base.bawbaw.exec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.base.bawbaw.R;
import com.base.bawbaw.model.Pet;

import java.util.List;

public class PetAdapter extends ArrayAdapter<Pet> {

    private Context context;
    private int resource;
    List<Pet> pets;

    public PetAdapter(@NonNull Context context, int resource, @NonNull List<Pet> pets) {
        super(context, resource, pets);

        this.context = context;
        this.resource = resource;
        this.pets = pets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //page eke java design ekam convert krgnnw
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView petName = row.findViewById(R.id.petListViewName);
//        TextView description = row.findViewById(R.id.description);
//        ImageView imageView = row.findViewById(R.id.onGoing);

        Pet pet = pets.get(position);
        petName.setText(pet.getName());



        return row;
    }
}
