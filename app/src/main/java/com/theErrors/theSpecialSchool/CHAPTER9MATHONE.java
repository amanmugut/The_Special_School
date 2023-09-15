package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER9MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Count it?  ।।।।।।।।।। ",
            "Q2.Which shape occurs most? \uD83D\uDFE5,\uD83D\uDFE5\uD83D\uDFE1,\uD83D\uDD36",
            "Q3.Which number occur the most?4,4,4,5",
            "Q4.which shape occurs most? ⬜ ♦ \uD83D\uDD34 \uD83D\uDD34"

    };
    public static String [] options={
            "15","10","28","33",
            "⬛", "\uD83D\uDFEA", "\uD83D\uDFE5", "\uD83D\uDD36",
            "5", "9", "4", "8",
            "⬜", "\uD83D\uDD34", "♦", "\uD83D\uDD36"
    };
    public static String [] correctAnswer={
            "10","\uD83D\uDFE5","4","\uD83D\uDD34"

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