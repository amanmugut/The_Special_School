package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERFOURMATHSONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.4-2=? ",
            "Q2.\uD83D\uDFEB \uD83D\uDFEB \uD83D\uDFEB \uD83D\uDFEB-\uD83D\uDFEB =? ",
            "Q3.-= 6",
            "Q4.5-1=? ",
            "Q5.6-2=? "

    };
    public static String [] options={
            "2","1","3","4",
            "5", "3", "1", "6",
            "2-4", "5-3", "8-2", "6-3",
            "6", "4", "9", "2",
            "4","9","3","2"
    };
    public static String [] correctAnswer={
            "2","3","8-2","4","4"

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