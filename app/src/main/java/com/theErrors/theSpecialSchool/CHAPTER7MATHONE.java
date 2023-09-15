package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER7MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Which is the tallest among these?",
            "Q2.Which is the shortest among these? ",
            "Q3.Which one is thicker? ",
            "Q4.Which one is heavier "

    };
    public static String [] options={
            "\uD83D\uDD38","\uD83D\uDD39","\uD83D\uDFE5","\uD83D\uDD38",
            "\uD83D\uDC5C", "\uD83D\uDC5D", "\uD83D\uDCBC", "\uD83C\uDF92",
            "\uD83C\uDF33", "\uD83C\uDF34", "\uD83C\uDF31", "\uD83C\uDF3F",
            "\uD83D\uDE8E", "\uD83D\uDEF4", "\uD83E\uDDBD", "\uD83E\uDDBC"
    };
    public static String [] correctAnswer={
            "\uD83D\uDFE5","\uD83D\uDC5D","\uD83C\uDF33","\uD83D\uDE8E"

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