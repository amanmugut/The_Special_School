package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER14HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.खेल __भैया! आओ चले हम तुम|",
            "Q2.यह क्या है? \uD83C\uDF3C",
            "Q3.काग़ज की _ पार करे हम तुम!",
            "Q4.__पिये हम तुम "

    };
    public static String [] options={
            "केला","खतम","शुरू","होने",
            "लड़की", "सूरज", "आम", "फूल",
            "जहाज", "चील", "नैया", "गाड़ी",
            "पानी", "लोमड़ी", "दूध", "खीर"
    };
    public static String [] correctAnswer={
            "खतम","फूल","नैया","दूध"

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