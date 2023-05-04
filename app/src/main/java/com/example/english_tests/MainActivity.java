package com.example.english_tests;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public static String name;
    public static boolean come_from_Main=false;
    public static boolean userLoggedExists=false,ownScoreValidation=false;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* RelativeLayout MainActivity=findViewById(R.id.MainActivity);
        MainActivity.setBackgroundResource(R.drawable.acceuil_page);*/

        Button bgs= findViewById(R.id.bgs);
        DataBase db= new DataBase(this);
        //boolean userLogged=db.checkUserLogged();
        name=db.userLogged();

        if(name!=""){
            userLoggedExists=true;
            ownScoreValidation=true;
            come_from_Main = true;

        }
        //Toast.makeText(this, name+come_from_Main, Toast.LENGTH_SHORT).show();
       bgs.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //db.updateIntColumn("users","mouheb","state",1);
               //db.updateIntColumn("users","malek","state",0);
               //db.updateIntColumn("users","hamadi","state",0);
              // db.updateIntColumn("users","ll","state",0);
               //db.updateIntColumn("users","lll","state",0);



            if(userLoggedExists==false){
                 Intent intent= new Intent(MainActivity.this,login.class);
                 startActivity(intent);
               }
            else {
                  if (db.getIntColumn("users", "level_reached", name) > 5) {
                      Toast.makeText(MainActivity.this, "You already finished the game!", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(MainActivity.this, theEnd.class);
                      startActivity(intent);
                }
                  else {
                    come_from_Main = true;
                    Intent intent = new Intent(MainActivity.this, levels.class);
                    startActivity(intent);
                }
              }


               /*rateUsDialog rateUs = new rateUsDialog(MainActivity.this);
               rateUs.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
               rateUs.setCancelable(false);
               rateUs.show();*/



       /*  boolean b = db.deleteRow("SS");
               if(b==true){
                  Toast.makeText(MainActivity.this, "added", Toast.LENGTH_SHORT).show();
              }else{
                  Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
              }*/


           }
       });
        drawerLayout=findViewById(R.id.drawer);
        NavigationView navview=findViewById(R.id.navview);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        DrawerUtil drawerUtil = new DrawerUtil(this);
        drawerUtil.setDrawer(this,drawerLayout,navview,drawerToggle);
    }
}