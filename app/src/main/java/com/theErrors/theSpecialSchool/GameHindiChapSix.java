package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GameHindiChapSix extends AppCompatActivity {

    Button submit;
    EditText answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hindi_chap_six);
        submit=findViewById(R.id.submit_six);
        answer=findViewById(R.id.answer_six);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answer.getText().toString().equals("")) {
                    Toast.makeText(GameHindiChapSix.this, "Level Completed Thank You  ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LearningActivity.class));
                    finish();
                }else{
                    Toast.makeText(GameHindiChapSix.this, "Write You Answer First ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}