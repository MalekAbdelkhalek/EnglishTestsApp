package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextInputEditText efn=findViewById(R.id.efn);
        TextInputEditText eln=findViewById(R.id.eln);
        TextInputEditText ee=findViewById(R.id.ee);
        TextInputEditText em=findViewById(R.id.em);
        DataBase db=new DataBase(this);


        Button bs=findViewById(R.id.bs);


        //fire base
        FirebaseApp.initializeApp(this);
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef=databaseRef.child("contact").push();



        efn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    eln.requestFocus(); // move focus to next EditText
                    return true;
                }
                return false;
            }
        });
        DatabaseReference finalDatabaseRef = databaseRef;
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName=efn.getText().toString();
                String lastName=eln.getText().toString();
                String email=ee.getText().toString();
                String message=em.getText().toString();
                if (firstName.equals("") || lastName.equals("") || email.equals("") || message.equals("")){
                    Toast.makeText(Contact.this, "Every field should be filled !", Toast.LENGTH_SHORT).show();
                }
                else{
                    String emailTrim = ee.getText().toString().trim();
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        Toast.makeText(Contact.this, "Please enter the email correctly !", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        //boolean b=db.insertMessage(firstName,lastName,email,message);
                        //fire base insertion
                        contactMessage newMessage = new contactMessage(firstName,lastName,email,message);
                        finalDatabaseRef.setValue(newMessage);


                            Toast.makeText(Contact.this, "Message sent successfully !", Toast.LENGTH_SHORT).show();


                    }

                }

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(Contact.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}