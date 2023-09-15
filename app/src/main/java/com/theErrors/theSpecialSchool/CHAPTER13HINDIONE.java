package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER13HINDIONE extends AppCompatActivity {
    RecyclerView questionPlace;
    public static String [] question={
            "Q1.मुर्गी के कितने चूजे थे?",
            "Q2.दूसरे चूजे का क्या नाम था? ",
            "Q3.पकिसने लाल मिर्च खा लिया था? ",
            "Q4.पाठ का क्या नाम था? ",
            "Q5.गुड़ किसने खाया? "

    };
    public static String [] options={
            "एक","चार","तीन","दो",
            "लालू", "कालू", "पीलू", "नीलू",
            "लालू", "मुर्गी", "पीलू", "तोता",
            "मुर्गी", "बच्चे", "चूजे", "लालू और पीलू",
            "लालू","कालू","नीलू","मुर्गी"
    };
    public static String [] correctAnswer={
            "दो","पीलू","लालू","लालू और पीलू","लालू"

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