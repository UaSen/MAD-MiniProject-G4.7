package com.base.bawbaw.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.VacDbHandler;
import com.base.bawbaw.model.vaccineModel;

public class vaccines2 extends AppCompatActivity {

    EditText vacName, vacNotes;
    ImageButton backBtn;
    Button save, cancel;
    private VacDbHandler vacDbHandler;
    private Context vacContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines2);

        backBtn = findViewById(R.id.vacBackBtn);
        save = findViewById(R.id.vacSaveBtn);
        cancel = findViewById(R.id.vacCancelBtn);
        vacName= findViewById(R.id.vacName);
        vacNotes= findViewById(R.id.vacNotes);
        vacContext= this;
        vacDbHandler= new VacDbHandler(vacContext);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vacTitle = vacName.getText().toString();
                String vacDes = vacNotes.getText().toString();
                long vacStart = System.currentTimeMillis();

                vaccineModel vacModel = new vaccineModel(vacTitle, vacDes, vacStart, 0);
                vacDbHandler.addVaccine(vacModel);

                Intent intent = new Intent(vacContext, Vaccines1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Saving information...";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vacContext, Vaccines1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Action suspended...";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Vaccines1.class);
                startActivity(intent);

                Context context = getApplicationContext();
                CharSequence message = "Cancelled...";

                int duration = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(context, message, duration);

                toast1.show();
                toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

            }
        });
    }

}