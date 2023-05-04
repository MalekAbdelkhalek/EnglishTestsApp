package com.example.english_tests;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class rateUsDialog extends Dialog {
    private Context context;
    private float userRate=0;
    /*public rateUsDialog(@NonNull Context context) {
        super(context);
    }*/

    public rateUsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateus);
        final AppCompatButton rateNow = findViewById(R.id.rateNow);
        final AppCompatButton laterBtn = findViewById(R.id.laterBtn);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final ImageView ratingImage = findViewById(R.id.ratingImage);
        RelativeLayout rate=findViewById(R.id.rate);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating <=1){
                    ratingImage.setImageResource(R.drawable.one_star);
                }
                else if(rating<=2){
                    ratingImage.setImageResource(R.drawable.two_star);
                }
                else if(rating<=3){
                    ratingImage.setImageResource(R.drawable.three_star);
                }
                else if(rating<=4){
                    ratingImage.setImageResource(R.drawable.four_star);
                }
                else if(rating<=5){
                    ratingImage.setImageResource(R.drawable.five_star);
                }

                animateImage(ratingImage);
                userRate=rating;

            }
        });

        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        rateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBase db=new DataBase(context);
                String username;
                if (signUp.come_from_SignUp==true) {
                    username = signUp.eun.getText().toString();
                } else if (MainActivity.come_from_Main==true){
                    username = MainActivity.name;
                }else{
                    username = login.eun.getText().toString();
                }
                //Toast.makeText(context, username, Toast.LENGTH_SHORT).show();

                boolean b=db.updateRealColumn("users",username,"rate",userRate);
                if(b==true){
                    Toast.makeText(context, "Thank you!", Toast.LENGTH_SHORT).show();
                    dismiss();
                }else{
                    Toast.makeText(context, "failed to rate !", Toast.LENGTH_SHORT).show();
                    dismiss();
                }

            }

        });

    }

    private void animateImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation= new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);

    }
}
