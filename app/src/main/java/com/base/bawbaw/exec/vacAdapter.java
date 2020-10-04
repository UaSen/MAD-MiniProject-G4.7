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
import com.base.bawbaw.model.vaccineModel;

import java.util.List;

public class vacAdapter extends ArrayAdapter<vaccineModel> {

    private Context vacCont;
    private int vacResource;
    List<vaccineModel> vacModels;

    public vacAdapter(Context vacCont, int vacResource, List<vaccineModel> vaccineModels){
        super(vacCont, vacResource, vaccineModels);
        this.vacCont= vacCont;
        this.vacResource= vacResource;
        this.vacModels= vaccineModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater vacInflater= LayoutInflater.from(vacCont);
        View vacRow= vacInflater.inflate(vacResource, parent, false);

        TextView vacTitle= vacRow.findViewById(R.id.vacTitle);
        TextView vacDes= vacRow.findViewById(R.id.vacDes);
        ImageView vacImage= vacRow.findViewById(R.id.vacOnGoing);

        vaccineModel vacModel= vacModels.get(position);
        vacTitle.setText(vacModel.getVacName());
        vacDes.setText(vacModel.getVacDes());
        vacImage.setVisibility(vacRow.INVISIBLE);

        if(vacModel.getVacEnd() > 0) {
            vacImage.setVisibility(View.VISIBLE);
        }
        return vacRow;
    }
}
