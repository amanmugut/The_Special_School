package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER12MATHONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.Do we have ₹56 coin? ",
            "Q2.Do you use money to buy toys",
            "Q3.Have you saw ₹10 note ? "

    };
    public static String [] options={
            "YES","NO","MAYBE","CAN'T ANSWER",
            "NEVER", "YES", "SOMETIME", "MAY BE",
            "NEVER", "YES", "NO", "MAY BE",
    };
    public static String [] correctAnswer={
            "NO","YES","YES","खरगोश"

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