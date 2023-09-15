package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERTHREEHINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.मैं _ तक  गिनूगी",
            "Q2.\uD83C\uDF42 ये कौन सा रंग का पत्ता है?",
            "Q3.हरे रंग का पत्ता कौन सा है?",
            "Q4.लंबा पत्ता कौन सा है?",
            "Q5.बच्चे क्या कर रहे थे!"

    };
    public static String [] options={
            "दस","एक","पाँच","सात",
            "हरा", "काला", "लाल", "पीला",
            "\uD83C\uDF40", "\uD83C\uDF41", "\uD83C\uDF38", "\uD83C\uDF4D",
            "\uD83C\uDF43", "\uD83E\uDD55", "\uD83E\uDD6C", "\uD83C\uDF3D",
            "लडाई","नाच","खेल","रो"
    };
    public static String [] correctAnswer={
            "पाँच","पीला","\uD83C\uDF40","\uD83E\uDD6C","खेल"

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