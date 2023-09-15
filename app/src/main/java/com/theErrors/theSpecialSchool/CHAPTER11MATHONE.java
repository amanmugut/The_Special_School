package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER11MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.\uD83D\uDD3A \uD83D\uDD3A \uD83D\uDD3A \uD83D\uDD3A    ▪▪",
            "Q2.♠♠♠    ❌❌❌ ",
            "Q3.\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0         \uD83C\uDFD0"

    };
    public static String [] options={
            "(5,2)","(4,3)","(4,2)","(1,3)",
            "(2,4)", "(9,5)", "(3,3)", "(1,3)",
            "(7,3)", "(1,9)", "(5,1)", "(9,3)"
    };
    public static String [] correctAnswer={
            "(4,2)","(3,3)","(5,1)"

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