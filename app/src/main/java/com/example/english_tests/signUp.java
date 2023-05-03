package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.core.view.GravityCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class signUp extends AppCompatActivity {
    Button bc;
    DataBase db;
    private static final int PICK_IMAGE_REQUEST = 99;
    public static boolean come_from_SignUp=false;
    private Uri imagePath;
    private Bitmap imageToStore;
    byte[] imageByteArray;
    ImageView img;
    EditText eb, ep, er;
    public static EditText eun;
    RadioButton male, female;
    String ug, m;
    Boolean Rischecked=false;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        RelativeLayout signUp=findViewById(R.id.signUp);
        //signUp.setBackgroundResource(R.drawable.signup);*/
        eun = findViewById(R.id.eun);
        eb = findViewById(R.id.eb);
        ep = findViewById(R.id.ep);
        er = findViewById(R.id.er);
        bc = findViewById(R.id.bc);
        db = new DataBase(this);
        img = findViewById(R.id.img);
        eun.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    eb.requestFocus(); // move focus to next EditText
                    return true;
                }
                return false;
            }
        });

        RadioButton male=findViewById(R.id.male),female=findViewById(R.id.female);


            ColorStateList colorStateListBorders = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[] {getResources().getColor(R.color.borders) }
        );
        TextInputLayout tfr=findViewById(R.id.tfr);
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

        er.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    // Hide the left drawable
                    er.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                    // Show the password toggle
                    tfr.setPasswordVisibilityToggleEnabled(true);
                } else {
                    // Restore the left drawable
                    er.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_password, 0, 0, 0);

                    // Hide the password toggle
                    tfr.setPasswordVisibilityToggleEnabled(false);

                }
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setTextColor(getResources().getColor(R.color.purple_500));
                male.setButtonTintList(colorStateListBorders);
                male.setTextColor(getResources().getColor(R.color.black));
                m = "Mr";
                ug = "male";
                Rischecked = true;
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setTextColor(getResources().getColor(R.color.purple_500));
                female.setButtonTintList(colorStateListBorders);
                female.setTextColor(getResources().getColor(R.color.black));
                m = "Mrs";
                ug = "female";
                Rischecked = true;
            }
        });
        TextInputLayout tfb=findViewById(R.id.tfb);
        eb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        eb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chooseImg();
            }
        }); // inserting an image from the gallery
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eun.getText().toString();
                String pass = ep.getText().toString();
                String repass = er.getText().toString();
                String birth = eb.getText().toString();
                String age = null;
                try {
                    age = calculateAge(birth);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                String gender = ug;
                if (name.equals("") || birth.equals("") || pass.equals("") || repass.equals("") || Rischecked == false || img.getDrawable() == null || imageToStore == null) {
                    Toast.makeText(signUp.this, "Every field should be filled !", Toast.LENGTH_SHORT).show();
                } else {
                   if(name.length()<=16) {
                       if (age != null) {
                           if(pass.length()>=8 && pass.length()<=24){
                               if (pass.equals(repass)) {
                                   boolean checkuser = db.checkUsername(name);
                                   if (checkuser == false) {
                                       boolean insert = db.insertUser(name, pass, birth, age, gender, imageByteArray, 1,0,0,0,0,0,0,1,0);
                                       boolean insertProgress1 = db.insertUserProgress1(name, "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", 0, 0, 0, 0, 0);
                                       boolean insertProgress2 = db.insertUserProgress2(name, "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", 0, 0, 0, 0, 0);
                                       boolean insertProgress3 = db.insertUserProgress3(name, "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", 0, 0, 0, 0, 0);
                                       boolean insertProgress4 = db.insertUserProgress4(name, "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", 0, 0, 0, 0, 0);
                                       boolean insertProgress5 = db.insertUserProgress5(name, "NaN", "NaN", "NaN", "NaN", "NaN", "NaN","NaN","NaN","NaN","NaN",0, 0, 0, 0, 0);

                                       if (insertProgress1 == true && insertProgress2 == true && insertProgress3 == true && insertProgress4 == true && insert == true /*&& insertProgress5 == true*/) {
                                           Toast.makeText(signUp.this, "signUp successfully !", Toast.LENGTH_SHORT).show();
                                           Intent intent = new Intent(getApplicationContext(), guide.class);
                                           startActivity(intent);
                                           come_from_SignUp=true;
                                 /*else {
                                    Toast.makeText(signUp.this, "Failed to save the user progress", Toast.LENGTH_SHORT).show();
                                }*/
                                       } else {
                                           Toast.makeText(signUp.this, "Failed to save the user informations !", Toast.LENGTH_SHORT).show();
                                       }
                                   } else {
                                       Toast.makeText(signUp.this, "User already exists !", Toast.LENGTH_SHORT).show();
                                   }
                               } else {
                                   Toast.makeText(signUp.this, "Passwords not matching !", Toast.LENGTH_SHORT).show();
                               }
                           }else if (pass.length()<8){
                               Toast.makeText(signUp.this, "too short password !", Toast.LENGTH_SHORT).show();
                           }else{
                               Toast.makeText(signUp.this, "too long password !", Toast.LENGTH_SHORT).show();
                           }
                       } else {
                           Toast.makeText(signUp.this, "Invalid date format !", Toast.LENGTH_SHORT).show();
                       }
                   }

                else{
                    Toast.makeText(signUp.this, "too long username !", Toast.LENGTH_SHORT).show();
                }
                   }}
                   });
    }

    private void chooseImg() {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {

            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                int desiredWidth = 600;
                int desiredHeight = 600;

                Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageToStore, desiredWidth, desiredHeight, false);
                Resources res = getResources();
                Drawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(res, resizedBitmap);
                ((RoundedBitmapDrawable) roundedBitmapDrawable).setCornerRadius(100f);

                img.setImageDrawable(roundedBitmapDrawable);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                imageByteArray = byteArrayOutputStream.toByteArray();

            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    public String calculateAge(String birthdayStr) throws ParseException {
        if (birthdayStr == null || birthdayStr.isEmpty()) {
            return null; // or return some default value or display an error message
        }

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Date format
        formatter.setLenient(false); // Do not allow lenient parsing
        Date birthday = null;
        Boolean b=false;
        try {
            birthday = formatter.parse(birthdayStr);
            b = true;// Parse the string into a Date object
        } catch (ParseException e) {
            Toast.makeText(this, "Invalid date format", Toast.LENGTH_SHORT).show();
              }
        if(b==true){
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthday);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return Integer.toString(age);}
        else{
            return null;
        }
    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                signUp.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String birthday = dayOfMonth + "/" + (month + 1) + "/" + year;
                        eb.setText(birthday);
                    }
                }, year, month, day);

        datePickerDialog.updateDate(1990, 0, 1);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String birthday = ((DatePicker) datePickerDialog.getDatePicker()).getDayOfMonth() + "/" + (((DatePicker) datePickerDialog.getDatePicker()).getMonth() + 1) + "/" + ((DatePicker) datePickerDialog.getDatePicker()).getYear();
                eb.setText(birthday);
                dialog.dismiss();
                ep.requestFocus();
            }
        });
        datePickerDialog.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(signUp.this,MainActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    }