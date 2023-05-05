package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class login extends AppCompatActivity {
    public static Button bc,bs,bn;
    TextInputEditText ep,eun2,eb2;
    public static TextInputEditText eun;
    public static boolean come_from_Login=false;
    DataBase db;
    TextView tf,tp,ts;
    CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*RelativeLayout login = findViewById(R.id.login);
        login.setBackgroundResource(R.drawable.login);*/
        bc = findViewById(R.id.bl);
        eun = findViewById(R.id.eun);
        ep = findViewById(R.id.ep);
        db = new DataBase(this);
        eun.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    ep.requestFocus(); // move focus to next EditText
                    return true;
                }
                return false;
            }
        });
        TextInputLayout tfp=findViewById(R.id.tfp);
        ep.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    // Hide the left drawable
                    ep.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                    // Show the password toggle
                    tfp.setPasswordVisibilityToggleEnabled(true);
                } else {
                    // Restore the left drawable
                    ep.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_password, 0, 0, 0);

                    // Hide the password toggle
                    tfp.setPasswordVisibilityToggleEnabled(false);

                }
            }
        });



        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = eun.getText().toString();
                String pass = ep.getText().toString();
                String name=db.userLogged();
                if (name != "") {
                    Toast.makeText(login.this, "You are already logged in !", Toast.LENGTH_SHORT).show();
                } else {
                    if (user.equals("") || pass.equals("")) {
                        Toast.makeText(login.this, "Every field should be filled !", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean checkuserpassword = db.checkNamePassword(user, pass);
                        if (checkuserpassword == true) {
                            db.updateIntColumn("users", user, "state", 1);
                            MainActivity.userLoggedExists = true;
                            come_from_Login = true;
                            if (db.getIntColumn("users", "level_reached", user) > 5) {
                                Toast.makeText(login.this, "You already finished the game!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(login.this, theEnd.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(login.this, "login successfully !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login.this, levels.class);
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(login.this, "Invalid informations !", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });
        ep.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    bc.performClick();
                    return true;
                }
                return false;
            }
        });
        tf=findViewById(R.id.tf);
        eun2=findViewById(R.id.eun2);
        eb2=findViewById(R.id.eb2);
        tp=findViewById(R.id.tp);
        card=findViewById(R.id.card);
        ts=findViewById(R.id.ts);
        ts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),signUp.class);
                startActivity(intent);
            }
        });

        tf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setVisibility(view.VISIBLE);
                eun.setText("");
                ep.setText("");

            }
        });
        eun2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    eb2.requestFocus(); // move focus to next EditText
                    return true;
                }
                return false;
            }
        });
        bs=findViewById(R.id.bs);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=eun2.getText().toString();
                String birth=eb2.getText().toString();
                if(user.equals("")||birth.equals("")){
                    Toast.makeText(login.this, "Every field should be filled !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserbirthday = db.checkNameBirthday(user, birth);
                    if (checkuserbirthday == true){
                        String pass=db.selectPasswordByBirthday(birth,user);
                        tp.setText("Your password is :  "+pass);
                        tp.setVisibility(view.VISIBLE);
                        eun.setText(user);
                        ep.setText(pass);
                        bn.setEnabled(true);
                    }
                    else{
                        Toast.makeText(login.this, "Invalid informations !", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        eb2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            boolean ageFocused = false;
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus && !ageFocused) {
                    showDatePickerDialog();
                    ageFocused = true;
                } else if (!hasFocus) {
                    ageFocused = false;
                }
            }
        });
        eb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        FloatingActionButton pre=findViewById(R.id.pre);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setVisibility(View.INVISIBLE);
                eun2.setText("");
                eb2.setText("");
                tp.setText("Your password will be displayed right here !");
            }
        });
        bn=findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setVisibility(View.INVISIBLE);
                eun2.setText("");
                eb2.setText("");
                tp.setText("Your password will be displayed right here !");
                bn.setEnabled(false);
            }
        });

    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                login.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String birthday = dayOfMonth + "/" + (month + 1) + "/" + year;
                        eb2.setText(birthday);
                    }
                }, year, month, day);

        datePickerDialog.updateDate(1990, 0, 1);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(login.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}
