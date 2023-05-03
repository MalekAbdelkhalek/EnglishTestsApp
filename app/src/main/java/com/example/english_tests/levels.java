package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class levels extends AppCompatActivity {
    public static Button l1,l2,l3,l4,l5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        /*RelativeLayout levels = findViewById(R.id.levels);
        levels.setBackgroundResource(R.drawable.levels);*/


        boolean e = getIntent().getBooleanExtra("button_enabled",false);
        boolean d = getIntent().getBooleanExtra("button_disabled",true);

         l1=findViewById(R.id.l1);
         l2=findViewById(R.id.l2);
         l3=findViewById(R.id.l3);
         l4=findViewById(R.id.l4);
         l5=findViewById(R.id.l5);
         DataBase db=new DataBase(this);

         setLenable(db);




        //l1.setEnabled(false);
         //l2.setEnabled(true);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(levels.this,level_1.class);
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(levels.this,level_2.class);
                     startActivity(intent);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(levels.this,level_3.class);
                startActivity(intent);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(levels.this,level_4.class);
                startActivity(intent);
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(levels.this,level_5.class);
                startActivity(intent);
            }
        });
    }
    public void setLenable(DataBase db){
        String user;
        //String textLogin = login.eun.getText().toString().trim();
        //String textSignin = login.eun.getText().toString().trim();

       // String textMain=MainActivity.name;
        /*if (TextUtils.isEmpty(textLogin) && textMain.equals("")) {
            user = signUp.eun.getText().toString();
        } else if (TextUtils.isEmpty(textLogin) && (TextUtils.isEmpty(textSignin))){
            user = MainActivity.name;
        }else{
            user = login.eun.getText().toString();
        }*/
         if (login.come_from_Login==false && MainActivity.come_from_Main==false) {
            user = signUp.eun.getText().toString();
        } else if (login.come_from_Login==false && signUp.come_from_SignUp==false){
            user = MainActivity.name;
        }else{
            user = login.eun.getText().toString();
        }
        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.l4);
        l5=findViewById(R.id.l5);
        if (db.getIntColumn("users", "level_reached", user) == 1) {
            l1.setEnabled(true);
            l2.setEnabled(false);
            l3.setEnabled(false);
            l4.setEnabled(false);
            l5.setEnabled(false);
        }else if(db.getIntColumn("users", "level_reached", user) == 2){
            l1.setEnabled(false);
            l2.setEnabled(true);
            l3.setEnabled(false);
            l4.setEnabled(false);
            l5.setEnabled(false);
        }
        else if(db.getIntColumn("users", "level_reached", user) == 3){
            l1.setEnabled(false);
            l2.setEnabled(false);
            l3.setEnabled(true);
            l4.setEnabled(false);
            l5.setEnabled(false);
        }
        else if(db.getIntColumn("users", "level_reached", user) == 4){
            l1.setEnabled(false);
            l2.setEnabled(false);
            l3.setEnabled(false);
            l4.setEnabled(true);
            l5.setEnabled(false);
        }else{
            l1.setEnabled(false);
            l2.setEnabled(false);
            l3.setEnabled(false);
            l4.setEnabled(false);
            l5.setEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(levels.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }

}