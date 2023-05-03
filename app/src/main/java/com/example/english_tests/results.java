package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class results extends AppCompatActivity {
    DataBase db;
    ArrayList<String> name;
    ArrayList<Integer> l1,l2,l3,l4,l5,lo,rank;
    ArrayList<byte[]> user_image;
    RecyclerView rv;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        name = new ArrayList<>();
        l1 = new ArrayList<>();l2 = new ArrayList<>();l3 = new ArrayList<>();l4 = new ArrayList<>();l5 = new ArrayList<>();lo = new ArrayList<>();rank = new ArrayList<>();
        user_image = new ArrayList<>();
        db=new DataBase(this);
        rv=findViewById(R.id.rv);
        Integer n=db.getNumberOfUsers();

        for (int i = 1; i <= n; i++) {
            rank.add(i);
        }

        StoreData();
        customAdapter= new CustomAdapter(results.this, name, l1,l2,l3,l4,l5,lo ,user_image,rank );
        rv.setAdapter(customAdapter);
        rv.setLayoutManager(new LinearLayoutManager(results.this));

    }
    @SuppressLint("Range")
    void StoreData() {
        Cursor cursor = db.readAlldata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data !", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(cursor.getColumnIndex("name")));
                l1.add(cursor.getInt(cursor.getColumnIndex("right_answers1")));
                l2.add(cursor.getInt(cursor.getColumnIndex("right_answers2")));
                l3.add(cursor.getInt(cursor.getColumnIndex("right_answers3")));
                l4.add(cursor.getInt(cursor.getColumnIndex("right_answers4")));
                l5.add(cursor.getInt(cursor.getColumnIndex("right_answers5")));
                lo.add(cursor.getInt(cursor.getColumnIndex("overall")));
                user_image.add(cursor.getBlob(cursor.getColumnIndex("image")));
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
        Intent i = new Intent(results.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}