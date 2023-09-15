package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERFIVEHINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.\uD83C\uDF53 ये क्या है? ",
            "Q2.\uD83E\uDD54 किसे काटते हैं?",
            "Q3.चाँद जैसा क्या था?",
            "Q4.मुना, मुनी क्या खोल रहे हैं?",
            "Q5.\uD83C\uDF46 यह क्या है? "

    };
    public static String [] options={
            "फल","सेब","सब्जी","मिठाई",
            "चाकू", "बेलन", "\uD83E\uDD44", "कौआ",
            "घर", "छत", "थाली", "मोर",
            "दरवाज़ा", "लोमड़ी", "आँख", "खिड़की",
            "सब्जी","फल","रोटी","मिठाई"
    };
    public static String [] correctAnswer={
            "फल","चाकू","थाली","खिड़की","सब्जी"

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