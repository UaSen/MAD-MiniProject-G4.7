package com.base.bawbaw.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.base.bawbaw.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get view for set menu bar
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }

    public void cardNavigator(View view) {

        switch (view.getId()) {

            case R.id.card1:
                Intent i1 = new Intent(getApplicationContext(), PetlistActivity.class);
                startActivity(i1);;
                break;

            case R.id.card2:
                Intent i2 = new Intent(this,viewStatsActivity.class);
                this.startActivity(i2);
                break;

            case R.id.card3:
               Intent i3 = new Intent(this,Vaccines1.class);
                this.startActivity(i3);
               break;

            case R.id.card4:
                Intent i4 = new Intent(this, appointmentlistActivity.class);
                this.startActivity(i4);
                break;

            case R.id.card5:
                Intent i5 = new Intent(this,vetListActivity.class);
                this.startActivity(i5);
                break;

            case R.id.card6:
                Intent i6 = new Intent(getApplicationContext(), ExpenSecondMainActivity.class);
                startActivity(i6);
                break;

            default:
                Intent i7 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i7);
                break;

        }
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent home = new Intent(this,MainActivity.class);
                this.startActivity(home);
                break;

            case R.id.nav_bmi:
                Intent bmi = new Intent(this, CalcBmiActivity.class);
                this.startActivity(bmi);
                break;

            case R.id.nav_profile:
                Intent profile = new Intent(this, ProfileActivity.class);
                this.startActivity(profile);
                break;

//            case R.id.nav_expense:
//                Intent expense = new Intent(this,ExpenseHistoryActivity.class);
//                this.startActivity(expense);
//                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


}