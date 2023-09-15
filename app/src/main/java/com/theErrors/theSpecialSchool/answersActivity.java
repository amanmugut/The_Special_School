package com.theErrors.theSpecialSchool;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class answersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        Intent intent=getIntent();
        int a=intent.getIntExtra("corrected",0);
//        Toast.makeText(this, Integer.toString(a), Toast.LENGTH_SHORT).show();

        TextView score=findViewById(R.id.score);
        RecyclerView questionPlace=findViewById(R.id.questionPlace);
        score.setText("Your Score is : "+Integer.toString(a)+"/"+Integer.toString(CHAPTERONEHINDIQUIZ.question.length));

        correctAdapter adapter=new correctAdapter(CHAPTERONEHINDIQUIZ.question, CHAPTERONEHINDIQUIZ.options, CHAPTERONEHINDIQUIZ.correctAnswer,this);
        questionPlace.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        questionPlace.setLayoutManager(layoutManager);
    }
}