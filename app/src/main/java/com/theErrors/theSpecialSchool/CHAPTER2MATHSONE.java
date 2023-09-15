package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER2MATHSONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Count & ans\uD83D\uDC51 \uD83D\uDC51",
            "Q2.Which one is four ",
            "Q3.How many honey bees going to live in hive? ",
            "Q4.How many baby eating bun? ",
            "Q5.Select 3 square? "

    };
    public static String [] options={
            "5","9","2","3",
            "6", "1", "3", "4",
            "9", "2", "5", "7",
            "5", "6", "1", "3",
            "\uD83D\uDFEA \uD83D\uDFEA \uD83D\uDFEA","⬜","\uD83D\uDFE9 \uD83D\uDFE9","\uD83D\uDFE8 \uD83D\uDFE8 \uD83D\uDFE8 \uD83D\uDFE8"
    };
    public static String [] correctAnswer={
            "2","4","5","1","\uD83D\uDFEA \uD83D\uDFEA \uD83D\uDFEA"

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