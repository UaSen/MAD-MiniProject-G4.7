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
import com.base.bawbaw.model.vetAppointmentmodel;

import java.util.List;

public class AppointmentAdapter extends ArrayAdapter<vetAppointmentmodel> {

        private Context context;
        private int resource;
        List<vetAppointmentmodel> todos;



        public AppointmentAdapter(Context context, int resource, List<vetAppointmentmodel> todos){
            super(context, resource,todos);
            this.context = context;
            this.resource= resource;
            this.todos = todos;

        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //converting page to java
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.apptitle);
        TextView description = row.findViewById(R.id.appvetname);
        TextView date=row.findViewById(R.id.appdate);



        vetAppointmentmodel toDo = todos.get(position);
        title.setText(toDo.getTitle());
        description.setText(toDo.getVname());
        date.setText(toDo.getDate());


        return row;
    }
}
