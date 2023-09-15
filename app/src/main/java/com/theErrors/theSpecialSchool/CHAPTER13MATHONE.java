package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER13MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Which one is bigger number? 56,44,1,4 ",
            "Q2.Which one is bigger number? 33,9,41,2 ",
            "Q3.Which one is smallest number? 63,77,41,18 ",
            "Q4.Which one is smallest number? 99,13,29,56"

    };
    public static String [] options={
            "56","44","1","4",
            "33", "9", "41", "2",
            "63", "77", "41", "18",
            "99", "13", "29", "56"
    };
    public static String [] correctAnswer={
            "56","41","18","13"

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