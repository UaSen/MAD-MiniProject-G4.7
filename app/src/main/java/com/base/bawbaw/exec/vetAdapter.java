package com.base.bawbaw.exec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.base.bawbaw.R;
import com.base.bawbaw.model.addvetmodel;

import java.util.List;

public class vetAdapter extends ArrayAdapter<addvetmodel> {


    private Context context;
    private int resource;
    List<addvetmodel> addvets;


    public vetAdapter(Context context, int resource, List<addvetmodel> addvets){
        super(context,resource,addvets);

        this.context=context;
        this.resource=resource;
        this.addvets = addvets;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView vname = row.findViewById(R.id.vettitle);
        TextView vemail = row.findViewById(R.id.vetname);


        addvetmodel addVet = addvets.get(position);
        vname.setText(addVet.getName());
        vemail.setText(addVet.getEmail());


        return  row;

    }
}

