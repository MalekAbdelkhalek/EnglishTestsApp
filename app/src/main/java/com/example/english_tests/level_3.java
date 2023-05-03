package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class level_3 extends level_1 {
    RadioButton er, erI, erII, t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        /*RelativeLayout level_3=findViewById(R.id.level_3);
        level_3.setBackgroundResource(R.drawable.bg_levels);*/
        DataBase db=new DataBase(this);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);

        /*cards*/
        CardView card1 = findViewById(R.id.card1), card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5), result = findViewById(R.id.result),
                card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8), card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);

        if (getCountByUser(db,"users_progress_level3") == 0) {
            /*1*/
            setRadioButtons(db,"users_progress_level3");
            card1.setVisibility(View.VISIBLE);
            setCard1(db);setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level3") == 1) {
            /*2*/
            setRadioButtons(db,"users_progress_level3");
            card2.setVisibility(View.VISIBLE);
            setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level3") == 2) {
            /*3*/
            setRadioButtons(db,"users_progress_level3");
            card3.setVisibility(View.VISIBLE);
            setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level3") == 3) {
            /*4*/
            setRadioButtons(db,"users_progress_level3");
            card4.setVisibility(View.VISIBLE);
            setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);

        } else if (getCountByUser(db,"users_progress_level3") == 4) {
            /*5*/
            setRadioButtons(db,"users_progress_level3");
            card5.setVisibility(View.VISIBLE);
            setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 5) {
            /*5*/
            setRadioButtons(db,"users_progress_level3");
            card6.setVisibility(View.VISIBLE);
            setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 6) {
            /*5*/
            setRadioButtons(db,"users_progress_level3");
            card7.setVisibility(View.VISIBLE);
            setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 7) {
            /*5*/
            setRadioButtons(db,"users_progress_level3");
            card8.setVisibility(View.VISIBLE);
            setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 8) {
            /*5*/
            setRadioButtons(db,"users_progress_level3");
            card9.setVisibility(View.VISIBLE);
            setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 9) {
            /*5*/
            setRadioButtons(db, "users_progress_level3");
            card10.setVisibility(View.VISIBLE);
            setCard10(db);
        }else if (getCountByUser(db,"users_progress_level3") == 10) {
            /*5*/
            setRadioButtons(db, "users_progress_level3");
            card10.setVisibility(View.VISIBLE);
            setCard10(db);}

        setNextLevel(db);


    }
    public void setCard1(DataBase db) {
        CardView card1 = findViewById(R.id.card1), card2 = findViewById(R.id.card2);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta1=findViewById(R.id.ta1);
        RadioButton n1 = findViewById(R.id.n1);
        FloatingActionButton pre1 = findViewById(R.id.pre1);
        Button bs1 = findViewById(R.id.bs1), bn1 = findViewById(R.id.bn1), bh1 = findViewById(R.id.bh1), bt1 = findViewById(R.id.bt1), bo1 = findViewById(R.id.bo1);
        EditText e1 = findViewById(R.id.e1);
        RadioGroup ch1 = findViewById(R.id.ch1), sg1 = findViewById(R.id.sg1);
        RadioButton l1 = findViewById(R.id.l1), sgg1 = findViewById(R.id.sgg1), fl1 = findViewById(R.id.fl1);
        RadioButton sf1 = findViewById(R.id.sf1), ss1 = findViewById(R.id.ss1), st1 = findViewById(R.id.st1);
        TextView mh1 = findViewById(R.id.mh1);
        int randomImageId11 = chooseRandomImage(R.drawable.giraffe, R.drawable.giraffe2, R.drawable.giraffe3);
        int randomImageId12 = chooseRandomImage(R.drawable.bear, R.drawable.bear2, R.drawable.bear3);
        int randomTopicId1 = choose2RandomTopic(randomImageId11, randomImageId12);
        ImageView img1 = findViewById(R.id.img1);
        img1.setImageResource(randomTopicId1);
        if (randomTopicId1 == R.drawable.giraffe || randomTopicId1 == R.drawable.giraffe2 || randomTopicId1 == R.drawable.giraffe3) {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers3",ta1, "giraffe", "_ _ _ _ _ _ _", "g", "The first letter is G", "The length of the word is 7", mh1,tr3, n1, "giraffe", "girafe", "girrafe", card1, card2, db, "question_1", "users_progress_level3");
        } else {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers3",ta1, "bear", "_ _ _ _", "b", "The first letter is B", "The length of the word is 4", mh1,tr3, n1, "beer", "bear", "byar", card1, card2, db, "question_1", "users_progress_level3");
        }
    }
    public void setCard2(DataBase db) {
        CardView card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta2=findViewById(R.id.ta2);
        RadioButton n2 = findViewById(R.id.n2);
        FloatingActionButton pre2 = findViewById(R.id.pre2);
        Button bs2 = findViewById(R.id.bs2), bn2 = findViewById(R.id.bn2), bh2 = findViewById(R.id.bh2), bt2 = findViewById(R.id.bt2), bo2 = findViewById(R.id.bo2);
        EditText e2 = findViewById(R.id.e2);
        RadioGroup ch2 = findViewById(R.id.ch2), sg2 = findViewById(R.id.sg2);
        RadioButton l2 = findViewById(R.id.l2), sgg2 = findViewById(R.id.sgg2), fl2 = findViewById(R.id.fl2);
        RadioButton sf2 = findViewById(R.id.sf2), ss2 = findViewById(R.id.ss2), st2 = findViewById(R.id.st2);
        TextView mh2 = findViewById(R.id.mh2);
        int randomImageId21 = chooseRandomImage(R.drawable.peach, R.drawable.peach2, R.drawable.peach3);
        int randomImageId22 = chooseRandomImage(R.drawable.pomegranate, R.drawable.pomegranate2, R.drawable.pomegranate3);
        int randomImageId23 = chooseRandomImage(R.drawable.mango, R.drawable.mango2, R.drawable.mango3);
        int randomTopicId2 = choose3RandomTopic(randomImageId21, randomImageId22, randomImageId23);
        ImageView img2 = findViewById(R.id.img2);
        img2.setImageResource(randomTopicId2);
        if (randomTopicId2 == R.drawable.peach || randomTopicId2 == R.drawable.peach2 || randomTopicId2 == R.drawable.peach3) {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers3",ta2, "peach", "_ _ _ _ _", "p", "The first letter is P", "The length of the word is 5", mh2,tr3, n2, "peech", "beach", "peach", card2, card3, db, "question_2", "users_progress_level3");
        } else if (randomTopicId2 == R.drawable.pomegranate || randomTopicId2 == R.drawable.pomegranate2 || randomTopicId2 == R.drawable.pomegranate3) {
                setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers3",ta2, "pomegranate", "_ _ _ _ _ _ _ _ _ _ _", "p", "The first letter is P", "The length of the word is 11", mh2,tr3, n2, "pomegranate", "pomegrenade", "grenade", card2, card3, db, "question_2", "users_progress_level3");
        } else {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers3",ta2, "mango", "_ _ _ _ _", "m", "The first letter is M", "The length of the word is 5", mh2,tr3, n2, "mangou", "mango", "mangoo", card2, card3, db, "question_2", "users_progress_level3");
        }

    }
    public void setCard3(DataBase db) {
        CardView card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta3=findViewById(R.id.ta3);
        RadioButton n3 = findViewById(R.id.n3);
        FloatingActionButton pre3 = findViewById(R.id.pre3);
        Button bs3 = findViewById(R.id.bs3), bn3 = findViewById(R.id.bn3), bh3 = findViewById(R.id.bh3), bt3 = findViewById(R.id.bt3), bo3 = findViewById(R.id.bo3);
        EditText e3 = findViewById(R.id.e3);
        RadioGroup ch3 = findViewById(R.id.ch3), sg3 = findViewById(R.id.sg3);
        RadioButton l3 = findViewById(R.id.l3), sgg3 = findViewById(R.id.sgg3), fl3 = findViewById(R.id.fl3);
        RadioButton sf3 = findViewById(R.id.sf3), ss3 = findViewById(R.id.ss3), st3 = findViewById(R.id.st3);
        TextView mh3 = findViewById(R.id.mh3);
        int randomImageId31 = chooseRandomImage(R.drawable.corn, R.drawable.corn2, R.drawable.corn3);
        int randomImageId33 = chooseRandomImage(R.drawable.eggplant, R.drawable.eggplant2, R.drawable.eggplant3);
        int randomImageId32 = chooseRandomImage(R.drawable.pumpkin1, R.drawable.pumpkin2, R.drawable.pumpkin3);
        int randomTopicId3 = choose3RandomTopic(randomImageId31, randomImageId33, randomImageId32);
        ImageView img3 = findViewById(R.id.img3);
        img3.setImageResource(randomTopicId3);
        if (randomTopicId3 == R.drawable.corn || randomTopicId3 == R.drawable.corn2 || randomTopicId3 == R.drawable.corn3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers3",ta3, "corn", "_ _ _ _", "C", "The first letter is C", "The length of the word is 4", mh3,tr3, n3, "carn", "curn", "corn", card3, card4, db, "question_3", "users_progress_level3");
        } else if (randomTopicId3 == R.drawable.eggplant || randomTopicId3 == R.drawable.eggplant2 || randomTopicId3 == R.drawable.eggplant3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers3",ta3, "eggplant", "_ _ _ _ _ _ _ _", "e", "The first letter is E", "The length of the word is 8", mh3,tr3, n3, "egplant", "eggplant", "eggplont", card3, card4, db, "question_3", "users_progress_level3");
        } else {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers3",ta3, "pumpkin", "_ _ _ _ _ _ _", "p", "The first letter is P", "The length of the word is 7", mh3,tr3, n3, "pampkin", "pompkin", "pumpkin", card3, card4, db, "question_3", "users_progress_level3");
        }

    }
    public void setCard4(DataBase db) {
        CardView card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta4=findViewById(R.id.ta4);
        RadioButton n4 = findViewById(R.id.n4);
        FloatingActionButton pre4 = findViewById(R.id.pre4);
        Button bs4 = findViewById(R.id.bs4), bn4 = findViewById(R.id.bn4), bh4 = findViewById(R.id.bh4), bt4 = findViewById(R.id.bt4), bo4 = findViewById(R.id.bo4);
        EditText e4 = findViewById(R.id.e4);
        RadioGroup ch4 = findViewById(R.id.ch4), sg4 = findViewById(R.id.sg4);
        RadioButton l4 = findViewById(R.id.l4), sgg4 = findViewById(R.id.sgg4), fl4 = findViewById(R.id.fl4);
        RadioButton sf4 = findViewById(R.id.sf4), ss4 = findViewById(R.id.ss4), st4 = findViewById(R.id.st4);
        TextView mh4 = findViewById(R.id.mh4);
        int randomImageId41 = chooseRandomImage(R.drawable.sandiwch, R.drawable.sandiwch2, R.drawable.sandiwch3);
        int randomImageId42 = chooseRandomImage(R.drawable.chicken, R.drawable.chicken2, R.drawable.chicken3);
        int randomTopicId4 = choose2RandomTopic(randomImageId41, randomImageId42);
        ImageView img4 = findViewById(R.id.img4);
        img4.setImageResource(randomTopicId4);
        if (randomTopicId4 == R.drawable.sandiwch || randomTopicId4 == R.drawable.sandiwch2 || randomTopicId4 == R.drawable.sandiwch3) {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers3",ta4, "sandwich", "_ _ _ _ _ _ _ _ _", "h", "The first letter is H", "The length of the word is 9", mh4,tr3, n4, "sandwich", "sandwitch", "sandwish", card4, card5, db, "question_4", "users_progress_level3");
        } else  {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers3",ta4, "chicken", "_ _ _ _ _ _ _", "c", "The first letter is C", "The length of the word is 7", mh4,tr3, n4, "chikcen", "chicken", "chiken", card4, card5, db, "question_4", "users_progress_level3");
        }

    }
    public void setCard5(DataBase db) {
        CardView card5 = findViewById(R.id.card5), card6 = findViewById(R.id.card6);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta5=findViewById(R.id.ta5);
        RadioButton n5 = findViewById(R.id.n5);
        FloatingActionButton pre5 = findViewById(R.id.pre5);
        Button bs5 = findViewById(R.id.bs5), bn5 = findViewById(R.id.bn5), bh5 = findViewById(R.id.bh5), bt5 = findViewById(R.id.bt5), bo5 = findViewById(R.id.bo5);
        EditText e5 = findViewById(R.id.e5);
        RadioGroup ch5 = findViewById(R.id.ch5), sg5 = findViewById(R.id.sg5);
        RadioButton l5 = findViewById(R.id.l5), sgg5 = findViewById(R.id.sgg5), fl5 = findViewById(R.id.fl5);
        RadioButton sf5 = findViewById(R.id.sf5), ss5 = findViewById(R.id.ss5), st5 = findViewById(R.id.st5);
        TextView mh5 = findViewById(R.id.mh5);
        int randomImageId51 = chooseRandomImage(R.drawable.blender, R.drawable.blender2, R.drawable.blender3);
        int randomImageId52 = chooseRandomImage(R.drawable.iron, R.drawable.iron2, R.drawable.iron3);
        int randomTopicId5 = choose2RandomTopic(randomImageId51, randomImageId52);
        ImageView img5 = findViewById(R.id.img5);
        img5.setImageResource(randomTopicId5);
        if (randomTopicId5 == R.drawable.blender || randomTopicId5 == R.drawable.blender2 || randomTopicId5 == R.drawable.blender3) {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers3",ta5, "blender", "_ _ _ _ _ _ _" , "b", "The first letter is B", "The length of the word is 7", mh5,tr3, n5, "blander", "blender", "blunder", card5, card6, db, "question_5", "users_progress_level3");
        } else {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers3",ta5, "iron", "_ _ _ _", "i", "The first letter is I", "The length of the word is 4", mh5,tr3, n5, "iron", "iran", "irun", card5, card6, db, "question_5", "users_progress_level3");
        }
    }

    public void setCard6(DataBase db) {
        CardView card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta6=findViewById(R.id.ta6);
        RadioButton n6 = findViewById(R.id.n6);
        FloatingActionButton pre6 = findViewById(R.id.pre6);
        Button bs6 = findViewById(R.id.bs6), bn6 = findViewById(R.id.bn6), bh6 = findViewById(R.id.bh6), bt6 = findViewById(R.id.bt6), bo6 = findViewById(R.id.bo6);
        EditText e6 = findViewById(R.id.e6);
        RadioGroup ch6 = findViewById(R.id.ch6), sg6 = findViewById(R.id.sg6);
        RadioButton l6 = findViewById(R.id.l6), sgg6 = findViewById(R.id.sgg6), fl6 = findViewById(R.id.fl6);
        RadioButton sf6 = findViewById(R.id.sf6), ss6 = findViewById(R.id.ss6), st6 = findViewById(R.id.st6);
        TextView mh6 = findViewById(R.id.mh6);
        int randomImageId61 = chooseRandomImage(R.drawable.wrench, R.drawable.wrench2, R.drawable.wrench3);
        ImageView img6 = findViewById(R.id.img6);
        img6.setImageResource(randomImageId61);
        setLayout(pre6, bs6, bn6, bh6, bt6, bo6, e6, ch6, sg6, l6, fl6, sgg6, sf6, ss6, st6, rw, erI, er, erII, t,"right_answers3",ta6, "wrench", "_ _ _ _ _ ", "w", "The first letter is W", "The length of the word is 6", mh6,tr3, n6, "wrench", "rench", "ranch", card6, card7, db, "question_6", "users_progress_level3");


    }
    public void setCard7(DataBase db) {
        CardView card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta7=findViewById(R.id.ta7);
        RadioButton n7 = findViewById(R.id.n7);
        FloatingActionButton pre7 = findViewById(R.id.pre7);
        Button bs7 = findViewById(R.id.bs7), bn7 = findViewById(R.id.bn7), bh7 = findViewById(R.id.bh7), bt7 = findViewById(R.id.bt7), bo7 = findViewById(R.id.bo7);
        EditText e7 = findViewById(R.id.e7);
        RadioGroup ch7 = findViewById(R.id.ch7), sg7 = findViewById(R.id.sg7);
        RadioButton l7 = findViewById(R.id.l7), sgg7 = findViewById(R.id.sgg7), fl7 = findViewById(R.id.fl7);
        RadioButton sf7 = findViewById(R.id.sf7), ss7 = findViewById(R.id.ss7), st7 = findViewById(R.id.st7);
        TextView mh7 = findViewById(R.id.mh7);
        int randomImageId71 = chooseRandomImage(R.drawable.belt, R.drawable.belt2, R.drawable.belt3);
        int randomImageId72 = chooseRandomImage(R.drawable.sneakers, R.drawable.sneakers2, R.drawable.sneakers3);
        int randomTopicId7 = choose2RandomTopic(randomImageId71, randomImageId72);
        ImageView img7 = findViewById(R.id.img7);
        img7.setImageResource(randomTopicId7);
        if (randomTopicId7 == R.drawable.belt || randomTopicId7 == R.drawable.belt2 || randomTopicId7 == R.drawable.belt3) {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers3",ta7, "belt", "_ _ _ _", "b", "The first letter is B", "The length of the word is 4", mh7,tr3, n7, "bolt", "bult", "belt", card7, card8, db, "question_7", "users_progress_level3");
        }  else {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers3",ta7, "sneakers", "_ _ _ _ _ _ _ _", "s", "The first letter is S", "The length of the word is 8", mh7,tr3, n7, "sneekers", "sneakers", "sneikers", card7, card8, db, "question_7", "users_progress_level3");
        }

    }
    public void setCard8(DataBase db) {
        CardView card8 = findViewById(R.id.card8), card9= findViewById(R.id.card9);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta8=findViewById(R.id.ta8);
        RadioButton n8 = findViewById(R.id.n8);
        FloatingActionButton pre8 = findViewById(R.id.pre8);
        Button bs8 = findViewById(R.id.bs8), bn8 = findViewById(R.id.bn8), bh8 = findViewById(R.id.bh8), bt8 = findViewById(R.id.bt8), bo8 = findViewById(R.id.bo8);
        EditText e8 = findViewById(R.id.e8);
        RadioGroup ch8 = findViewById(R.id.ch8), sg8 = findViewById(R.id.sg8);
        RadioButton l8 = findViewById(R.id.l8), sgg8 = findViewById(R.id.sgg8), fl8 = findViewById(R.id.fl8);
        RadioButton sf8 = findViewById(R.id.sf8), ss8 = findViewById(R.id.ss8), st8 = findViewById(R.id.st8);
        TextView mh8 = findViewById(R.id.mh8);
        int randomImageId81 = chooseRandomImage(R.drawable.drums, R.drawable.drums2, R.drawable.drums3);
        ImageView img8 = findViewById(R.id.img8);
        img8.setImageResource(randomImageId81);
        setLayout(pre8, bs8, bn8, bh8, bt8, bo8, e8, ch8, sg8, l8, fl8, sgg8, sf8, ss8, st8, rw, erI, er, erII, t,"right_answers3",ta8, "drums", "_ _ _ _ _", "d", "The first letter is D", "The length of the word is 5", mh8,tr3, n8, "drums", "drams", "dreams", card8, card9, db, "question_8", "users_progress_level3");

    }
    public void setCard9(DataBase db) {
        CardView card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta9=findViewById(R.id.ta9);
        RadioButton n9 = findViewById(R.id.n9);
        FloatingActionButton pre9 = findViewById(R.id.pre9);
        Button bs9 = findViewById(R.id.bs9), bn9 = findViewById(R.id.bn9), bh9 = findViewById(R.id.bh9), bt9 = findViewById(R.id.bt9), bo9 = findViewById(R.id.bo9);
        EditText e9 = findViewById(R.id.e9);
        RadioGroup ch9 = findViewById(R.id.ch9), sg9 = findViewById(R.id.sg9);
        RadioButton l9 = findViewById(R.id.l9), sgg9 = findViewById(R.id.sgg9), fl9 = findViewById(R.id.fl9);
        RadioButton sf9 = findViewById(R.id.sf9), ss9 = findViewById(R.id.ss9), st9 = findViewById(R.id.st9);
        TextView mh9 = findViewById(R.id.mh9);
        int randomImageId91 = chooseRandomImage(R.drawable.motorcycle, R.drawable.motorcycle2, R.drawable.motorcycle3);
        int randomImageId92 = chooseRandomImage(R.drawable.van, R.drawable.van, R.drawable.van);
        int randomImageId93 = chooseRandomImage(R.drawable.train, R.drawable.train2, R.drawable.train3);
        int randomTopicId9 = choose3RandomTopic(randomImageId91, randomImageId92, randomImageId93);
        ImageView img9 = findViewById(R.id.img9);
        img9.setImageResource(randomTopicId9);
        if (randomTopicId9 == R.drawable.motorcycle || randomTopicId9 == R.drawable.motorcycle2 || randomTopicId9 == R.drawable.motorcycle3) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers3",ta9, "motorcycle", "_ _ _ _ _ _ _ _ _ _", "m", "The first letter is M", "The length of the word is 10", mh9,tr3, n9, "motorcycle", "bicycle", "carcycle", card9, card10, db, "question_9", "users_progress_level3");
        } else if (randomTopicId9 == R.drawable.van || randomTopicId9 == R.drawable.van || randomTopicId9 == R.drawable.van) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers3",ta9, "van", "_ _ _", "v", "The first letter is V", "The length of the word is 3", mh9,tr3, n9, "vam", "van", "var", card9, card10, db, "question_9", "users_progress_level3");
        } else {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers3",ta9, "train", "_ _ _ _ _", "t", "The first letter is T", "The length of the word is 5", mh9,tr3, n9, "entrain", "train", "strain", card9, card10, db, "question_9", "users_progress_level3");
        }

    }
    public void setCard10(DataBase db) {
        CardView card10 = findViewById(R.id.card10), result = findViewById(R.id.result);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr3=findViewById(R.id.tr3),ta10=findViewById(R.id.ta10);
        RadioButton n10 = findViewById(R.id.n10);
        FloatingActionButton pre10 = findViewById(R.id.pre10);
        Button bs10 = findViewById(R.id.bs10), bn10 = findViewById(R.id.bn10), bh10 = findViewById(R.id.bh10), bt10 = findViewById(R.id.bt10), bo10 = findViewById(R.id.bo10);
        EditText e10 = findViewById(R.id.e10);
        RadioGroup ch10 = findViewById(R.id.ch10), sg10 = findViewById(R.id.sg10);
        RadioButton l10 = findViewById(R.id.l10), sgg10 = findViewById(R.id.sgg10), fl10 = findViewById(R.id.fl10);
        RadioButton sf10 = findViewById(R.id.sf10), ss10 = findViewById(R.id.ss10), st10 = findViewById(R.id.st10);
        TextView mh10 = findViewById(R.id.mh10);
        int randomImageId101 = chooseRandomImage(R.drawable.wildfire, R.drawable.wildfire2, R.drawable.wildfire3);
        int randomImageId102 = chooseRandomImage(R.drawable.earthquake, R.drawable.earthquake2, R.drawable.earthquake3);
        int randomTopicId10 = choose2RandomTopic(randomImageId101,randomImageId102);
        ImageView img10 = findViewById(R.id.img10);
        img10.setImageResource(randomTopicId10);
        if (randomTopicId10 == R.drawable.wildfire || randomTopicId10 == R.drawable.wildfire2 || randomTopicId10 == R.drawable.wildfire3) {
            setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers3",ta10, "wildfire", "_ _ _ _ _ _ _ _", "w", "The first letter is W", "The length of the word is 8", mh10,tr3, n10, "treesfire", "wildfire", "forestfire", card10, result, db, "question_10", "users_progress_level3");
        } else {
         setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers3",ta10, "earthquake", "_ _ _ _ _ _ _ _ _ _", "e", "The first letter is E", "The length of the word is 10", mh10,tr3, n10, "earthquake", "earthcake", "earthtake", card10, result, db, "question_10", "users_progress_level3");
        }
       

    }
    public void setNextLevel(DataBase dataBase){
        Button bnl=findViewById(R.id.bnl);
        bnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(level_3.this,levels.class);
                startActivity(intent);
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
        Intent i = new Intent(level_3.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}