package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERFOURHINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.पाठ का क्या नाम है?",
            "Q2.पकौड़ी किस पर रखी हैं?",
            "Q3.कौन पकौड़ी खा रहे है?",
            "Q4.तेल मे क्या बन रहा है?"

    };
    public static String [] options={
            "पकौड़ी","जलेबी","मिठाई","\uD83C\uDF50",
            "बाल्टी", "गिलास", "प्लेट", "\uD83E\uDD6B",
            "बड़े", "पशु", "बच्चे", "\uD83D\uDC12",
            "खीर", "पनीर", "पकौड़ी", "खीर",
    };
    public static String [] correctAnswer={
            "पकौड़ी","प्लेट","बच्चे","पकौड़ी"

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