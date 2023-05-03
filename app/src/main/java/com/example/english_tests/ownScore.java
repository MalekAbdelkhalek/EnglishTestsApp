package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ownScore extends AppCompatActivity {
    DataBase db;
    Integer l1User,l2User,l3User,l4User,l5User,orUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_score);

        db=new DataBase(this);

        TextView l1=findViewById(R.id.l1);
        TextView l2=findViewById(R.id.l2);
        TextView l3=findViewById(R.id.l3);
        TextView l4=findViewById(R.id.l4);
        TextView l5=findViewById(R.id.l5);
        TextView or=findViewById(R.id.or);

        storeUserScore();
        l1.setText(String.valueOf(l1User));
        l2.setText(String.valueOf(l2User));
        l3.setText(String.valueOf(l3User));
        l4.setText(String.valueOf(l4User));
        l5.setText(String.valueOf(l5User));
        or.setText(String.valueOf(orUser));




    }
    @SuppressLint("Range")
    public void storeUserScore(){
        String username;
        if (login.come_from_Login==false && MainActivity.ownScoreValidation==false) {
            username = signUp.eun.getText().toString();
        } else if (login.come_from_Login==false && signUp.come_from_SignUp==false){
            username = MainActivity.name;
        }else{
            username = login.eun.getText().toString();
        }
        Cursor cursor = db.readUserdata(username);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data !", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                l1User=cursor.getInt(cursor.getColumnIndex("right_answers1"));
                l2User=cursor.getInt(cursor.getColumnIndex("right_answers2"));
                l3User=cursor.getInt(cursor.getColumnIndex("right_answers3"));
                l4User=cursor.getInt(cursor.getColumnIndex("right_answers4"));
                l5User=cursor.getInt(cursor.getColumnIndex("right_answers5"));
                orUser=cursor.getInt(cursor.getColumnIndex("overall"));

            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(ownScore.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
}