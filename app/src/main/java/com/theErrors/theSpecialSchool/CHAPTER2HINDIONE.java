package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER2HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम _ की कहानी हैं।",
            "Q2.किस के सिर पर  पगड़ी थी?",
            "Q3.पेड़ मे किसका घोसला था? ",
            "Q4.\uD83D\uDC07 इस पशु का क्या नाम है? ",
            "Q5.किस चीज के नाम मे 'आ' की आवाज़ आती हैं "

    };
    public static String [] options={
            "केला","सेब","आम","अनार",
            "लड़की", "लड़का", "आदमी", "कौआ",
            "कौआ", "चील", "बंदर", "मोर",
            "शेर", "लोमड़ी", "खरगोश", "चूहा",
            "\uD83D\uDC14","\uD83E\uDD89","\uD83E\uDD6D","\uD83C\uDF3B"
    };
    public static String [] correctAnswer={
            "आम","आदमी","कौआ","खरगोश","\uD83E\uDD6D"

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