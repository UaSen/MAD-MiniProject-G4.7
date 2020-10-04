package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.vetExec;
import com.base.bawbaw.model.addvetmodel;


public class Edit_vet extends AppCompatActivity {

    private EditText name, email,address,workhours,contactnumber,notes;
    private vetExec dbHandler;
    private Context context;
    Button edit;
    private Long updatedate2;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vet);

        context=this;
        dbHandler= new vetExec(context);

        edit=findViewById(R.id.updatevetbutton1);
        name=findViewById(R.id.updateveteditid1);
        email=findViewById(R.id.updateveteditid2);
        address=findViewById(R.id.updateveteditid3);
        workhours=findViewById(R.id.updatevetedit4);
        contactnumber=findViewById(R.id.updateveteditid5);
        notes=findViewById(R.id.updatevetedit6);



        final String id = getIntent().getStringExtra("id");
        addvetmodel addvet = dbHandler.getSingleVet(Integer.parseInt(id));

        name.setText(addvet.getName());
        email.setText(addvet.getEmail());
        address.setText(addvet.getAddress());
        workhours.setText(addvet.getWorkhours());
        contactnumber.setText(addvet.getContactumber());
        notes.setText(addvet.getNotes());


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText= name.getText().toString();
                String emailText=email.getText().toString();
                String addressText=address.getText().toString();
                String workhoursText=workhours.getText().toString();
                String contactnumberText=contactnumber.getText().toString();
                String notesText=notes.getText().toString();
                updatedate2= System.currentTimeMillis();

                addvetmodel addVet = new addvetmodel(Integer.parseInt(id),nameText,emailText,addressText,workhoursText,contactnumberText,notesText,updatedate2,0);
                int state = dbHandler.updateSingleVet(addVet);
                System.out.println(state);
                startActivity(new Intent(context,vetListActivity.class));

            }
        });


        System.out.println(id);

    }
}
