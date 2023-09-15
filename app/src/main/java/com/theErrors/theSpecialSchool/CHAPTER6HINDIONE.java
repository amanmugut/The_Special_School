package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER6HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.कौन सो रही हैं? ",
            "Q2.पाठ मे किस को मौसी बोला जा रहा है?",
            "Q3.यह कौन है?\uD83D\uDC31",
            "Q4.चीजें कौन कुतर देता है? "

    };
    public static String [] options={
            "बंदर","चिड़ियाँ","आम","बिल्ली",
            "चूहा", "लड़का", "बिल्ली", "तितली",
            "कौआ", "\uD83D\uDC24", "बिल्ली", "\uD83D\uDC3C",
            "शेर", "\uD83D\uDC01", "\uD83D\uDC2C", "\uD83D\uDC37"
    };
    public static String [] correctAnswer={
            "बिल्ली","बिल्ली","बिल्ली","\uD83D\uDC01"

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