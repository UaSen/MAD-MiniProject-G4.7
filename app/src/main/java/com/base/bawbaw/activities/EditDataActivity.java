package com.base.bawbaw.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.ExpenDB_controller;

public class EditDataActivity extends AppCompatActivity {

    private Button btnSave,btnDelete1;
    private EditText editable_item;

    Context context;
    ExpenDB_controller myDB;

    private String selectedTotal;
    private int selectedID;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.id.edit_data_layout);

        context = this;
        myDB = new ExpenDB_controller(context);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnDelete1 = (Button)findViewById(R.id.btnDelete1);
        editable_item = (EditText)findViewById(R.id.editable_item);

//        myDB = new ExpenDB_controller(this,"",null,1);

        //get the intent extra from the ViewList activity
        Intent receivedIntent = getIntent();

        //get the DataID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); // -1 is the default value

        //get the name we passed as an extra
        selectedTotal = receivedIntent.getStringExtra("total");

        //set the text to show the current selected total
        editable_item.setText(selectedTotal);

        //save button operation
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    myDB.updateTotal(item,selectedID,selectedTotal);

                }
                else{
                    toastMessage(" You must enter the new re-adjusted total ");
                }
            }
        });

        //delete button operation
        btnDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteTotal(selectedID,selectedTotal);
                editable_item.setText("");
                toastMessage("removed from database");

            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
