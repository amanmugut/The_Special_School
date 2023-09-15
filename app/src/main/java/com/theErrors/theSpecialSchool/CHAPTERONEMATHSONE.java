package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERONEMATHSONE extends AppCompatActivity {


    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Which one is circle?",
            "Q2.Man is sitting _ the tent",
            "Q3.\uD83D\uDFE5 which shape is this ",
            "Q4.Camel is sitting _ the tent "

    };
    public static String [] options={
            "\uD83D\uDD34","\uD83D\uDFE5","♦","*",
            "outside", "inside", "in", "below",
            "diamond", "square", "circle", "oval",
            "below", "out", "outside", "inside"
    };
    public static String [] correctAnswer={
            "\uD83D\uDD34","inside","square","outside"

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