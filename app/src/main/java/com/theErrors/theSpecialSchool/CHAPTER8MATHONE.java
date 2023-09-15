package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER8MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.22+12=? ",
            "Q2.13+20=? ",
            "Q3.22+15=? "

    };
    public static String [] options={
            "34","45","21","33",
            "33", "21", "40", "16",
            "49", "55", "37", "26"
    };
    public static String [] correctAnswer={
            "34","33","37"

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