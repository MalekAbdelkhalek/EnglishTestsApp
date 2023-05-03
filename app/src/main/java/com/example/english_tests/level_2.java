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

public class level_2 extends level_1 {
    RadioButton er, erI, erII, t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        /*RelativeLayout level_2=findViewById(R.id.level_2);
        level_2.setBackgroundResource(R.drawable.bg_levels);*/
        DataBase db=new DataBase(this);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);

        /*cards*/
        CardView card1 = findViewById(R.id.card1), card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5), result = findViewById(R.id.result),
                card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8), card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);

        if (getCountByUser(db,"users_progress_level2") == 0) {
            /*1*/
            setRadioButtons(db,"users_progress_level2");
            card1.setVisibility(View.VISIBLE);
            setCard1(db);setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level2") == 1) {
            /*2*/
            setRadioButtons(db,"users_progress_level2");
            card2.setVisibility(View.VISIBLE);
            setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level2") == 2) {
            /*3*/
            setRadioButtons(db,"users_progress_level2");
            card3.setVisibility(View.VISIBLE);
            setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level2") == 3) {
            /*4*/
            setRadioButtons(db,"users_progress_level2");
            card4.setVisibility(View.VISIBLE);
            setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);

        } else if (getCountByUser(db,"users_progress_level2") == 4) {
            /*5*/
            setRadioButtons(db,"users_progress_level2");
            card5.setVisibility(View.VISIBLE);
            setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 5) {
            /*5*/
            setRadioButtons(db,"users_progress_level2");
            card6.setVisibility(View.VISIBLE);
            setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 6) {
            /*5*/
            setRadioButtons(db,"users_progress_level2");
            card7.setVisibility(View.VISIBLE);
            setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 7) {
            /*5*/
            setRadioButtons(db,"users_progress_level2");
            card8.setVisibility(View.VISIBLE);
            setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 8) {
            /*5*/
            setRadioButtons(db,"users_progress_level2");
            card9.setVisibility(View.VISIBLE);
            setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 9) {
            /*5*/
            setRadioButtons(db, "users_progress_level2");
            card10.setVisibility(View.VISIBLE);
            setCard10(db);
        }else if (getCountByUser(db,"users_progress_level2") == 10) {
            /*5*/
            setRadioButtons(db, "users_progress_level2");
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
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta1=findViewById(R.id.ta1);
        RadioButton n1 = findViewById(R.id.n1);
        FloatingActionButton pre1 = findViewById(R.id.pre1);
        Button bs1 = findViewById(R.id.bs1), bn1 = findViewById(R.id.bn1), bh1 = findViewById(R.id.bh1), bt1 = findViewById(R.id.bt1), bo1 = findViewById(R.id.bo1);
        EditText e1 = findViewById(R.id.e1);
        RadioGroup ch1 = findViewById(R.id.ch1), sg1 = findViewById(R.id.sg1);
        RadioButton l1 = findViewById(R.id.l1), sgg1 = findViewById(R.id.sgg1), fl1 = findViewById(R.id.fl1);
        RadioButton sf1 = findViewById(R.id.sf1), ss1 = findViewById(R.id.ss1), st1 = findViewById(R.id.st1);
        TextView mh1 = findViewById(R.id.mh1);
        int randomImageId11 = chooseRandomImage(R.drawable.elephant, R.drawable.elephant2, R.drawable.elephant3);
        int randomImageId12 = chooseRandomImage(R.drawable.bird, R.drawable.bird2, R.drawable.bird3);
        int randomImageId13 = chooseRandomImage(R.drawable.lion, R.drawable.lion2, R.drawable.lion3);
        int randomTopicId1 = choose3RandomTopic(randomImageId11, randomImageId12, randomImageId13);
        ImageView img1 = findViewById(R.id.img1);
        img1.setImageResource(randomTopicId1);
        if (randomTopicId1 == R.drawable.elephant || randomTopicId1 == R.drawable.elephant2 || randomTopicId1 == R.drawable.elephant3) {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers2",ta1, "elephant", "_ _ _ _ _ _ _ _", "e", "The first letter is E", "The length of the word is 8", mh1,tr2, n1, "elephant", "alephant", "elefant", card1, card2, db, "question_1", "users_progress_level2");
        } else if (randomTopicId1 == R.drawable.bird || randomTopicId1 == R.drawable.bird2 || randomTopicId1 == R.drawable.bird3) {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers2",ta1, "bird", "_ _ _ _", "b", "The first letter is B", "The length of the word is 4", mh1,tr2, n1, "bord", "bird", "burd", card1, card2, db, "question_1", "users_progress_level2");
        } else {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers2",ta1, "lion", "_ _ _ _", "l", "The first letter is L", "The length of the word is 4", mh1,tr2, n1, "layon", "lian", "lion", card1, card2, db, "question_1", "users_progress_level2");
        }
    }
    public void setCard2(DataBase db) {
        CardView card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta2=findViewById(R.id.ta2);
        RadioButton n2 = findViewById(R.id.n2);
        FloatingActionButton pre2 = findViewById(R.id.pre2);
        Button bs2 = findViewById(R.id.bs2), bn2 = findViewById(R.id.bn2), bh2 = findViewById(R.id.bh2), bt2 = findViewById(R.id.bt2), bo2 = findViewById(R.id.bo2);
        EditText e2 = findViewById(R.id.e2);
        RadioGroup ch2 = findViewById(R.id.ch2), sg2 = findViewById(R.id.sg2);
        RadioButton l2 = findViewById(R.id.l2), sgg2 = findViewById(R.id.sgg2), fl2 = findViewById(R.id.fl2);
        RadioButton sf2 = findViewById(R.id.sf2), ss2 = findViewById(R.id.ss2), st2 = findViewById(R.id.st2);
        TextView mh2 = findViewById(R.id.mh2);
        int randomImageId21 = chooseRandomImage(R.drawable.watermelon, R.drawable.watermelon2, R.drawable.watermelon3);
        int randomImageId22 = chooseRandomImage(R.drawable.strawberry, R.drawable.strawberry2, R.drawable.strawberry3);
        int randomImageId23 = chooseRandomImage(R.drawable.kiwi, R.drawable.kiwi2, R.drawable.kiwi3);
        int randomTopicId2 = choose3RandomTopic(randomImageId21, randomImageId22, randomImageId23);
        ImageView img2 = findViewById(R.id.img2);
        img2.setImageResource(randomTopicId2);
        if (randomTopicId2 == R.drawable.watermelon || randomTopicId2 == R.drawable.watermelon2 || randomTopicId2 == R.drawable.watermelon3) {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers2",ta2, "watermelon", "_ _ _ _ _ _ _ _ _ _", "w", "The first letter is W", "The length of the word is 10", mh2,tr2, n2, "watermelon", "watermon", "watermenon", card2, card3, db, "question_2", "users_progress_level2");
        } else if (randomTopicId2 == R.drawable.strawberry || randomTopicId2 == R.drawable.strawberry2 || randomTopicId2 == R.drawable.strawberry3) {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers2",ta2, "strawberry", "_ _ _ _ _ _ _ _ _ _", "s", "The first letter is S", "The length of the word is 10", mh2,tr2, n2, "strawberry", "strowberry", "strowberri", card2, card3, db, "question_2", "users_progress_level2");
        } else {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers2",ta2, "kiwi", "_ _ _ _", "k", "The first letter is K", "The length of the word is 4", mh2,tr2, n2, "kiwi", "kawa", "kawi", card2, card3, db, "question_2", "users_progress_level2");
        }

    }
    public void setCard3(DataBase db) {
        CardView card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta3=findViewById(R.id.ta3);
        RadioButton n3 = findViewById(R.id.n3);
        FloatingActionButton pre3 = findViewById(R.id.pre3);
        Button bs3 = findViewById(R.id.bs3), bn3 = findViewById(R.id.bn3), bh3 = findViewById(R.id.bh3), bt3 = findViewById(R.id.bt3), bo3 = findViewById(R.id.bo3);
        EditText e3 = findViewById(R.id.e3);
        RadioGroup ch3 = findViewById(R.id.ch3), sg3 = findViewById(R.id.sg3);
        RadioButton l3 = findViewById(R.id.l3), sgg3 = findViewById(R.id.sgg3), fl3 = findViewById(R.id.fl3);
        RadioButton sf3 = findViewById(R.id.sf3), ss3 = findViewById(R.id.ss3), st3 = findViewById(R.id.st3);
        TextView mh3 = findViewById(R.id.mh3);
        int randomImageId31 = chooseRandomImage(R.drawable.onion, R.drawable.onion2, R.drawable.onion3);
        int randomImageId33 = chooseRandomImage(R.drawable.pepper, R.drawable.pepper2, R.drawable.pepper3);
        int randomImageId32 = chooseRandomImage(R.drawable.lettuce, R.drawable.lettuce2, R.drawable.lettuce3);
        int randomTopicId3 = choose3RandomTopic(randomImageId31, randomImageId33, randomImageId32);
        ImageView img3 = findViewById(R.id.img3);
        img3.setImageResource(randomTopicId3);
        if (randomTopicId3 == R.drawable.onion || randomTopicId3 == R.drawable.onion2 || randomTopicId3 == R.drawable.onion3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers2",ta3, "onion", "_ _ _ _ _", "o", "The first letter is O", "The length of the word is 5", mh3,tr2, n3, "aunion", "onion", "nion", card3, card4, db, "question_3", "users_progress_level2");
        } else if (randomTopicId3 == R.drawable.pepper || randomTopicId3 == R.drawable.pepper2 || randomTopicId3 == R.drawable.pepper3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers2",ta3, "pepper", "_ _ _ _ _", "p", "The first letter is P", "The length of the word is 5", mh3,tr2, n3, "peppet", "peper", "pepper", card3, card4, db, "question_3", "users_progress_level2");
        } else {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers2",ta3, "lettuce", "_ _ _ _ _ _ _", "l", "The first letter is L", "The length of the word is 7", mh3,tr2, n3, "lettut", "lettuse", "lettuce", card3, card4, db, "question_3", "users_progress_level2");
        }

    }
    public void setCard4(DataBase db) {
        CardView card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta4=findViewById(R.id.ta4);
        RadioButton n4 = findViewById(R.id.n4);
        FloatingActionButton pre4 = findViewById(R.id.pre4);
        Button bs4 = findViewById(R.id.bs4), bn4 = findViewById(R.id.bn4), bh4 = findViewById(R.id.bh4), bt4 = findViewById(R.id.bt4), bo4 = findViewById(R.id.bo4);
        EditText e4 = findViewById(R.id.e4);
        RadioGroup ch4 = findViewById(R.id.ch4), sg4 = findViewById(R.id.sg4);
        RadioButton l4 = findViewById(R.id.l4), sgg4 = findViewById(R.id.sgg4), fl4 = findViewById(R.id.fl4);
        RadioButton sf4 = findViewById(R.id.sf4), ss4 = findViewById(R.id.ss4), st4 = findViewById(R.id.st4);
        TextView mh4 = findViewById(R.id.mh4);
        int randomImageId41 = chooseRandomImage(R.drawable.hamburger, R.drawable.hamburger2, R.drawable.hamburger3);
        int randomImageId42 = chooseRandomImage(R.drawable.soup, R.drawable.soup2, R.drawable.soup3);
        int randomTopicId4 = choose2RandomTopic(randomImageId41, randomImageId42);
        ImageView img4 = findViewById(R.id.img4);
        img4.setImageResource(randomTopicId4);
        if (randomTopicId4 == R.drawable.hamburger || randomTopicId4 == R.drawable.hamburger2 || randomTopicId4 == R.drawable.hamburger3) {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers2",ta4, "hamburger", "_ _ _ _ _ _ _ _ _", "H", "The first letter is H", "The length of the word is 9", mh4,tr2, n4, "hamburger", "hamberger", "hamburgar", card4, card5, db, "question_4", "users_progress_level2");
        } else  {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers2",ta4, "soup", "_ _ _ _ ", "s", "The first letter is S", "The length of the word is 4", mh4,tr2, n4, "soupe", "soup", "soupp", card4, card5, db, "question_4", "users_progress_level2");
        }

    }
    public void setCard5(DataBase db) {
        CardView card5 = findViewById(R.id.card5), card6 = findViewById(R.id.card6);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta5=findViewById(R.id.ta5);
        RadioButton n5 = findViewById(R.id.n5);
        FloatingActionButton pre5 = findViewById(R.id.pre5);
        Button bs5 = findViewById(R.id.bs5), bn5 = findViewById(R.id.bn5), bh5 = findViewById(R.id.bh5), bt5 = findViewById(R.id.bt5), bo5 = findViewById(R.id.bo5);
        EditText e5 = findViewById(R.id.e5);
        RadioGroup ch5 = findViewById(R.id.ch5), sg5 = findViewById(R.id.sg5);
        RadioButton l5 = findViewById(R.id.l5), sgg5 = findViewById(R.id.sgg5), fl5 = findViewById(R.id.fl5);
        RadioButton sf5 = findViewById(R.id.sf5), ss5 = findViewById(R.id.ss5), st5 = findViewById(R.id.st5);
        TextView mh5 = findViewById(R.id.mh5);
        int randomImageId51 = chooseRandomImage(R.drawable.television, R.drawable.television2, R.drawable.television3);
        int randomImageId52 = chooseRandomImage(R.drawable.clock, R.drawable.clock2, R.drawable.clock3);
        int randomImageId53 = chooseRandomImage(R.drawable.mirror, R.drawable.mirror2, R.drawable.mirror3);
        int randomTopicId5 = choose3RandomTopic(randomImageId51, randomImageId52, randomImageId53);
        ImageView img5 = findViewById(R.id.img5);
        img5.setImageResource(randomTopicId5);
        if (randomTopicId5 == R.drawable.television || randomTopicId5 == R.drawable.television2 || randomTopicId5 == R.drawable.television3) {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers2",ta5, "television", "_ _ _ _ _ _ _ _ _ _" , "t", "The first letter is T", "The length of the word is 10", mh5,tr2, n5, "television", "televigion", "televersion", card5, card6, db, "question_5", "users_progress_level2");
        } else if (randomTopicId5 == R.drawable.clock || randomTopicId5 == R.drawable.clock2 || randomTopicId5 == R.drawable.clock3) {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers2",ta5, "clock", "_ _ _ _ _", "c", "The first letter is C", "The length of the word is 5", mh5,tr2, n5, "clock", "clok", "cloock", card5, card6, db, "question_5", "users_progress_level2");
        } else {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers2",ta5, "mirror", "_ _ _ _", "m", "The first letter is M", "The length of the word is 6", mh5,tr2, n5, "mirror", "miror", "myrror", card5, card6, db, "question_5", "users_progress_level2");
        }

    }
    public void setCard6(DataBase db) {
        CardView card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta6=findViewById(R.id.ta6);
        RadioButton n6 = findViewById(R.id.n6);
        FloatingActionButton pre6 = findViewById(R.id.pre6);
        Button bs6 = findViewById(R.id.bs6), bn6 = findViewById(R.id.bn6), bh6 = findViewById(R.id.bh6), bt6 = findViewById(R.id.bt6), bo6 = findViewById(R.id.bo6);
        EditText e6 = findViewById(R.id.e6);
        RadioGroup ch6 = findViewById(R.id.ch6), sg6 = findViewById(R.id.sg6);
        RadioButton l6 = findViewById(R.id.l6), sgg6 = findViewById(R.id.sgg6), fl6 = findViewById(R.id.fl6);
        RadioButton sf6 = findViewById(R.id.sf6), ss6 = findViewById(R.id.ss6), st6 = findViewById(R.id.st6);
        TextView mh6 = findViewById(R.id.mh6);
        int randomImageId61 = chooseRandomImage(R.drawable.saw, R.drawable.saw2, R.drawable.saw3);
        ImageView img6 = findViewById(R.id.img6);
        img6.setImageResource(randomImageId61);
        setLayout(pre6, bs6, bn6, bh6, bt6, bo6, e6, ch6, sg6, l6, fl6, sgg6, sf6, ss6, st6, rw, erI, er, erII, t,"right_answers2",ta6, "saw", "_ _ _", "s", "The first letter is S", "The length of the word is 3", mh6,tr2, n6, "saw", "sow", "caw", card6, card7, db, "question_6", "users_progress_level2");


    }
    public void setCard7(DataBase db) {
        CardView card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta7=findViewById(R.id.ta7);
        RadioButton n7 = findViewById(R.id.n7);
        FloatingActionButton pre7 = findViewById(R.id.pre7);
        Button bs7 = findViewById(R.id.bs7), bn7 = findViewById(R.id.bn7), bh7 = findViewById(R.id.bh7), bt7 = findViewById(R.id.bt7), bo7 = findViewById(R.id.bo7);
        EditText e7 = findViewById(R.id.e7);
        RadioGroup ch7 = findViewById(R.id.ch7), sg7 = findViewById(R.id.sg7);
        RadioButton l7 = findViewById(R.id.l7), sgg7 = findViewById(R.id.sgg7), fl7 = findViewById(R.id.fl7);
        RadioButton sf7 = findViewById(R.id.sf7), ss7 = findViewById(R.id.ss7), st7 = findViewById(R.id.st7);
        TextView mh7 = findViewById(R.id.mh7);
        int randomImageId71 = chooseRandomImage(R.drawable.jeans, R.drawable.jeans, R.drawable.jeans);
        int randomImageId72 = chooseRandomImage(R.drawable.hoodie, R.drawable.hoodie2, R.drawable.hoodie3);
        int randomImageId73 = chooseRandomImage(R.drawable.hat, R.drawable.hat2, R.drawable.hat3);
        int randomTopicId7 = choose3RandomTopic(randomImageId71, randomImageId72, randomImageId73);
        ImageView img7 = findViewById(R.id.img7);
        img7.setImageResource(randomTopicId7);
        if (randomTopicId7 == R.drawable.hoodie || randomTopicId7 == R.drawable.hoodie2 || randomTopicId7 == R.drawable.hoodie3) {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers2",ta7, "hoodie", "_ _ _ _ _ _", "h", "The first letter is H", "The length of the word is 6", mh7,tr2, n7, "houdie", "hoodie", "hoodi", card7, card8, db, "question_7", "users_progress_level2");
        } else if (randomTopicId7 == R.drawable.hat || randomTopicId7 == R.drawable.hat2 || randomTopicId7 == R.drawable.hat3) {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers2",ta7, "hat", "_ _ _", "h", "The first letter is H", "The length of the word is 3", mh7,tr2, n7, "hatt", "hat", "het", card7, card8, db, "question_7", "users_progress_level2");
        } else {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers2",ta7, "jeans", "_ _ _ _ _", "s=j", "The first letter is J", "The length of the word is 5", mh7,tr2, n7, "jeans", "jean", "jeens", card7, card8, db, "question_7", "users_progress_level2");
        }

    }
    public void setCard8(DataBase db) {
        CardView card8 = findViewById(R.id.card8), card9= findViewById(R.id.card9);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta8=findViewById(R.id.ta8);
        RadioButton n8 = findViewById(R.id.n8);
        FloatingActionButton pre8 = findViewById(R.id.pre8);
        Button bs8 = findViewById(R.id.bs8), bn8 = findViewById(R.id.bn8), bh8 = findViewById(R.id.bh8), bt8 = findViewById(R.id.bt8), bo8 = findViewById(R.id.bo8);
        EditText e8 = findViewById(R.id.e8);
        RadioGroup ch8 = findViewById(R.id.ch8), sg8 = findViewById(R.id.sg8);
        RadioButton l8 = findViewById(R.id.l8), sgg8 = findViewById(R.id.sgg8), fl8 = findViewById(R.id.fl8);
        RadioButton sf8 = findViewById(R.id.sf8), ss8 = findViewById(R.id.ss8), st8 = findViewById(R.id.st8);
        TextView mh8 = findViewById(R.id.mh8);
        int randomImageId81 = chooseRandomImage(R.drawable.guitar, R.drawable.guitar2, R.drawable.guitar3);
        ImageView img8 = findViewById(R.id.img8);
        img8.setImageResource(randomImageId81);
        setLayout(pre8, bs8, bn8, bh8, bt8, bo8, e8, ch8, sg8, l8, fl8, sgg8, sf8, ss8, st8, rw, erI, er, erII, t,"right_answers2",ta8, "guitar", "_ _ _ _ _", "g", "The first letter is G", "The length of the word is 5", mh8,tr2, n8, "guitaar", "guitar", "ghitar", card8, card9, db, "question_8", "users_progress_level2");

    }
    public void setCard9(DataBase db) {
        CardView card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta9=findViewById(R.id.ta9);
        RadioButton n9 = findViewById(R.id.n9);
        FloatingActionButton pre9 = findViewById(R.id.pre9);
        Button bs9 = findViewById(R.id.bs9), bn9 = findViewById(R.id.bn9), bh9 = findViewById(R.id.bh9), bt9 = findViewById(R.id.bt9), bo9 = findViewById(R.id.bo9);
        EditText e9 = findViewById(R.id.e9);
        RadioGroup ch9 = findViewById(R.id.ch9), sg9 = findViewById(R.id.sg9);
        RadioButton l9 = findViewById(R.id.l9), sgg9 = findViewById(R.id.sgg9), fl9 = findViewById(R.id.fl9);
        RadioButton sf9 = findViewById(R.id.sf9), ss9 = findViewById(R.id.ss9), st9 = findViewById(R.id.st9);
        TextView mh9 = findViewById(R.id.mh9);
        int randomImageId91 = chooseRandomImage(R.drawable.ship, R.drawable.ship2, R.drawable.ship3);
        int randomImageId92 = chooseRandomImage(R.drawable.truck, R.drawable.truck2, R.drawable.truck3);
        int randomImageId93 = chooseRandomImage(R.drawable.boat, R.drawable.boat2, R.drawable.boat3);
        int randomTopicId9 = choose3RandomTopic(randomImageId91, randomImageId92, randomImageId93);
        ImageView img9 = findViewById(R.id.img9);
        img9.setImageResource(randomTopicId9);
        if (randomTopicId9 == R.drawable.truck || randomTopicId9 == R.drawable.truck2 || randomTopicId9 == R.drawable.truck3) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers2",ta9, "truck", "_ _ _ _ _", "t", "The first letter is C", "The length of the word is 5", mh9,tr2, n9, "track", "truck", "truk", card9, card10, db, "question_9", "users_progress_level2");
        } else if (randomTopicId9 == R.drawable.boat || randomTopicId9 == R.drawable.boat2 || randomTopicId9 == R.drawable.boat3) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers2",ta9, "boat", "_ _ _ _", "b", "The first letter is B", "The length of the word is 4", mh9,tr2, n9, "boat", "bot", "boet", card9, card10, db, "question_9", "users_progress_level2");
        } else {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers2",ta9, "ship", "_ _ _ _", "s", "The first letter is S", "The length of the word is 4", mh9,tr2, n9, "ship", "sheep", "chip", card9, card10, db, "question_9", "users_progress_level2");
        }

    }
    public void setCard10(DataBase db) {
        CardView card10 = findViewById(R.id.card10), result = findViewById(R.id.result);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr2=findViewById(R.id.tr2),ta10=findViewById(R.id.ta10);
        RadioButton n10 = findViewById(R.id.n10);
        FloatingActionButton pre10 = findViewById(R.id.pre10);
        Button bs10 = findViewById(R.id.bs10), bn10 = findViewById(R.id.bn10), bh10 = findViewById(R.id.bh10), bt10 = findViewById(R.id.bt10), bo10 = findViewById(R.id.bo10);
        EditText e10 = findViewById(R.id.e10);
        RadioGroup ch10 = findViewById(R.id.ch10), sg10 = findViewById(R.id.sg10);
        RadioButton l10 = findViewById(R.id.l10), sgg10 = findViewById(R.id.sgg10), fl10 = findViewById(R.id.fl10);
        RadioButton sf10 = findViewById(R.id.sf10), ss10 = findViewById(R.id.ss10), st10 = findViewById(R.id.st10);
        TextView mh10 = findViewById(R.id.mh10);
        int randomImageId101 = chooseRandomImage(R.drawable.tsunami, R.drawable.tsunami2, R.drawable.tsunami3);
        int randomImageId103 = chooseRandomImage(R.drawable.volcano, R.drawable.volcano2, R.drawable.volcano3);
        int randomTopicId10 = choose2RandomTopic(randomImageId101,randomImageId103);
        ImageView img10 = findViewById(R.id.img10);
        img10.setImageResource(randomTopicId10);
        if (randomTopicId10 == R.drawable.tsunami || randomTopicId10 == R.drawable.tsunami2 || randomTopicId10 == R.drawable.tsunami3) {
            setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers2",ta10, "tsunami", "_ _ _ _ _ _ _", "t", "The first letter is T", "The length of the word is 7", mh10,tr2, n10, "tsounami", "tsunami", "tsuunami", card10, result, db, "question_10", "users_progress_level2");
        }   else {
            setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers2",ta10, "volcano", "_ _ _ _ _ _", "v", "The first letter is V", "The length of the word is 7", mh10,tr2, n10, "volcano", "volcan", "volcane", card10, result, db, "question_10", "users_progress_level2");
        }

    }
    public void setNextLevel(DataBase dataBase){
        Button bnl=findViewById(R.id.bnl);
        bnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(level_2.this,levels.class);
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
        Intent i = new Intent(level_2.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}