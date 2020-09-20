/**
 * Baw Baw 2020
 *
 * @author Senarathna A.M.U.A.
 * IT19214030
 * Y2S2 4.
 * MAD
 *
 */

package com.base.bawbaw.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.base.bawbaw.R;
import com.base.bawbaw.activities.MainActivity;
import com.base.bawbaw.database.DbHandler;
import com.base.bawbaw.exec.OwnerExec;
import com.base.bawbaw.model.Owner;

public class ProfileActivity extends AppCompatActivity {

    private EditText name, address, age, mobile;
    private Button save;
    private OwnerExec ownerExec;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        context = this;
        ownerExec = new OwnerExec(context);

        //set id for private attributes
        name = findViewById(R.id.myName);
        address = findViewById(R.id.myAddress);
        age = findViewById(R.id.myAge);
        mobile = findViewById(R.id.myNumber);

        //set id for private attributes for save button
        save = findViewById(R.id.btnSave);

        //get to do count from the table and view
        int exists = ownerExec.checkOwnerExists();


        if(exists == 0) {

            //if owner is not entered details details will enter with save button
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //store user input values in variables
                    String ownerName = name.getText().toString();
                    String ownerAddress = address.getText().toString();
                    String ownerAge = age.getText().toString();
                    String ownerMobile = mobile.getText().toString();

                    //store values to the object
                    Owner owner = new Owner(ownerName, ownerAddress, Integer.parseInt(ownerAge), ownerMobile);

                    //send values to the insert method
                    ownerExec.addOwnerDetails(owner);

                    //navigate to main activity
                    startActivity(new Intent(context, MainActivity.class));

                }
            });

        }
        else{

            //if owner details are stored before, these details will show when navigate to profile activity

            Owner ownerExist = ownerExec.viewOnlyOwner();

            name.setText(ownerExist.getName());
            address.setText(ownerExist.getAddress());
            age.setText(String.valueOf(ownerExist.getAge()));
            mobile.setText(ownerExist.getMobile());

            //when owner edit details and save
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //store user input values in variables
                    String ownerName = name.getText().toString();
                    String ownerAddress = address.getText().toString();
                    String ownerAge = age.getText().toString();
                    String ownerMobile = mobile.getText().toString();

                    //store values to the object
                    Owner editOwner = new Owner(1,ownerName, ownerAddress, Integer.parseInt(ownerAge), ownerMobile);

                    //update method called to update data
                    ownerExec.updateOwnerDetails(editOwner);

                    startActivity(new Intent(context,MainActivity.class));
                }
            });

        }




    }
}