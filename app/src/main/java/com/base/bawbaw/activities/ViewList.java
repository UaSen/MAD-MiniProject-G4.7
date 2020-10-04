package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.ExpenDB_controller;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {


    private static final String TAG = "ViewList";

    ExpenDB_controller myDB;
    Context context;
    private ListView mylistView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        context = this;
        myDB = new ExpenDB_controller(context);

        mylistView = (ListView) findViewById(R.id.expListView);
//        myDB = new ExpenDB_controller(this,"",null,1);

        populateListView();

    }

    private void populateListView(){
        Log.d(TAG,"populateListView: Displaying data in the ListView ");
        //get the data and opened to a list
        Cursor data = myDB.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
            listData.add(data.getString(4));
            listData.add(data.getString(5));
            listData.add(data.getString(6));
            listData.add(data.getString(7));
            listData.add(data.getString(8));
            listData.add(data.getString(9));
            listData.add(data.getString(10));
            listData.add(data.getString(11));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        mylistView.setAdapter(adapter);

        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String TOTAL =  adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + TOTAL);

                Cursor data = myDB.getDataID(TOTAL);
                int dataID = -1;
                while(data.moveToNext()) {
                    dataID = data.getInt(0);
                }
                if(dataID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + dataID);
                    Intent editScreenIntent = new Intent(ViewList.this,EditDataActivity.class);
                    editScreenIntent.putExtra("id",dataID);
                    editScreenIntent.putExtra("total",TOTAL);
                    startActivity(editScreenIntent);
                }
                else {
                    toastMessage("No ID associated");
                }

            }
        });
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
