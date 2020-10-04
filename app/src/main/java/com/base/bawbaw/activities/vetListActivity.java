package com.base.bawbaw.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetAdapter;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.addvetmodel;


import java.util.ArrayList;
import java.util.List;

public class vetListActivity extends AppCompatActivity {


    Button btn1;
    Button btn2;
    private ImageView imageView;
    private ImageView imageView1,addVet;
    Context context;
    private vetExec dbHandler;
    private ListView listView1;
    private List<addvetmodel> addVets;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_list);

        listView1=findViewById(R.id.vetlist);
        imageView1=findViewById(R.id.backvet);
        addVet = findViewById(R.id.addvet);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context=this;
        dbHandler = new vetExec(context);
        addVets = new ArrayList<>();

        addVets= dbHandler.getAllVet();

        vetAdapter adapter= new vetAdapter(context,R.layout.single_vet,addVets);

        listView1.setAdapter(adapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final addvetmodel addvet= addVets.get(position);
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle(addvet.getName());
                builder.setMessage(addvet.getEmail());



                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteVet(addvet.getId());
                        startActivity(new Intent(context,vetListActivity.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,Edit_vet.class);
                        intent.putExtra("id", String.valueOf(addvet.getId()));
                        startActivity(intent);
                    }
                });

                builder.show();


            }
        });


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });

        addVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(vetListActivity.this, addvetActivity.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Add Vet";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);

                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 0);

            }
        });



    }

    protected void onResume() {
        super.onResume();







    }








}