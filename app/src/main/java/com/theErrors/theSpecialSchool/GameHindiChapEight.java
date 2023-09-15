package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameHindiChapEight extends AppCompatActivity {
    TextView optA,optB,optC,optD,optE,optF;
    TextView t1,t2,t3,t4,t5,t6;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hindi_chap_eight);
        optA=findViewById(R.id.optA);
        optB=findViewById(R.id.OptB);
        optD=findViewById(R.id.OptD);
        optF=findViewById(R.id.OptF);
        optC=findViewById(R.id.optC);
        optE=findViewById(R.id.optE);

        t1=findViewById(R.id.fillA);
        t2=findViewById(R.id.fillB);
        t3=findViewById(R.id.fillC);
        t4=findViewById(R.id.fillD);
        t5=findViewById(R.id.fillE);
        t6=findViewById(R.id.fillF);

        optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4.setText(optA.getText().toString());
                t4.animate().rotationX(360).setDuration(2000).start();
                optA.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });






        optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t5.setText(optB.getText().toString());
                t5.animate().rotationX(360).setDuration(2000).start();
                optB.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });

        optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t6.setText(optC.getText().toString());
                t6.animate().rotationX(360).setDuration(2000).start();
                optC.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });

        optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText(optD.getText().toString());
                t2.animate().rotationX(360).setDuration(2000).start();
                optD.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });

        optE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3.setText(optE.getText().toString());
                t3.animate().rotationX(360).setDuration(2000).start();
                optE.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });

        optF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(optF.getText().toString());
                t1.animate().rotationX(360).setDuration(2000).start();
                optF.animate().alpha(0f).setDuration(2000).start();
                count++;
                if (count==6){
                    ActivityBack();
                }

            }
        });





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
}