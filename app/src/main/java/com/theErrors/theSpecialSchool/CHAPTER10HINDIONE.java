package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER10HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.बंदर गया _ मे भाग",
            "Q2.बंदर क्या खा रहा है?",
            "Q3.3 _ जलाकर पकाया साग",
            "Q4.खेत से बंदर ने क्या तोड़ा?",
            "Q5.इसमें से बंदर कौन है? "

    };
    public static String [] options={
            "जंगल","घर","खेत","पेड़",
            "रोटी", "केला", "मिठाई", "साग",
            "लकड़ी", "आग", "तेल", "काग़ज़",
            "इमली", "आम", "साग", "चना",
            "\uD83E\uDD85","\uD83E\uDD89","\uD83D\uDC12","\uD83D\uDC26"
    };
    public static String [] correctAnswer={
            "खेत","साग","आग","साग","\uD83D\uDC12"

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