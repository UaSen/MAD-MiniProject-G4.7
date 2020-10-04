package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.addvetmodel;


public class addvetActivity extends AppCompatActivity {

    Button savebtn;

    private EditText name, email,address,wh,cnum,notes;
    private vetExec dbHandler;
    private Context context;

    private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vet);

        imageView=findViewById(R.id.addvetback);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        savebtn = findViewById(R.id.vetbutton1);
        name=findViewById(R.id.veteditid1);
        email=findViewById(R.id.veteditid2);
        address=findViewById(R.id.veteditid3);
        wh=findViewById(R.id.vetedit4);
        cnum=findViewById(R.id.veteditid5);
        notes=findViewById(R.id.vetedit6);
        context = this;

        dbHandler = new vetExec(context);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String useraddress = address.getText().toString();
                String userwh = wh.getText().toString();
                String usercnum = cnum.getText().toString();
                String usernotes = notes.getText().toString();
                long started = System.currentTimeMillis();

                addvetmodel addvetinary=new addvetmodel(username,useremail,useraddress,userwh,usercnum,usernotes,started,0);

                //insert
                dbHandler.addvet(addvetinary);


                Context context = getApplicationContext();
                CharSequence message = "Details will be updated";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);

                toast.show();
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

                Intent intent = new Intent(addvetActivity.this, vetListActivity.class);
                startActivity(intent);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                CharSequence message = "Add Vet";

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);

                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 0);
                Intent intent= new Intent(context, vetListActivity.class);
                startActivity(intent);
            }
        });



    }


    protected void onResume() {
        super.onResume();









        }
    }
