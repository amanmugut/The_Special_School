package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER16HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम ",
            "Q2.\uD83D\uDC00 यह कौन है? ",
            "Q3.तोता कौन सा है इनमे से?",
            "Q4.पीठ पर कौन बैठालता तो मजा आता?",
            "Q5.\uD83D\uDC34 ये कौन सा जानवर है? "

    };
    public static String [] options={
            "घोड़ा","चने","चार चने","दो चने",
            "चूहा", "खरगोश", "उल्लू", "कबूतर",
            "\uD83E\uDDA9", "\uD83E\uDDA2", "\uD83E\uDD83", "\uD83E\uDD9C",
            "चूहा", "तोताी", "घोड़ा", "हाथी",
            "घोड़ा","हाथी","गाय","बैल"
    };
    public static String [] correctAnswer={
            "चार चने","चूहा","\uD83E\uDD9C","घोड़ा","घोड़ा"

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