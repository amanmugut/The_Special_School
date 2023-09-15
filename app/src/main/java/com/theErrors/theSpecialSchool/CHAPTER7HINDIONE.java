package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER7HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम क्या है? ",
            "Q2.कजमीन पर क्या लटक रही थी?",
            "Q3._ उछल कूद कर रही थी?",
            "Q4.किस को गुदगुदी हो रही थी?",
            "Q5.बंदर क्या खाता है?"

    };
    public static String [] options={
            "साथी","बंदर और गिलहरी","दोस्ती","खेल_कूद",
            "पूछ", "रस्सी", "धागा", "कपड़ा",
            "हाथी", "बंदर", "कछुआ", "गिलहरी",
            "भालू", "शेर", "बंदर", "पेड़",
            "\uD83C\uDF4C","\uD83C\uDF54","\uD83C\uDF6D","\uD83C\uDF33"
    };
    public static String [] correctAnswer={
            "बंदर और गिलहरी","पूछ","गिलहरी","बंदर","\uD83C\uDF4C"

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