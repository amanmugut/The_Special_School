package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER11HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम?",
            "Q2.कवह दिनभर__रहती थी",
            "Q3.किस के ना होने से उसे आराम नही था? ",
            "Q4.क्या उस बुढ़िया का कोई नाम था?"

    };
    public static String [] options={
            "एक","एक बुढ़िया","बुढ़िया","रानी",
            "सोती", "गाती", "खाली", "बच्चे",
            "काम", "रात", "बंदर", "बच्चे",
            "नहीं", "हा", "खरगोश", "रानी"
    };
    public static String [] correctAnswer={
            "एक बुढ़िया","खाली","काम","नहीं"

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