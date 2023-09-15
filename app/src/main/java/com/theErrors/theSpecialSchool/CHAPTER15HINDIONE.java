package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER15HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का नाम?",
            "Q2.ककौन पतली दुबली थी? ",
            "Q3.पयह क्या है? \uD83E\uDD54 ",
            "Q4.कौन लंबा था? ",
            "Q5.कौन पहुुंचेगा चोटी पर? "

    };
    public static String [] options={
            "छोटी का कमाल","छोटी","बड़ी का कमाल","बड़ी",
            "बड़ी", "समरसिंहा", "छोटी", "लड़का",
            "गोभी", "मूली", "जागर", "आलू",
            "छोटी", "बड़ी", "समरसिंह", "आलू",
            "समरसिंह","छोटी","रानी","गुड़िया"
    };
    public static String [] correctAnswer={
            "छोटी का कमाल","छोटी","आलू","समरसिंह","छोटी"

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