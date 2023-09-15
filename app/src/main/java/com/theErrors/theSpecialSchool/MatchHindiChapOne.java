package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MatchHindiChapOne extends AppCompatActivity {


    TextView img1,img2,img3,img4,img5;
    ImageView img6,img7,img8,img9,img10;
    String selected="";
    char s1,s2;

    // variable for chapter
    int chapter;

    // variable for class
    int sec=1;
    int match=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_hindi_chap_one);

        img1=findViewById(R.id.img0);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);
        img10=findViewById(R.id.img10);

        chapter=3;
        levelSet(chapter);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.equals("")) {

                    img1.setBackgroundResource(R.drawable.correct);
                    img1.setClickable(false);
                    selected = img1.getTag().toString().substring(0,img1.getTag().toString().length()-1);
                    s1=img1.getTag().toString().charAt((img1.getTag().toString().length())-1);
                }
                else{

                    if (selected.equals(img1.getTag().toString().substring(0,img1.getTag().toString().length()-1))){
                        img1.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img1.setClickable(false);
                        correct();
                        s1=img1.getTag().toString().charAt((img1.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.equals("")) {
                    selected = img2.getTag().toString().substring(0,img2.getTag().toString().length()-1);
                    s1=img2.getTag().toString().charAt((img2.getTag().toString().length())-1);
                    img2.setBackgroundResource(R.drawable.correct);
                    img2.setClickable(false);

                }
                else{
                    if (selected.equals(img2.getTag().toString().substring(0,img2.getTag().toString().length()-1))){
                        img2.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img2.setClickable(false);
                        correct();
                        s1=img2.getTag().toString().charAt((img2.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.equals("")) {
                    selected = img3.getTag().toString().substring(0,img3.getTag().toString().length()-1);
                    s1=img3.getTag().toString().charAt((img3.getTag().toString().length())-1);
                    img3.setBackgroundResource(R.drawable.correct);
                    img3.setClickable(false);
                }
                else{
                    if (selected.equals(img3.getTag().toString().substring(0,img3.getTag().toString().length()-1))){
                        img3.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img3.setClickable(false);
                        correct();
                        s1=img3.getTag().toString().charAt((img3.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.equals("")) {
                    selected = img4.getTag().toString().substring(0,img4.getTag().toString().length()-1);
                    s1=img4.getTag().toString().charAt((img4.getTag().toString().length())-1);
                    img4.setBackgroundResource(R.drawable.correct);
                    img4.setClickable(false);
                }
                else{
                    if (selected.equals(img4.getTag().toString().substring(0,img4.getTag().toString().length()-1))){
                        img4.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img4.setClickable(false);
                        correct();
                        s1=img4.getTag().toString().charAt((img4.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.equals("")) {
                    selected = img5.getTag().toString().substring(0,img5.getTag().toString().length()-1);
                    s1=img5.getTag().toString().charAt((img5.getTag().toString().length())-1);
                    img5.setBackgroundResource(R.drawable.correct);
                    img5.setClickable(false);

                }
                else{
                    if (selected.equals(img5.getTag().toString().substring(0,img5.getTag().toString().length()-1))){
                        img5.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img5.setClickable(false);
                        correct();
                        s1=img5.getTag().toString().charAt((img5.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("")){
                    selected = img6.getTag().toString().substring(0,img6.getTag().toString().length()-1);
                    s2=img6.getTag().toString().charAt((img6.getTag().toString().length())-1);
                    img6.setBackgroundResource(R.drawable.correct);
                    img6.setClickable(false);

                }else{
                    if (selected.equals(img6.getTag().toString().substring(0,img6.getTag().toString().length()-1))){
                        img6.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img6.setClickable(false);
                        correct();
                        s2=img6.getTag().toString().charAt((img6.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }

                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("")){
                    selected = img7.getTag().toString().substring(0,img7.getTag().toString().length()-1);
                    s2=img7.getTag().toString().charAt((img7.getTag().toString().length())-1);
                    img7.setBackgroundResource(R.drawable.correct);

                    img7.setClickable(false);

                }else{
                    if (selected.equals(img7.getTag().toString().substring(0,img7.getTag().toString().length()-1))){
                        img7.setBackgroundResource(R.drawable.correct);

                        selected="";
                        img7.setClickable(false);
                        correct();
                        s2=img7.getTag().toString().charAt((img7.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }

                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("")){
                    selected = img8.getTag().toString().substring(0,img8.getTag().toString().length()-1);
                    s2=img8.getTag().toString().charAt((img8.getTag().toString().length())-1);
                    img8.setBackgroundResource(R.drawable.correct);

                    img8.setClickable(false);

                }else{
                    if (selected.equals(img8.getTag().toString().substring(0,img8.getTag().toString().length()-1))){
                        img8.setBackgroundResource(R.drawable.correct);

                        selected="";
                        img8.setClickable(false);
                        correct();
                        s2=img8.getTag().toString().charAt((img8.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }

                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("")){
                    selected = img9.getTag().toString().substring(0,img9.getTag().toString().length()-1);
                    s2=img9.getTag().toString().charAt((img9.getTag().toString().length())-1);
                    img9.setBackgroundResource(R.drawable.correct);
                    img9.setClickable(false);


                }else{
                    if (selected.equals(img9.getTag().toString().substring(0,img9.getTag().toString().length()-1))){
                        img9.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img9.setClickable(false);
                        correct();
                        s2=img9.getTag().toString().charAt((img9.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }

                    }
                    else{
                        incorrect();
                    }
                }
            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected.equals("")){
                    selected = img10.getTag().toString().substring(0,img10.getTag().toString().length()-1);
                    s2=img10.getTag().toString().charAt((img10.getTag().toString().length())-1);
                    img10.setBackgroundResource(R.drawable.correct);

                    img10.setClickable(false);

                }else{
                    if (selected.equals(img10.getTag().toString().substring(0,img10.getTag().toString().length()-1))){
                        img10.setBackgroundResource(R.drawable.correct);
                        selected="";
                        img10.setClickable(false);
                        correct();
                        s2=img10.getTag().toString().charAt((img10.getTag().toString().length())-1);
//                        Toast.makeText(MatchTheFollowing.this, Character.toString(s2), Toast.LENGTH_SHORT).show();
                        strUpLine(s1,s2,1);
                        match++;
                        if (match==5){
                            answer(chapter);
                        }
                    }
                    else{
                        incorrect();
                    }
                }

            }

        });

    }

    public void levelSet(int chapter ){
        // for class
        img1.setText("पेड़");
        img1.setTag("tree1");
        img2.setText("बादल");
        img2.setTag("cloud2");
        img3.setText("पत्ता");
        img3.setTag("leaf3");
        img4.setText("जोड़ा");
        img4.setTag("pair4");
        img5.setText("बूंद");
        img5.setTag("droplet5");
        img6.setImageResource(R.drawable.pair);
        img6.setTag("pair6");
        img7.setImageResource(R.drawable.droplet);
        img7.setTag("droplet7");
        img8.setImageResource(R.drawable.tree);
        img8.setTag("tree8");
        img9.setImageResource(R.drawable.cloud);
        img9.setTag("cloud9");
        img10.setImageResource(R.drawable.leaf);
        img10.setTag("leaf0");
    }
    public void answer(int chapter) {
//        Toast.makeText(this, "Showing Answers ", Toast.LENGTH_SHORT).show();
        img1.animate().alpha(1).setDuration(1000).start();
        img2.animate().alpha(1).setDuration(1000).start();
        img3.animate().alpha(1).setDuration(1000).start();
        img4.animate().alpha(1).setDuration(1000).start();
        img5.animate().alpha(1).setDuration(1000).start();
        img6.animate().alpha(1).setDuration(1000).start();
        img7.animate().alpha(1).setDuration(1000).start();
        img8.animate().alpha(1).setDuration(1000).start();
        img10.animate().alpha(1).setDuration(1000).start();
        img9.animate().alpha(1).setDuration(1000).start();

        img6.setImageResource(R.drawable.tree);
        img7.setImageResource(R.drawable.cloud);
        img8.setImageResource(R.drawable.leaf);
        img9.setImageResource(R.drawable.pair);
        img10.setImageResource(R.drawable.droplet);


        CountDownTimer count = new CountDownTimer(10000, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MatchHindiChapOne.this, "Going Back in 10 Sec", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {
                activityBack();
            }
        }.start();
    }








    public void correct(){
        TextView message=findViewById(R.id.message);
        message.setVisibility(View.VISIBLE);
        message.setText("Hurray Correct Answer \uD83C\uDF89");
        CountDownTimer count=new CountDownTimer(2000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                message.setVisibility(View.INVISIBLE);

            }
        }.start();
    }

    public void incorrect(){
        TextView message=findViewById(R.id.message);
        message.setVisibility(View.VISIBLE);
        message.setText("Oops Try Again");
        CountDownTimer count=new CountDownTimer(2000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                message.setVisibility(View.INVISIBLE);

            }
        }.start();

    }


    public void strUpLine(int s1,int s2,int matchNo){
        if (Character.toString((char) s1).equals(Integer.toString(1)) && Character.toString((char) s2).equals(Integer.toString(9)) ){
            img1.animate().rotationY(30).setDuration(2500).start();
            img9.animate().rotationY(-30).setDuration(2500).start();
            img1.animate().alpha(0).setDuration(3000).start();
            img9.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(1)) && Character.toString((char) s2).equals(Integer.toString(6))){
            img1.animate().rotationY(30).setDuration(2500).start();
            img6.animate().rotationY(-30).setDuration(2500).start();
            img1.animate().alpha(0).setDuration(3000).start();
            img6.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(1)) && Character.toString((char) s2).equals(Integer.toString(7))){
            img1.animate().rotationY(30).setDuration(2500).start();
            img7.animate().rotationY(-30).setDuration(2500).start();
            img1.animate().alpha(0).setDuration(3000).start();
            img7.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(1)) && Character.toString((char) s2).equals(Integer.toString(8))){
            img1.animate().rotationY(30).setDuration(2500).start();
            img8.animate().rotationY(-30).setDuration(2500).start();
            img1.animate().alpha(0).setDuration(3000).start();
            img8.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(1)) && Character.toString((char) s2).equals(Integer.toString(0))){
            img1.animate().rotationY(30).setDuration(2500).start();
            img10.animate().rotationY(-30).setDuration(2500).start();
            img1.animate().alpha(0).setDuration(3000).start();
            img10.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(2)) && Character.toString((char) s2).equals(Integer.toString(9)) ){
            img2.animate().rotationY(30).setDuration(2500).start();
            img9.animate().rotationY(-30).setDuration(2500).start();
            img2.animate().alpha(0).setDuration(3000).start();
            img9.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(2)) && Character.toString((char) s2).equals(Integer.toString(6))){
            img2.animate().rotationY(30).setDuration(2500).start();
            img6.animate().rotationY(-30).setDuration(2500).start();
            img2.animate().alpha(0).setDuration(3000).start();
            img6.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(2)) && Character.toString((char) s2).equals(Integer.toString(7))){
            img2.animate().rotationY(30).setDuration(2500).start();
            img7.animate().rotationY(-30).setDuration(2500).start();
            img2.animate().alpha(0).setDuration(3000).start();
            img7.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(2)) && Character.toString((char) s2).equals(Integer.toString(8))){
            img2.animate().rotationY(30).setDuration(2500).start();
            img8.animate().rotationY(-30).setDuration(2500).start();
            img2.animate().alpha(0).setDuration(3000).start();
            img8.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(2)) && Character.toString((char) s2).equals(Integer.toString(0))){
            img2.animate().rotationY(30).setDuration(2500).start();
            img10.animate().rotationY(-30).setDuration(2500).start();
            img2.animate().alpha(0).setDuration(3000).start();
            img10.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(3)) && Character.toString((char) s2).equals(Integer.toString(9)) ){
            img3.animate().rotationY(30).setDuration(2500).start();
            img9.animate().rotationY(-30).setDuration(2500).start();
            img3.animate().alpha(0).setDuration(3000).start();
            img9.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(3)) && Character.toString((char) s2).equals(Integer.toString(6))){
            img3.animate().rotationY(30).setDuration(2500).start();
            img6.animate().rotationY(-30).setDuration(2500).start();
            img3.animate().alpha(0).setDuration(3000).start();
            img6.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(3)) && Character.toString((char) s2).equals(Integer.toString(7))){
            img3.animate().rotationY(30).setDuration(2500).start();
            img7.animate().rotationY(-30).setDuration(2500).start();
            img3.animate().alpha(0).setDuration(3000).start();
            img7.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(3)) && Character.toString((char) s2).equals(Integer.toString(8))){
            img3.animate().rotationY(30).setDuration(2500).start();
            img8.animate().rotationY(-30).setDuration(2500).start();
            img3.animate().alpha(0).setDuration(3000).start();
            img8.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(3)) && Character.toString((char) s2).equals(Integer.toString(0))){
            img3.animate().rotationY(30).setDuration(2500).start();
            img10.animate().rotationY(-30).setDuration(2500).start();
            img3.animate().alpha(0).setDuration(3000).start();
            img10.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(4)) && Character.toString((char) s2).equals(Integer.toString(9)) ){
            img4.animate().rotationY(30).setDuration(2500).start();
            img9.animate().rotationY(-30).setDuration(2500).start();
            img4.animate().alpha(0).setDuration(3000).start();
            img9.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(4)) && Character.toString((char) s2).equals(Integer.toString(6))){
            img4.animate().rotationY(30).setDuration(2500).start();
            img6.animate().rotationY(-30).setDuration(2500).start();
            img4.animate().alpha(0).setDuration(3000).start();
            img6.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(4)) && Character.toString((char) s2).equals(Integer.toString(7))){
            img4.animate().rotationY(30).setDuration(2500).start();
            img7.animate().rotationY(-30).setDuration(2500).start();
            img4.animate().alpha(0).setDuration(3000).start();
            img7.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(4)) && Character.toString((char) s2).equals(Integer.toString(8))){
            img4.animate().rotationY(30).setDuration(2500).start();
            img8.animate().rotationY(-30).setDuration(2500).start();
            img4.animate().alpha(0).setDuration(3000).start();
            img8.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(4)) && Character.toString((char) s2).equals(Integer.toString(0))){
            img4.animate().rotationY(30).setDuration(2500).start();
            img10.animate().rotationY(-30).setDuration(2500).start();
            img4.animate().alpha(0).setDuration(3000).start();
            img10.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(5)) && Character.toString((char) s2).equals(Integer.toString(9)) ){
            img5.animate().rotationY(30).setDuration(2500).start();
            img9.animate().rotationY(-30).setDuration(2500).start();
            img5.animate().alpha(0).setDuration(3000).start();
            img9.animate().alpha(0).setDuration(3000).start();
        }
        else if (Character.toString((char) s1).equals(Integer.toString(5)) && Character.toString((char) s2).equals(Integer.toString(6))){
            img5.animate().rotationY(30).setDuration(2500).start();
            img6.animate().rotationY(-30).setDuration(2500).start();
            img5.animate().alpha(0).setDuration(3000).start();
            img6.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(5)) && Character.toString((char) s2).equals(Integer.toString(7))){
            img5.animate().rotationY(30).setDuration(2500).start();
            img7.animate().rotationY(-30).setDuration(2500).start();
            img5.animate().alpha(0).setDuration(3000).start();
            img7.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(5)) && Character.toString((char) s2).equals(Integer.toString(8))){
            img5.animate().rotationY(30).setDuration(2500).start();
            img8.animate().rotationY(-30).setDuration(2500).start();
            img5.animate().alpha(0).setDuration(3000).start();
            img8.animate().alpha(0).setDuration(3000).start();

        }
        else if (Character.toString((char) s1).equals(Integer.toString(5)) && Character.toString((char) s2).equals(Integer.toString(0))){
            img5.animate().rotationY(30).setDuration(2500).start();
            img10.animate().rotationY(-30).setDuration(2500).start();
            img5.animate().alpha(0).setDuration(3000).start();
            img10.animate().alpha(0).setDuration(3000).start();
        }
        else{
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

        }
    }
    public void activityBack(){
        startActivity(new Intent(getApplicationContext(), LearningActivity.class));
        finish();
    }
}