package com.theErrors.theSpecialSchool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CHAPTERONEHINDIQUIZ extends AppCompatActivity {

    RecyclerView questionPlace;
    public static String [] question={
            "Q1. __आज लगा दो झूला। ",
            "Q2.बच्चों को __मे मजा  आती है।",
            "Q3. झूल रही है नीचे की __l"

    };
    public static String [] options={
            "दादी", "नानी", "अम्मा","तारे",
            "झूला", "खाने", "सोने","तारे",
            "बादल", "तारे", "धरती","तारे",
    };
    public static String [] correctAnswer={
            "अम्मा","झूला","बादल"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        questionPlace=findViewById(R.id.questionPlace);

        QuizAdapter adapter=new QuizAdapter(question,options,correctAnswer,this);
        questionPlace.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        questionPlace.setLayoutManager(layoutManager);

    }
}