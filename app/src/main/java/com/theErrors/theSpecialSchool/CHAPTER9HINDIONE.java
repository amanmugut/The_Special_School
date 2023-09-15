package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTER9HINDIONE extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1.किसने कहा कि तुम मुझे मारते हो?",
            "Q2.पाठ का क्या नाम है?",
            "Q3.झाड़ी मे कौन छुप गया?",
            "Q4.गेंद ने कहा अब _ मत",
            "Q5.\uD83C\uDFCF यह क्या है? "

    };
    public static String [] options={
            "गेंद","सेब","बल्ला","झाड़ी",
            "हँसी", "लड़का", "गेंद-बल्ला", "खेल",
            "बल्ला", "चील", "गेंद-बल्ला", "गेंद",
            "खेलना", "लोमड़ी", "हँसना", "मारना",
            "लकड़ी","गेंद-बल्ला","बल्ला","गेंद"
    };
    public static String [] correctAnswer={
            "गेंद","गेंद-बल्ला","गेंद","मारना","गेंद-बल्ला"

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