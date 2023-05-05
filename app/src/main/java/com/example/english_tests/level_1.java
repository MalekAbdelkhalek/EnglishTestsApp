package com.example.english_tests;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class level_1 extends AppCompatActivity {
    RadioButton er, erI, erII, t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        /*RelativeLayout level_1=findViewById(R.id.level_1);
        level_1.setBackgroundResource(R.drawable.bg_levels);*/
        DataBase db=new DataBase(this);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);

        /*cards*/
        CardView card1 = findViewById(R.id.card1), card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5), result = findViewById(R.id.result),
                card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8), card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);

        if (getCountByUser(db,"users_progress_level1") == 0) {
            /*1*/
            setRadioButtons(db,"users_progress_level1");
            card1.setVisibility(View.VISIBLE);
            setCard1(db);setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level1") == 1) {
            /*2*/
            setRadioButtons(db,"users_progress_level1");
            card2.setVisibility(View.VISIBLE);
            setCard2(db);setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level1") == 2) {
            /*3*/
            setRadioButtons(db,"users_progress_level1");
            card3.setVisibility(View.VISIBLE);
            setCard3(db);setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        } else if (getCountByUser(db,"users_progress_level1") == 3) {
            /*4*/
            setRadioButtons(db,"users_progress_level1");
            card4.setVisibility(View.VISIBLE);
            setCard4(db);setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);

        } else if (getCountByUser(db,"users_progress_level1") == 4) {
            /*5*/
            setRadioButtons(db,"users_progress_level1");
            card5.setVisibility(View.VISIBLE);
            setCard5(db);setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 5) {
            /*5*/
            setRadioButtons(db,"users_progress_level1");
            card6.setVisibility(View.VISIBLE);
            setCard6(db);setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 6) {
            /*5*/
            setRadioButtons(db,"users_progress_level1");
            card7.setVisibility(View.VISIBLE);
            setCard7(db);setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 7) {
            /*5*/
            setRadioButtons(db,"users_progress_level1");
            card8.setVisibility(View.VISIBLE);
            setCard8(db);setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 8) {
            /*5*/
            setRadioButtons(db,"users_progress_level1");
            card9.setVisibility(View.VISIBLE);
            setCard9(db);setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 9) {
            /*5*/
            setRadioButtons(db, "users_progress_level1");
            card10.setVisibility(View.VISIBLE);
            setCard10(db);
        }else if (getCountByUser(db,"users_progress_level1") == 10) {
            /*5*/
            setRadioButtons(db, "users_progress_level1");
            card10.setVisibility(View.VISIBLE);
            setCard10(db);}

        setNextLevel(db);






    }
    public int chooseRandomImage(int i1, int i2, int i3) {
        int[] imageIds = {i1, i2, i3};
        Random random = new Random();
        int randomImageId = imageIds[random.nextInt(imageIds.length)];
        return randomImageId;
    }

    public int choose3RandomTopic(int i1, int i2, int i3) {
        int[] imageIds = {i1, i2, i3};
        Random random = new Random();
        int randomTopicId = imageIds[random.nextInt(imageIds.length)];
        return randomTopicId;
    }
    public int choose2RandomTopic(int i1, int i2) {
        int[] imageIds = {i1, i2};
        Random random = new Random();
        int randomTopicId = imageIds[random.nextInt(imageIds.length)];
        return randomTopicId;
    }

    public void setLayout(FloatingActionButton pre, Button bs, Button bn, Button bh, Button bt, Button bo, EditText e, RadioGroup ch, RadioGroup sg,
                          RadioButton l, RadioButton fl, RadioButton sgg, RadioButton sf, RadioButton ss, RadioButton st, TextView rw,
                          RadioButton er, RadioButton erI, RadioButton erII, RadioButton t,String right_answers,TextView ta, String word, String hint, String letter, String msgfl, String msgl, TextView mh,TextView tr,
                          RadioButton n, String sft, String sst, String stt, CardView card1, CardView card2, DataBase dataBase, String question, String table) {
        final Integer[] i = {1};
        final TextView[] msg = {rw};
        final RadioButton[] tt = {t};
        final Integer[] cl = {0};
        final Integer[] cfl = {0};
        final Integer[] cs = {0};
        final boolean[] h = {false};
        final boolean[] r = {false};
        final boolean sugg[] = {false};
        final RadioButton[] err = {er};
        final RadioButton[] errI = {erI};
        final RadioButton[] errII = {erII};
        sf.setText(sft);
        ss.setText(sst);
        st.setText(stt);
        ColorStateList colorStateListRED = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[]{getResources().getColor(R.color.red)}
        );
        ColorStateList colorStateListGREEN = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[]{getResources().getColor(R.color.green)}
        );

        String username;
        if (signUp.come_from_SignUp==true) {
            username = signUp.eun.getText().toString();
        } else if (MainActivity.come_from_Main==true){
            username = MainActivity.name;
        }else{
            username = login.eun.getText().toString();
        }
        //Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

        bs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (e.getText().toString().length() == 0) {
                    Toast.makeText(level_1.this, "No tries received !", Toast.LENGTH_SHORT).show();
                } else {
                    if (i[0] == 1) {
                        if (e.getText().toString().toLowerCase().trim().equals(word)) {
                            e.setTextColor(getResources().getColor(R.color.green));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Congratulations,\nyou got it right on the first try!");
                            rw.setTextColor(getResources().getColor(R.color.green));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            e.setEnabled(false);
                            bs.setEnabled(false);
                            bh.setEnabled(false);
                            bn.setEnabled(true);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                            n.setEnabled(true);
                            n.setChecked(true);
                            n.setButtonTintList(colorStateListGREEN);
                            dataBase.updateStringColumn(table, username, question, "1");
                            dataBase.updateColumnValuePlusOne(table, "right_answers", username);
                            dataBase.updateColumnValuePlusOne(table, "count_answers", username);
                            dataBase.updateColumnValuePlusOne("users",right_answers,username);
                            dataBase.updateColumnValuePlusOne("users","overall",username);
                            if (dataBase.getIntColumn(table, "count_answers", username) == 10){
                                dataBase.updateColumnValuePlusOne("users","level_reached",username);
                            }
                        } else {
                            e.setTextColor(getResources().getColor(R.color.red));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Sorry, that's not the right answer.\nYou have 2 chances left.");
                            rw.setTextColor(getResources().getColor(R.color.red));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            bs.setVisibility(View.INVISIBLE);
                            bt.setVisibility(view.VISIBLE);
                            e.setEnabled(false);
                            bh.setEnabled(false);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                        }
                        i[0]++;
                    } else if (i[0] == 2) {
                        if (e.getText().toString().toLowerCase().trim().equals(word)) {
                            e.setTextColor(getResources().getColor(R.color.green));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Congratulations,\nyou got it right on the second try");
                            rw.setTextColor(getResources().getColor(R.color.green));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            e.setEnabled(false);
                            bs.setEnabled(false);
                            bh.setEnabled(false);
                            bn.setEnabled(true);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                            n.setEnabled(true);
                            n.setChecked(true);
                            n.setButtonTintList(colorStateListGREEN);
                            dataBase.updateStringColumn(table, username, question, "1");
                            dataBase.updateColumnValuePlusOne(table, "right_answers", username);
                            dataBase.updateColumnValuePlusOne(table, "count_answers", username);
                            dataBase.updateColumnValuePlusOne("users",right_answers,username);
                            dataBase.updateColumnValuePlusOne("users","overall",username);
                            if (dataBase.getIntColumn(table, "count_answers", username) == 10){
                                dataBase.updateColumnValuePlusOne("users","level_reached",username);
                            }
                        } else {
                            e.setTextColor(getResources().getColor(R.color.red));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Sorry, that's not the right answer.\n You have 1 chance left.");
                            rw.setTextColor(getResources().getColor(R.color.red));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            bs.setVisibility(View.INVISIBLE);
                            bt.setVisibility(view.VISIBLE);
                            e.setEnabled(false);
                            bh.setEnabled(false);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                        }
                        i[0]++;
                    } else if (i[0] == 3) {
                        if (e.getText().toString().toLowerCase().trim().equals(word)) {
                            e.setTextColor(getResources().getColor(R.color.green));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Congratulations,\nyou got it right on the third try!");
                            rw.setTextColor(getResources().getColor(R.color.green));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            e.setEnabled(false);
                            bs.setEnabled(false);
                            bh.setEnabled(false);
                            bn.setEnabled(true);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                            n.setEnabled(true);
                            n.setChecked(true);
                            n.setButtonTintList(colorStateListGREEN);
                            dataBase.updateStringColumn(table, username, question, "1");
                            dataBase.updateColumnValuePlusOne(table, "right_answers", username);
                            dataBase.updateColumnValuePlusOne(table, "count_answers", username);
                            dataBase.updateColumnValuePlusOne("users",right_answers,username);
                            dataBase.updateColumnValuePlusOne("users","overall",username);
                            if (dataBase.getIntColumn(table, "count_answers", username) == 10){
                                dataBase.updateColumnValuePlusOne("users","level_reached",username);
                            }
                        } else {
                            e.setTextColor(getResources().getColor(R.color.red));
                            msg[0].setVisibility(view.INVISIBLE);
                            rw.setText("Sorry, that's not the right answer.\nyou have no more chances left for this question.");
                            rw.setTextColor(getResources().getColor(R.color.red));
                            rw.setVisibility(view.VISIBLE);
                            msg[0] = rw;
                            e.setEnabled(false);
                            bs.setEnabled(false);
                            bh.setVisibility(View.INVISIBLE);
                            ta.setVisibility(View.VISIBLE);
                            ta.setText("The correct answer was : "+word);
                            bn.setEnabled(true);
                            if (sugg[0] == true) {
                                errI[0].setEnabled(false);
                                errII[0].setEnabled(false);
                                sugg[0] = false;
                            }
                            n.setEnabled(true);
                            n.setChecked(true);
                            n.setButtonTintList(colorStateListRED);
                            dataBase.updateStringColumn(table, username, question, "0");
                            dataBase.updateColumnValuePlusOne(table, "count_answers", username);
                            if (dataBase.getIntColumn(table, "count_answers", username) == 10){
                                dataBase.updateColumnValuePlusOne("users","level_reached",username);
                            }
                        }
                    }
                }
            }
        });
        bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre.setVisibility(view.VISIBLE);
                e.setText("");
                bh.setVisibility(view.INVISIBLE);
                ch.setVisibility(view.VISIBLE);
                bo.setVisibility(view.VISIBLE);
                bn.setVisibility(view.INVISIBLE);
                e.setEnabled(false);
                bs.setEnabled(false);
            }
        });
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt[0] = fl;
                mh.setText(msgfl);
                h[0] = true;
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt[0] = l;
                mh.setText(msgl);
                h[0] = true;
            }
        });
        sgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt[0] = sgg;
                h[0] = true;
            }
        });
        bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tt[0] == t) {
                    Toast.makeText(level_1.this, "Nothing selected !", Toast.LENGTH_SHORT).show();
                } else {
                    if (tt[0] == l) {
                        if (dataBase.getIntColumn(table, "count_length", username) >= 2) {
                            Toast.makeText(level_1.this, "Sorry, you used all you opportunities to help you in this way", Toast.LENGTH_SHORT).show();
                        } else {
                            if (cl[0] == 0) {
                                mh.setVisibility(view.VISIBLE);
                                e.setHint(hint);
                                e.setEnabled(true);
                                bs.setEnabled(true);
                                ch.setVisibility(view.INVISIBLE);
                                bo.setVisibility(view.INVISIBLE);
                                bn.setVisibility(view.VISIBLE);
                                pre.setVisibility(view.INVISIBLE);
                                cl[0]++;
                                dataBase.updateColumnValuePlusOne(table, "count_length", username);
                            } else if (cl[0] == 1) {
                                Toast.makeText(level_1.this, "You already used this way of help !", Toast.LENGTH_SHORT).show();
                            }

                        }
                    } else if (tt[0] == fl) {
                        if (dataBase.getIntColumn(table, "count_first_letter", username) >= 2) {
                            Toast.makeText(level_1.this, "Sorry, you used all you opportunities to help you in this way", Toast.LENGTH_SHORT).show();
                        } else {
                            if (cfl[0] == 0) {
                                mh.setVisibility(view.VISIBLE);
                                e.setText(letter);
                                e.setEnabled(true);
                                bs.setEnabled(true);
                                ch.setVisibility(view.INVISIBLE);
                                bo.setVisibility(view.INVISIBLE);
                                bn.setVisibility(view.VISIBLE);
                                pre.setVisibility(view.INVISIBLE);
                                cfl[0]++;
                                dataBase.updateColumnValuePlusOne(table, "count_first_letter", username);
                            } else if (cfl[0] == 1) {
                                Toast.makeText(level_1.this, "You already used this way of help !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else if (tt[0] == sgg) {
                        if (dataBase.getIntColumn(table, "count_suggestions", username) >= 2) {
                            Toast.makeText(level_1.this, "Sorry, you used all you opportunities to help you in this way", Toast.LENGTH_SHORT).show();
                        } else {
                            if (cs[0] == 0) {
                                sg.setVisibility(view.VISIBLE);
                                ch.setVisibility(view.INVISIBLE);
                                bo.setVisibility(view.INVISIBLE);
                                bn.setVisibility(view.VISIBLE);
                                pre.setVisibility(view.INVISIBLE);
                                cs[0]++;
                                dataBase.updateColumnValuePlusOne(table, "count_suggestions", username);
                            } else if (cs[0] == 1) {
                                Toast.makeText(level_1.this, "You already used this way of help !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                }
            }
        });
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setText(sf.getText());
                bs.setEnabled(true);
                sugg[0] = true;
                err[0] = sf;
                errI[0] = ss;
                errII[0] = st;
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setText(ss.getText());
                bs.setEnabled(true);
                sugg[0] = true;
                err[0] = ss;
                errI[0] = sf;
                errII[0] = st;
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setText(st.getText());
                bs.setEnabled(true);
                sugg[0] = true;
                err[0] = st;
                errI[0] = sf;
                errII[0] = ss;
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setHint("the answer");
                sg.setVisibility(view.INVISIBLE);
                mh.setVisibility(view.INVISIBLE);
                rw.setVisibility(view.INVISIBLE);
                bt.setVisibility(view.INVISIBLE);
                bs.setVisibility(view.VISIBLE);
                bh.setVisibility(view.VISIBLE);
                bh.setEnabled(true);
                e.setEnabled(true);
                e.setTextColor(getResources().getColor(R.color.black));
                if (sugg[0] = true) {
                    erI.setEnabled(true);
                    erII.setEnabled(true);
                    er.setChecked(false);
                    sugg[0] = false;
                }
                if (h[0] = true) {
                    tt[0].setChecked(false);
                    h[0] = false;
                }
                e.setText("");
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre.setVisibility(view.INVISIBLE);
                bh.setVisibility(view.VISIBLE);
                ch.setVisibility(view.INVISIBLE);
                bo.setVisibility(view.INVISIBLE);
                bn.setVisibility(view.VISIBLE);
                e.setEnabled(true);
                bs.setEnabled(true);
                fl.setChecked(false);
                l.setChecked(false);
                sgg.setChecked(false);
            }
        });
        e.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    bs.performClick();
                    return true;
                }
                return false;
            }
        });
        bn.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      card1.setVisibility(view.INVISIBLE);
                                      card2.setVisibility(View.VISIBLE);
                                      msg[0].setVisibility(view.INVISIBLE);
                                      i[0] = 1;
                                      cl[0] = 0;
                                      cfl[0] = 0;
                                      cs[0] = 0;
                                      if (dataBase.getIntColumn(table, "count_answers", username) == 10) {
                                          ImageView imgr = findViewById(R.id.imgr);
                                          if(dataBase.getIntColumn(table, "right_answers", username)==10){
                                              tr.setText("- 10/10 - \n Fantastic " + username + " ! \n" + "Perfect score,\n you nailed it!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.ten);
                                              imgr.setImageDrawable(drawable);
                                              }
                                          else if(dataBase.getIntColumn(table, "right_answers", username)==9){
                                              tr.setText("- 9/10 - \n Excellent job " + username + " ! \n" + "You're almost a master,\n keep going!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.nine);
                                              imgr.setImageDrawable(drawable);
                                              }
                                          else if(dataBase.getIntColumn(table, "right_answers", username)==8){
                                              tr.setText("- 8/10 - \n Great work " + username + " ! \n" + "You're almost there,\n keep pushing yourself!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.eight);
                                              imgr.setImageDrawable(drawable);
                                              }
                                          else if(dataBase.getIntColumn(table, "right_answers", username)==7){
                                              tr.setText("- 7/10 - \n Well done " + username + " ! \n" + "You're making progress,\n keep studying!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.seven);
                                              imgr.setImageDrawable(drawable);
                                              }
                                          else if(dataBase.getIntColumn(table, "right_answers", username)==6){
                                              tr.setText("- 6/10 - \n Good job " + username + " ! \n" + "You're on the right track,\n keep it up!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.six);
                                              imgr.setImageDrawable(drawable);
                                              }
                                          else if (dataBase.getIntColumn(table, "right_answers", username) == 5) {
                                              tr.setText("- 5/10 - \n Halfway there " + username + " ! \n" + "Keep up the good work \nand aim for higher next time.");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.five);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          } else if (dataBase.getIntColumn(table, "right_answers", username) == 4) {
                                              tr.setText("- 4/10 - \n You're getting there " + username + " ! \n" + "Keep studying and practicing.");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.four);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          } else if (dataBase.getIntColumn(table, "right_answers", username) == 3) {
                                              tr.setText("- 3/10 - \n Not bad " + username + " ! \n" + "but there's room for improvement.\n Keep at it!");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.three);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          } else if (dataBase.getIntColumn(table, "right_answers", username) == 2) {
                                              tr.setText("- 2/10 - \n Good effort " + username + " ! \n" + "Keep practicing to improve your skills.");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.two);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          } else if (dataBase.getIntColumn(table, "right_answers", username) == 1) {
                                              tr.setText("- 1/10 - \n Keep Trying " + username + " ! \n" + "Everyone starts somewhere.");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.one);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          } else if (dataBase.getIntColumn(table, "right_answers", username) == 0) {
                                              tr.setText("- 0/10 - \n This is just the beginning " + username + " ! \n" + "Don't give up,\n keep trying and you will make progress.");
                                              tr.setTextColor(getResources().getColor(R.color.borders));
                                              Drawable drawable = getResources().getDrawable(R.drawable.zero);
                                              imgr.setImageDrawable(drawable);
                                              ;
                                          }
                                      }

                                  }
                              }

        );


    }/*function of setting the layout*/

    public int getCountByUser(DataBase dataBase,String table) {
        String username;
        if (login.come_from_Login==false && MainActivity.come_from_Main==false) {
            username = signUp.eun.getText().toString();
        } else if (login.come_from_Login==false && signUp.come_from_SignUp==false){
            username = MainActivity.name;
        }else{
            username = login.eun.getText().toString();
        }
        int count = dataBase.getIntColumn(table, "count_answers", username);
        return count;
    }

    public void setCard1(DataBase db) {
        CardView card1 = findViewById(R.id.card1), card2 = findViewById(R.id.card2);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta1=findViewById(R.id.ta1);
        RadioButton n1 = findViewById(R.id.n1);
        FloatingActionButton pre1 = findViewById(R.id.pre1);
        Button bs1 = findViewById(R.id.bs1), bn1 = findViewById(R.id.bn1), bh1 = findViewById(R.id.bh1), bt1 = findViewById(R.id.bt1), bo1 = findViewById(R.id.bo1);
        EditText e1 = findViewById(R.id.e1);
        RadioGroup ch1 = findViewById(R.id.ch1), sg1 = findViewById(R.id.sg1);
        RadioButton l1 = findViewById(R.id.l1), sgg1 = findViewById(R.id.sgg1), fl1 = findViewById(R.id.fl1);
        RadioButton sf1 = findViewById(R.id.sf1), ss1 = findViewById(R.id.ss1), st1 = findViewById(R.id.st1);
        TextView mh1 = findViewById(R.id.mh1);
        int randomImageId11 = chooseRandomImage(R.drawable.fish, R.drawable.fish2, R.drawable.fish3);
        int randomImageId12 = chooseRandomImage(R.drawable.cat, R.drawable.cat2, R.drawable.cat3);
        int randomImageId13 = chooseRandomImage(R.drawable.dog, R.drawable.dog2, R.drawable.dog3);
        int randomTopicId1 = choose3RandomTopic(randomImageId11, randomImageId12, randomImageId13);
        ImageView img1 = findViewById(R.id.img1);
        img1.setImageResource(randomTopicId1);
        if (randomTopicId1 == R.drawable.fish || randomTopicId1 == R.drawable.fish2 || randomTopicId1 == R.drawable.fish3) {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers1",ta1, "fish", "_ _ _ _", "f", "The first letter is F", "The length of the word is 4", mh1,tr1, n1, "fish", "fetish", "fist", card1, card2, db, "question_1", "users_progress_level1");
        } else if (randomTopicId1 == R.drawable.dog || randomTopicId1 == R.drawable.dog2 || randomTopicId1 == R.drawable.dog3) {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers1",ta1, "dog", "_ _ _", "d", "The first letter is D", "The length of the word is 3", mh1,tr1 ,n1, "dob", "dog", "frog", card1, card2, db, "question_1", "users_progress_level1");
        } else {
            setLayout(pre1, bs1, bn1, bh1, bt1, bo1, e1, ch1, sg1, l1, fl1, sgg1, sf1, ss1, st1, rw, erI, er, erII, t,"right_answers1",ta1, "cat", "_ _ _", "c", "The first letter is C", "The length of the word is 3", mh1,tr1, n1, "cas", "caf", "cat", card1, card2, db, "question_1", "users_progress_level1");
        }
    }
    public void setCard2(DataBase db) {
        CardView card2 = findViewById(R.id.card2), card3 = findViewById(R.id.card3);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta2=findViewById(R.id.ta2);
        RadioButton n2 = findViewById(R.id.n2);
        FloatingActionButton pre2 = findViewById(R.id.pre2);
        Button bs2 = findViewById(R.id.bs2), bn2 = findViewById(R.id.bn2), bh2 = findViewById(R.id.bh2), bt2 = findViewById(R.id.bt2), bo2 = findViewById(R.id.bo2);
        EditText e2 = findViewById(R.id.e2);
        RadioGroup ch2 = findViewById(R.id.ch2), sg2 = findViewById(R.id.sg2);
        RadioButton l2 = findViewById(R.id.l2), sgg2 = findViewById(R.id.sgg2), fl2 = findViewById(R.id.fl2);
        RadioButton sf2 = findViewById(R.id.sf2), ss2 = findViewById(R.id.ss2), st2 = findViewById(R.id.st2);
        TextView mh2 = findViewById(R.id.mh2);
        int randomImageId21 = chooseRandomImage(R.drawable.apple, R.drawable.apple2, R.drawable.apple3);
        int randomImageId22 = chooseRandomImage(R.drawable.orange, R.drawable.orange2, R.drawable.orange3);
        int randomImageId23 = chooseRandomImage(R.drawable.banana, R.drawable.banana2, R.drawable.banana3);
        int randomTopicId2 = choose3RandomTopic(randomImageId21, randomImageId22, randomImageId23);
        ImageView img2 = findViewById(R.id.img2);
        img2.setImageResource(randomTopicId2);
        if (randomTopicId2 == R.drawable.apple || randomTopicId2 == R.drawable.apple2 || randomTopicId2 == R.drawable.apple3) {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers1",ta2, "apple", "_ _ _ _ _", "a", "The first letter is A", "The length of the word is 5", mh2,tr1, n2, "aple", "apple", "affle", card2, card3, db, "question_2", "users_progress_level1");
        } else if (randomTopicId2 == R.drawable.orange || randomTopicId2 == R.drawable.orange2 || randomTopicId2 == R.drawable.orange3) {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers1",ta2, "orange", "_ _ _ _ _ _", "o", "The first letter is O", "The length of the word is 6", mh2,tr1, n2, "ornge", "orange", "range", card2, card3, db, "question_2", "users_progress_level1");
        } else {
            setLayout(pre2, bs2, bn2, bh2, bt2, bo2, e2, ch2, sg2, l2, fl2, sgg2, sf2, ss2, st2, rw, erI, er, erII, t,"right_answers1",ta2, "banana", "_ _ _ _ _ _", "b", "The first letter is B", "The length of the word is 6", mh2,tr1, n2, "banan", "banane", "banana", card2, card3, db, "question_2", "users_progress_level1");
        }

    }
    public void setCard3(DataBase db) {
        CardView card3 = findViewById(R.id.card3), card4 = findViewById(R.id.card4);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta3=findViewById(R.id.ta3);;
        RadioButton n3 = findViewById(R.id.n3);
        FloatingActionButton pre3 = findViewById(R.id.pre3);
        Button bs3 = findViewById(R.id.bs3), bn3 = findViewById(R.id.bn3), bh3 = findViewById(R.id.bh3), bt3 = findViewById(R.id.bt3), bo3 = findViewById(R.id.bo3);
        EditText e3 = findViewById(R.id.e3);
        RadioGroup ch3 = findViewById(R.id.ch3), sg3 = findViewById(R.id.sg3);
        RadioButton l3 = findViewById(R.id.l3), sgg3 = findViewById(R.id.sgg3), fl3 = findViewById(R.id.fl3);
        RadioButton sf3 = findViewById(R.id.sf3), ss3 = findViewById(R.id.ss3), st3 = findViewById(R.id.st3);
        TextView mh3 = findViewById(R.id.mh3);
        int randomImageId31 = chooseRandomImage(R.drawable.carrot, R.drawable.carrot2, R.drawable.carrot3);
        int randomImageId33 = chooseRandomImage(R.drawable.tomato, R.drawable.tomato2, R.drawable.tomato3);
        int randomImageId32 = chooseRandomImage(R.drawable.potato1, R.drawable.potato2, R.drawable.potato3);
        int randomTopicId3 = choose3RandomTopic(randomImageId31, randomImageId33, randomImageId32);
        ImageView img3 = findViewById(R.id.img3);
        img3.setImageResource(randomTopicId3);
        if (randomTopicId3 == R.drawable.carrot || randomTopicId3 == R.drawable.carrot2 || randomTopicId3 == R.drawable.carrot3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers1",ta3, "carrot", "_ _ _ _ _ _", "c", "The first letter is C", "The length of the word is 6", mh3,tr1, n3, "carot", "carroto", "carrot", card3, card4, db, "question_3", "users_progress_level1");
        } else if (randomTopicId3 == R.drawable.tomato || randomTopicId3 == R.drawable.tomato2 || randomTopicId3 == R.drawable.tomato3) {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers1",ta3, "tomato", "_ _ _ _ _ _", "t", "The first letter is T", "The length of the word is 6", mh3,tr1, n3, "tomate", "tomat", "tomato", card3, card4, db, "question_3", "users_progress_level1");
        } else {
            setLayout(pre3, bs3, bn3, bh3, bt3, bo3, e3, ch3, sg3, l3, fl3, sgg3, sf3, ss3, st3, rw, erI, er, erII, t,"right_answers1",ta3, "potato", "_ _ _ _ _ _", "p", "The first letter is P", "The length of the word is 6", mh3,tr1, n3, "potate", "ptat", "potato", card3, card4, db, "question_3", "users_progress_level1");
        }

    }
    public void setCard4(DataBase db) {
        CardView card4 = findViewById(R.id.card4), card5 = findViewById(R.id.card5);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta4=findViewById(R.id.ta4);;
        RadioButton n4 = findViewById(R.id.n4);
        FloatingActionButton pre4 = findViewById(R.id.pre4);
        Button bs4 = findViewById(R.id.bs4), bn4 = findViewById(R.id.bn4), bh4 = findViewById(R.id.bh4), bt4 = findViewById(R.id.bt4), bo4 = findViewById(R.id.bo4);
        EditText e4 = findViewById(R.id.e4);
        RadioGroup ch4 = findViewById(R.id.ch4), sg4 = findViewById(R.id.sg4);
        RadioButton l4 = findViewById(R.id.l4), sgg4 = findViewById(R.id.sgg4), fl4 = findViewById(R.id.fl4);
        RadioButton sf4 = findViewById(R.id.sf4), ss4 = findViewById(R.id.ss4), st4 = findViewById(R.id.st4);
        TextView mh4 = findViewById(R.id.mh4);
        int randomImageId41 = chooseRandomImage(R.drawable.pizza, R.drawable.pizza2, R.drawable.pizza3);
        int randomImageId42 = chooseRandomImage(R.drawable.salad, R.drawable.salad2, R.drawable.salad3);
        int randomTopicId4 = choose2RandomTopic(randomImageId41, randomImageId42);
        ImageView img4 = findViewById(R.id.img4);
        img4.setImageResource(randomTopicId4);
        if (randomTopicId4 == R.drawable.pizza || randomTopicId4 == R.drawable.pizza2 || randomTopicId4 == R.drawable.pizza3) {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers1",ta4, "pizza", "_ _ _ _ _", "p", "The first letter is P", "The length of the word is 5", mh4,tr1, n4, "pizza", "piza", "pizzera", card4, card5, db, "question_4", "users_progress_level1");
        } else  {
            setLayout(pre4, bs4, bn4, bh4, bt4, bo4, e4, ch4, sg4, l4, fl4, sgg4, sf4, ss4, st4, rw, erI, er, erII, t,"right_answers1",ta4, "salad", "_ _ _ _ _", "s", "The first letter is S", "The length of the word is 5", mh4,tr1, n4, "salada", "salad", "solad", card4, card5, db, "question_4", "users_progress_level1");
        } 

    }
    public void setCard5(DataBase db) {
        CardView card5 = findViewById(R.id.card5), card6 = findViewById(R.id.card6);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta5=findViewById(R.id.ta5);;
        RadioButton n5 = findViewById(R.id.n5);
        FloatingActionButton pre5 = findViewById(R.id.pre5);
        Button bs5 = findViewById(R.id.bs5), bn5 = findViewById(R.id.bn5), bh5 = findViewById(R.id.bh5), bt5 = findViewById(R.id.bt5), bo5 = findViewById(R.id.bo5);
        EditText e5 = findViewById(R.id.e5);
        RadioGroup ch5 = findViewById(R.id.ch5), sg5 = findViewById(R.id.sg5);
        RadioButton l5 = findViewById(R.id.l5), sgg5 = findViewById(R.id.sgg5), fl5 = findViewById(R.id.fl5);
        RadioButton sf5 = findViewById(R.id.sf5), ss5 = findViewById(R.id.ss5), st5 = findViewById(R.id.st5);
        TextView mh5 = findViewById(R.id.mh5);
        int randomImageId51 = chooseRandomImage(R.drawable.lamp, R.drawable.lamp2, R.drawable.lamp3);
        int randomImageId52 = chooseRandomImage(R.drawable.chair, R.drawable.chair2, R.drawable.chair3);
        int randomImageId53 = chooseRandomImage(R.drawable.sofa, R.drawable.sofa2, R.drawable.sofa3);
        int randomTopicId5 = choose3RandomTopic(randomImageId51, randomImageId52, randomImageId53);
        ImageView img5 = findViewById(R.id.img5);
        img5.setImageResource(randomTopicId5);
        if (randomTopicId5 == R.drawable.lamp || randomTopicId5 == R.drawable.lamp2 || randomTopicId5 == R.drawable.lamp3) {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers1",ta5, "lamp", "_ _ _ _", "l", "The first letter is L", "The length of the word is 4", mh5,tr1, n5, "lamp", "lampa", "lampad", card5, card6, db, "question_5", "users_progress_level1");
        } else if (randomTopicId5 == R.drawable.chair || randomTopicId5 == R.drawable.chair2 || randomTopicId5 == R.drawable.chair3) {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers1",ta5, "chair", "_ _ _ _ _", "c", "The first letter is C", "The length of the word is 5", mh5,tr1, n5, "chaise", "chaix", "chair", card5, card6, db, "question_5", "users_progress_level1");
        } else {
            setLayout(pre5, bs5, bn5, bh5, bt5, bo5, e5, ch5, sg5, l5, fl5, sgg5, sf5, ss5, st5, rw, erI, er, erII, t,"right_answers1",ta5, "sofa", "_ _ _ _", "s", "The first letter is S", "The length of the word is 4", mh5,tr1, n5, "sof", "sofa", "soufa", card5, card6, db, "question_5", "users_progress_level1");
        }

    }
    public void setCard6(DataBase db) {
        CardView card6 = findViewById(R.id.card6), card7 = findViewById(R.id.card7);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta6=findViewById(R.id.ta6);;
        RadioButton n6 = findViewById(R.id.n6);
        FloatingActionButton pre6 = findViewById(R.id.pre6);
        Button bs6 = findViewById(R.id.bs6), bn6 = findViewById(R.id.bn6), bh6 = findViewById(R.id.bh6), bt6 = findViewById(R.id.bt6), bo6 = findViewById(R.id.bo6);
        EditText e6 = findViewById(R.id.e6);
        RadioGroup ch6 = findViewById(R.id.ch6), sg6 = findViewById(R.id.sg6);
        RadioButton l6 = findViewById(R.id.l6), sgg6 = findViewById(R.id.sgg6), fl6 = findViewById(R.id.fl6);
        RadioButton sf6 = findViewById(R.id.sf6), ss6 = findViewById(R.id.ss6), st6 = findViewById(R.id.st6);
        TextView mh6 = findViewById(R.id.mh6);
        int randomImageId61 = chooseRandomImage(R.drawable.hammer, R.drawable.hammer2, R.drawable.hammer3);
        ImageView img6 = findViewById(R.id.img6);
        img6.setImageResource(randomImageId61);
        setLayout(pre6, bs6, bn6, bh6, bt6, bo6, e6, ch6, sg6, l6, fl6, sgg6, sf6, ss6, st6, rw, erI, er, erII, t,"right_answers1",ta6, "hammer", "_ _ _ _ _ _", "h", "The first letter is H", "The length of the word is 6", mh6,tr1, n6, "hamer", "hammer", "hammar", card6, card7, db, "question_6", "users_progress_level1");


    }
    public void setCard7(DataBase db) {
        CardView card7 = findViewById(R.id.card7), card8 = findViewById(R.id.card8);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta7=findViewById(R.id.ta7);;
        RadioButton n7 = findViewById(R.id.n7);
        FloatingActionButton pre7 = findViewById(R.id.pre7);
        Button bs7 = findViewById(R.id.bs7), bn7 = findViewById(R.id.bn7), bh7 = findViewById(R.id.bh7), bt7 = findViewById(R.id.bt7), bo7 = findViewById(R.id.bo7);
        EditText e7 = findViewById(R.id.e7);
        RadioGroup ch7 = findViewById(R.id.ch7), sg7 = findViewById(R.id.sg7);
        RadioButton l7 = findViewById(R.id.l7), sgg7 = findViewById(R.id.sgg7), fl7 = findViewById(R.id.fl7);
        RadioButton sf7 = findViewById(R.id.sf7), ss7 = findViewById(R.id.ss7), st7 = findViewById(R.id.st7);
        TextView mh7 = findViewById(R.id.mh7);
        int randomImageId71 = chooseRandomImage(R.drawable.shirt, R.drawable.shirt2, R.drawable.shirt3);
        int randomImageId72 = chooseRandomImage(R.drawable.short1, R.drawable.short2, R.drawable.short3);
        int randomImageId73 = chooseRandomImage(R.drawable.socks, R.drawable.socks2, R.drawable.socks3);
        int randomTopicId7 = choose3RandomTopic(randomImageId71, randomImageId72, randomImageId73);
        ImageView img7 = findViewById(R.id.img7);
        img7.setImageResource(randomTopicId7);
        if (randomTopicId7 == R.drawable.shirt || randomTopicId7 == R.drawable.shirt2 || randomTopicId7 == R.drawable.shirt3) {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers1",ta7, "shirt", "_ _ _ _ _", "s", "The first letter is S", "The length of the word is 5", mh7,tr1, n7, "shirt", "short", "shert", card7, card8, db, "question_7", "users_progress_level1");
        } else if (randomTopicId7 == R.drawable.short1 || randomTopicId7 == R.drawable.short2 || randomTopicId7 == R.drawable.short3) {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers1",ta7, "short", "_ _ _ _ _ ", "s", "The first letter is S", "The length of the word is 5", mh7,tr1, n7, "short", "shoort", "showt", card7, card8, db, "question_7", "users_progress_level1");
        } else {
            setLayout(pre7, bs7, bn7, bh7, bt7, bo7, e7, ch7, sg7, l7, fl7, sgg7, sf7, ss7, st7, rw, erI, er, erII, t,"right_answers1",ta7, "socks", "_ _ _ _ _ ", "s", "The first letter is S", "The length of the word is 5", mh7,tr1, n7, "soks", "sots", "socks", card7, card8, db, "question_7", "users_progress_level1");
        }

    }
    public void setCard8(DataBase db) {
        CardView card8 = findViewById(R.id.card8), card9= findViewById(R.id.card9);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta8=findViewById(R.id.ta8);;
        RadioButton n8 = findViewById(R.id.n8);
        FloatingActionButton pre8 = findViewById(R.id.pre8);
        Button bs8 = findViewById(R.id.bs8), bn8 = findViewById(R.id.bn8), bh8 = findViewById(R.id.bh8), bt8 = findViewById(R.id.bt8), bo8 = findViewById(R.id.bo8);
        EditText e8 = findViewById(R.id.e8);
        RadioGroup ch8 = findViewById(R.id.ch8), sg8 = findViewById(R.id.sg8);
        RadioButton l8 = findViewById(R.id.l8), sgg8 = findViewById(R.id.sgg8), fl8 = findViewById(R.id.fl8);
        RadioButton sf8 = findViewById(R.id.sf8), ss8 = findViewById(R.id.ss8), st8 = findViewById(R.id.st8);
        TextView mh8 = findViewById(R.id.mh8);
        int randomImageId81 = chooseRandomImage(R.drawable.piano, R.drawable.piano2, R.drawable.piano3);
        ImageView img8 = findViewById(R.id.img8);
        img8.setImageResource(randomImageId81);
        setLayout(pre8, bs8, bn8, bh8, bt8, bo8, e8, ch8, sg8, l8, fl8, sgg8, sf8, ss8, st8, rw, erI, er, erII, t,"right_answers1",ta8, "piano", "_ _ _ _ _", "p", "The first letter is P", "The length of the word is 5", mh8,tr1, n8, "pianoo", "piano", "piana", card8, card9, db, "question_8", "users_progress_level1");

    }
    public void setCard9(DataBase db) {
        CardView card9 = findViewById(R.id.card9), card10 = findViewById(R.id.card10);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta9=findViewById(R.id.ta9);;
        RadioButton n9 = findViewById(R.id.n9);
        FloatingActionButton pre9 = findViewById(R.id.pre9);
        Button bs9 = findViewById(R.id.bs9), bn9 = findViewById(R.id.bn9), bh9 = findViewById(R.id.bh9), bt9 = findViewById(R.id.bt9), bo9 = findViewById(R.id.bo9);
        EditText e9 = findViewById(R.id.e9);
        RadioGroup ch9 = findViewById(R.id.ch9), sg9 = findViewById(R.id.sg9);
        RadioButton l9 = findViewById(R.id.l9), sgg9 = findViewById(R.id.sgg9), fl9 = findViewById(R.id.fl9);
        RadioButton sf9 = findViewById(R.id.sf9), ss9 = findViewById(R.id.ss9), st9 = findViewById(R.id.st9);
        TextView mh9 = findViewById(R.id.mh9);
        int randomImageId91 = chooseRandomImage(R.drawable.car, R.drawable.car2, R.drawable.car3);
        int randomImageId92 = chooseRandomImage(R.drawable.bicycle, R.drawable.bicycle2, R.drawable.bicycle3);
        int randomImageId93 = chooseRandomImage(R.drawable.bus, R.drawable.bus2, R.drawable.bus3);
        int randomTopicId9 = choose3RandomTopic(randomImageId91, randomImageId92, randomImageId93);
        ImageView img9 = findViewById(R.id.img9);
        img9.setImageResource(randomTopicId9);
        if (randomTopicId9 == R.drawable.car || randomTopicId9 == R.drawable.car2 || randomTopicId9 == R.drawable.car3) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers1",ta9, "car", "_ _ _", "c", "The first letter is C", "The length of the word is 3", mh9,tr1, n9, "car", "kar", "ckar", card9, card10, db, "question_9", "users_progress_level1");
        } else if (randomTopicId9 == R.drawable.bicycle || randomTopicId9 == R.drawable.bicycle2 || randomTopicId9 == R.drawable.bicycle3) {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers1",ta9, "bicycle", "_ _ _ _ _ _ _", "b", "The first letter is B", "The length of the word is 7", mh9,tr1, n9, "bicycle", "bicicle", "baycycle", card9, card10, db, "question_9", "users_progress_level1");
        } else {
            setLayout(pre9, bs9, bn9, bh9, bt9, bo9, e9, ch9, sg9, l9, fl9, sgg9, sf9, ss9, st9, rw, erI, er, erII, t,"right_answers1",ta9, "bus", "_ _ _", "b", "The first letter is B", "The length of the word is 3", mh9,tr1, n9, "bas", "buss", "bus", card9, card10, db, "question_9", "users_progress_level1");
        }

    }
    public void setCard10(DataBase db) {
        CardView card10 = findViewById(R.id.card10), result = findViewById(R.id.result);
        er = findViewById(R.id.er);
        erI = findViewById(R.id.erI);
        erII = findViewById(R.id.erII);
        t = findViewById(R.id.t);
        TextView rw = findViewById(R.id.rw),tr1=findViewById(R.id.tr1),ta10=findViewById(R.id.ta10);;
        RadioButton n10 = findViewById(R.id.n10);
        FloatingActionButton pre10 = findViewById(R.id.pre10);
        Button bs10 = findViewById(R.id.bs10), bn10 = findViewById(R.id.bn10), bh10 = findViewById(R.id.bh10), bt10 = findViewById(R.id.bt10), bo10 = findViewById(R.id.bo10);
        EditText e10 = findViewById(R.id.e10);
        RadioGroup ch10 = findViewById(R.id.ch10), sg10 = findViewById(R.id.sg10);
        RadioButton l10 = findViewById(R.id.l10), sgg10 = findViewById(R.id.sgg10), fl10 = findViewById(R.id.fl10);
        RadioButton sf10 = findViewById(R.id.sf10), ss10 = findViewById(R.id.ss10), st10 = findViewById(R.id.st10);
        TextView mh10 = findViewById(R.id.mh10);
        int randomImageId101 = chooseRandomImage(R.drawable.rainbow, R.drawable.rainbow2, R.drawable.rainbow3);
        int randomImageId102 = chooseRandomImage(R.drawable.waterfall, R.drawable.waterfall2, R.drawable.waterfall3);
        int randomTopicId10 = choose2RandomTopic(randomImageId101, randomImageId102);
        ImageView img10 = findViewById(R.id.img10);
        img10.setImageResource(randomTopicId10);
        if (randomTopicId10 == R.drawable.rainbow || randomTopicId10 == R.drawable.rainbow2 || randomTopicId10 == R.drawable.rainbow3) {
            setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers1",ta10, "rainbow", "_ _ _ _ _ _ _", "r", "The first letter is R", "The length of the word is 7", mh10,tr1, n10, "rainboo", "rainbow", "rainboe", card10, result, db, "question_10", "users_progress_level1");
        } else  {
            setLayout(pre10, bs10, bn10, bh10, bt10, bo10, e10, ch10, sg10, l10, fl10, sgg10, sf10, ss10, st10, rw, erI, er, erII, t,"right_answers1",ta10, "waterfall", "_ _ _ _ _ _ _ _ _", "w", "The first letter is W", "The length of the word is 9", mh10,tr1, n10, "waterfall", "waterdrop", "waterland", card10, result, db, "question_10", "users_progress_level1");
        }

    }
    public void setNextLevel(DataBase dataBase){
        Button bnl=findViewById(R.id.bnl);
        bnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(level_1.this,levels.class);
                startActivity(intent);
            }
        });
    }
    
    
    public void setRadioButton(RadioButton n,DataBase dataBase, String question,String table){
        ColorStateList colorStateListRED = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[]{getResources().getColor(R.color.red)}
        );
        ColorStateList colorStateListGREEN = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled} //enabled
                },
                new int[]{getResources().getColor(R.color.green)}
        );
        String username;
        if (login.come_from_Login==false && MainActivity.come_from_Main==false) {
            username = signUp.eun.getText().toString();
        } else if (login.come_from_Login==false && signUp.come_from_SignUp==false){
            username = MainActivity.name;
        }else{
            username = login.eun.getText().toString();
        }
        String questionStatus = dataBase.getStringColumn(table,question,username);
        //Toast.makeText(this, questionStatus, Toast.LENGTH_SHORT).show();
        if(questionStatus.equals("1")){
            n.setEnabled(true);
            n.setChecked(true);
            n.setButtonTintList(colorStateListGREEN);
        } else if (questionStatus.equals("0")){
            n.setEnabled(true);
            n.setChecked(true);
            n.setButtonTintList(colorStateListRED);
        }

    }
    public void setRadioButtons(DataBase db,String table ){
        RadioButton n1 = findViewById(R.id.n1),n2 = findViewById(R.id.n2),n3 = findViewById(R.id.n3),
                n4 = findViewById(R.id.n4),n5 = findViewById(R.id.n5),n6= findViewById(R.id.n6),n7 = findViewById(R.id.n7),n8 = findViewById(R.id.n8),
        n9 = findViewById(R.id.n9),n10 = findViewById(R.id.n10);
        setRadioButton(n1,db,"question_1",table);
        setRadioButton(n2,db,"question_2",table);
        setRadioButton(n3,db,"question_3",table);
        setRadioButton(n4,db,"question_4",table);
        setRadioButton(n5,db,"question_5",table);
        setRadioButton(n6,db,"question_6",table);
        setRadioButton(n7,db,"question_7",table);
        setRadioButton(n8,db,"question_8",table);
        setRadioButton(n9,db,"question_9",table);
        setRadioButton(n10,db,"question_10",table);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu,menu);
        return  true ;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home);
        Intent i = new Intent(level_1.this,MainActivity.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        // do nothing
    }
}