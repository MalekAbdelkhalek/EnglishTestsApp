package com.example.english_tests;



import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerUtil {
    private static Context mContext;

    public DrawerUtil(Context context) {
        mContext = context;
    }
    public static void setDrawer(AppCompatActivity activity, DrawerLayout drawerLayout, NavigationView navview, ActionBarDrawerToggle drawerToggle) {

        
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home: {
                        //Toast.makeText(activity, "here is the home", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(activity,MainActivity.class);
                        activity.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.login: {
                        if(MainActivity.userLoggedExists){
                            Toast.makeText(activity, "You are already logged in !", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            Toast.makeText(activity, "Login !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity, login.class);
                            activity.startActivity(intent);
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                        }
                    }
                    case R.id.logout: {
                        if(MainActivity.userLoggedExists==false){
                            Toast.makeText(activity, "You need to log in !", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            DataBase db = new DataBase(activity);
                            String username=db.userLogged();
                            boolean b = db.updateIntColumn("users", username, "state", 0);
                            Toast.makeText(activity, "Logged out successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity, login.class);
                            activity.startActivity(intent);
                            drawerLayout.closeDrawer(GravityCompat.START);
                            MainActivity.userLoggedExists=false;
                            break;
                        }
                    }
                    case R.id.leaderboard: {
                        Toast.makeText(activity, "here is the leaderboard !", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(activity,results.class);
                        activity.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.ownScore: {
                        if(MainActivity.userLoggedExists==false){
                            Toast.makeText(activity, "You need to log in !", Toast.LENGTH_SHORT).show();
                            break;
                        }else {
                            Toast.makeText(activity, "here is you score !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity, ownScore.class);
                            activity.startActivity(intent);
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                        }
                    }
                    case R.id.guide: {
                        Toast.makeText(activity, "here is the guide !", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(activity,guide.class);
                        activity.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.contact: {
                        Toast.makeText(activity, "Contact us !", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(activity,Contact.class);
                        activity.startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.rateus: {
                        if(MainActivity.userLoggedExists==false){
                            Toast.makeText(activity, "You need to log in !", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(activity, "Rate us !", Toast.LENGTH_SHORT).show();
                            rateUsDialog rateUs = new rateUsDialog(activity);
                            rateUs.getWindow().setBackgroundDrawable(new ColorDrawable(mContext.getResources().getColor(android.R.color.transparent)));
                            rateUs.setCancelable(false);
                            rateUs.show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                        }
                    }
                }
                return false;
            }
        });

    }
}
