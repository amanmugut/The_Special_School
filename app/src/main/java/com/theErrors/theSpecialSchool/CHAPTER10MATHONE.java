package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER10MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.\uD83D\uDFE5 \uD83D\uDD34 \uD83D\uDD36__",
            "Q2.\uD83C\uDF33 \uD83C\uDF3F \uD83C\uDF31__",
            "Q3.\uD83D\uDFE9 \uD83D\uDED1 \uD83D\uDD36__"

    };

    public static String [] options={
            "\uD83D\uDFE5","\uD83D\uDD34","\uD83D\uDD36","\uD83D\uDFE1",
            "\uD83C\uDF31","\uD83C\uDF3F","\uD83C\uDF33","\uD83D\uDFE5",
            "♦", "⬜", "\uD83D\uDFE5","\uD83D\uDFE9"
    };

    public static String [] correctAnswer={
            "\uD83D\uDFE5","\uD83C\uDF33","\uD83D\uDFE9"
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