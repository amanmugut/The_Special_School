package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERTHREEMATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.2+1=? ",
            "Q2.⚫,⚫+\uD83D\uDD35,\uD83D\uDD35,\uD83D\uDD35= ?",
            "Q3.?=4",
            "Q4.5+2 =? ",
            "Q5.\uD83D\uDFE7+\uD83D\uDFE9,\uD83D\uDFE9="

    };
    public static String [] options={
            "6","3","1","4",
            "5", "2", "1", "3",
            "1+1", "2+3", "2+2", "3+5",
            "4", "7", "8", "9",
            "3","6","8","1"
    };
    public static String [] correctAnswer={
            "3","5","2+2","7","3"

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        questionPlace=findViewById(R.id.questionPlace);

        CHAPTERONEHINDIQUIZ.question=question;
        CHAPTERONEHINDIQUIZ.correctAnswer=correctAnswer;
        CHAPTERONEHINDIQUIZ.options=options;


        QuizAdapter adapter=new QuizAdapter(question,options,correctAnswer,this);
        questionPlace.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        questionPlace.setLayoutManager(layoutManager);

    }
}