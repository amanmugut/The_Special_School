package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERFIVEMATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.5+6= ? ",
            "Q2.3+12=? ",
            "Q3.\uD83D\uDED1 \uD83D\uDED1 \uD83D\uDED1 \uD83D\uDED1 \uD83D\uDED1+⬛⬛⬛⬛⬛=? ",
            "Q4.6+6=? ",
            "Q5.11+2=? "

    };
    public static String [] options={
            "2","11","4","3",
            "15", "6", "19", "3",
            "15", "19", "13", "10",
            "19", "15", "12", "11",
            "15","18","13","14"
    };
    public static String [] correctAnswer={
            "11","15","10","12","13"
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