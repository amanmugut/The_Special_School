package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER8HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.कौन पतंग उड़ा रहा है?",
            "Q2.पाठ का क्या नाम है?",
            "Q3.सर सर_ पतंग",
            "Q4._ गयी लुटी पतंग"

    };
    public static String [] options={
            "बड़े","बच्चे","काग़ज़","शेर",
            "पतंग", "बच्चे", "खेल", "हवा",
            "हवा", "बादल", "रसी", "उड़ी",
            "हट", "लुटी", "फँस", "कट"
    };
    public static String [] correctAnswer={
            "बच्चे","पतंग","उड़ी","कट"

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