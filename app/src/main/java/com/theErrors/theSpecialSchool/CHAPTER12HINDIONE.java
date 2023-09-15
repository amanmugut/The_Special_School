package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER12HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.कौन पानी मे डूब रहा था?",
            "Q2.किसने बोला मै  घूमने जा रहा हूँ? ",
            "Q3.पाठ का क्या नाम है? ",
            "Q4.यह क्या है \uD83E\uDD5A",
            "Q5.कबतख कौन है इसमें से? "

    };
    public static String [] options={
            "चूजा","बतख","मछली","मेढ़क",
            "चूजा", "पक्षी", "बतख", "मेढक",
            "तुम भी", "मैं भी.. ", "हम सब", "कोई नहीं",
            "गेंद", "अंडा", "चूजा", "आम",
            "\uD83D\uDC24","\uD83E\uDD89","\uD83E\uDD86","\uD83E\uDD85"
    };
    public static String [] correctAnswer={
            "चूजा","बतख","मैं भी.. ","अंडा","\uD83E\uDD86"

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