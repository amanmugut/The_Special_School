package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER17HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम?",
            "Q2.बुढ़िया कितने वर्ष की थी? ",
            "Q3.यह कौन है?\uD83D\uDC08 ",
            "Q4.कुता कौन है इन जानवर मे? ",
            "Q5.कुता क्या लेकर भगा?"

    };
    public static String [] options={
            "भगदड़","शोर","बुढ़िया","चकिया",
            "पचास", "तीस", "सतर", "साठ",
            "शेर", "बिल्ली", "खरगोश", "चील",
            "\uD83D\uDC12", "\uD83E\uDD89", "\uD83E\uDDAE", "\uD83D\uDC07",
            "खीर","रोती","सब्जी","मिठाई"
    };
    public static String [] correctAnswer={
            "भगदड़","साठ","बिल्ली","\uD83E\uDDAE","रोती"

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