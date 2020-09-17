package com.base.bawbaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MypetActivity extends AppCompatActivity {

    Button savePet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypet);

        savePet= findViewById(R.id.btnSave);
        savePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent save = new Intent(getApplicationContext(), PetlistActivity.class);
                startActivity(save);
            }
        });
    }
}