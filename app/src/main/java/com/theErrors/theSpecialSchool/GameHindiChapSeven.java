package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameHindiChapSeven extends AppCompatActivity {
    int level;

    TextView levelDisplay;
    TextView timerDisplay;
    TextView quest;
    TextView messageDisplay;
    ImageView optA;
    ImageView optB;
    ImageView optC;

    LinearLayout ln;
    TextView textOA;
    TextView textOB;
    TextView textOC;
    ArrayList<String> Questions=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hindi_chap_seven);


        Questions.add("ज़मीन पर अचल खूद कौन कर रा था ?");
        Questions.add("बंदर की फूच खा तक लटकती थी");
        Questions.add("गिलहरी ने फूच को क्या समझा?");
        Questions.add("कहानी में बंदर को गुडगुडी क्यों होती है?");

        quest=findViewById(R.id.question);
        optA=findViewById(R.id.optionA);
        optB=findViewById(R.id.optionB);
        optC=findViewById(R.id.optionC);
        messageDisplay=findViewById(R.id.message);
        levelDisplay=findViewById(R.id.level);
        timerDisplay=findViewById(R.id.time);
        textOA=findViewById(R.id.textOA);
        textOB=findViewById(R.id.textOB);
        textOC=findViewById(R.id.textOC);
        ln=findViewById(R.id.textOptions);


        levelSet();
        textOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textOA.getTag().toString().equals("correct")){
                    correct();
                    textOA.setBackgroundResource(R.color.green);



                }
                else {
                    incorrect();
                }

            }
        });

        textOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textOB.getTag().toString().equals("correct")){
                    correct();
                    textOB.setBackgroundResource(R.color.green);


                }
                else {
                    incorrect();
                }

            }
        });

        textOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textOC.getTag().toString().equals("correct")){
                    correct();
                    textOC.setBackgroundResource(R.color.green);

                    ActivityBack();

                }
                else {
                    incorrect();
                }

            }
        });

        optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optA.getTag().toString().equals("correct")){
                    correct();
                    optA.setBackgroundResource(R.color.green);



                }
                else {
                    incorrect();
                }

            }
        });

        optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optB.getTag().toString().equals("correct")){
                    correct();
                    optB.setBackgroundResource(R.color.green);


                }
                else {
                    incorrect();
                }

            }
        });

        optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optC.getTag().toString().equals("correct")){
                    correct();
                    optC.setBackgroundResource(R.color.green);


                }
                else {
                    incorrect();
                }

            }
        });
    }

    public void incorrect(){
        messageDisplay.setVisibility(View.VISIBLE);
        messageDisplay.setText("Wrong Answer Please Try Again ");
        CountDownTimer counterNew=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                messageDisplay.setVisibility(View.INVISIBLE);

            }
        }.start();
    }

    public void correct(){
        messageDisplay.setVisibility(View.VISIBLE);
        timerDisplay.setVisibility(View.VISIBLE);
        messageDisplay.setText("Hurray Correct Answer !! \uD83C\uDF89 ");
        optA.setClickable(false);
        optB.setClickable(false);
        optC.setClickable(false);

        textOC.setClickable(false);
        textOB.setClickable(false);
        textOA.setClickable(false);
        CountDownTimer  counter=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerDisplay.setText("Next Question : "+millisUntilFinished/1000);


            }

            @Override
            public void onFinish() {
                messageDisplay.setVisibility(View.INVISIBLE);
                timerDisplay.setVisibility(View.INVISIBLE);
                level++;
                levelSet();

            }
        }.start();

    }

    public void ActivityBack(){
        Toast.makeText(this, "Level Completed Exit in 5 sec", Toast.LENGTH_LONG).show();
        CountDownTimer count=new CountDownTimer(5000,5000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(), LearningActivity.class));
                finish();

            }
        }.start();
    }



    public void levelSet(){



        levelDisplay.setText("Question : "+(level+1));
        quest.setText(Questions.get(level));
        optA.setTag("incorrect");
        optB.setTag("incorrect");
        optC.setTag("incorrect");
        optA.setClickable(true);
        optB.setClickable(true);
        optC.setClickable(true);
        optA.setBackgroundResource(R.drawable.blackborder);
        optB.setBackgroundResource(R.drawable.blackborder);
        optC.setBackgroundResource(R.drawable.blackborder);

        textOA.setClickable(true);
        textOB.setClickable(true);
        textOC.setClickable(true);

        textOA.setBackgroundResource(R.color.bluelight);
        textOB.setBackgroundResource(R.color.bluelight);
        textOC.setBackgroundResource(R.color.bluelight);





        if (level==0){
            optA.setImageResource(R.drawable.monkey);
            optB.setImageResource(R.drawable.sqr);
            optC.setImageResource(R.drawable.tortoise);
            optB.setTag("correct");
        }
        else if (level==1){
            optC.setImageResource(R.drawable.lake);
            optB.setImageResource(R.drawable.sky);
            optA.setImageResource(R.drawable.ground);
            optA.setTag("correct");

        }
        else if (level==2){
            optA.setImageResource(R.drawable.rope);
            optB.setImageResource(R.drawable.jhoola);
            optC.setImageResource(R.drawable.snake);
            optB.setTag("correct");

        }
        else if (level==3){
            optA.setVisibility(View.INVISIBLE);
            optB.setVisibility(View.INVISIBLE);
            optC.setVisibility(View.INVISIBLE);

            optA.setClickable(false);
            optB.setClickable(false);
            optC.setClickable(false);
            textOC.setTag("correct");
            ln.setVisibility(View.VISIBLE);


        }
        else{
            Toast.makeText(this, "Something Went Wrong ", Toast.LENGTH_SHORT).show();
        }



    }
}