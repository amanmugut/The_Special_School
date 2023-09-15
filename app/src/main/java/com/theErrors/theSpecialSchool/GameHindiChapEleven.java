package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class GameHindiChapEleven extends AppCompatActivity {

    GridView aman;
    Button submit;
    EditText pagdi,topiya;
    int[] arr = {R.drawable.one_game,R.drawable.two_game,R.drawable.three_game,R.drawable.four_game,R.drawable.five_game,R.drawable.six_game};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hindi_chap_eleven);
        aman = findViewById(R.id.aman);
        HindiChapElevenAdapter adaptorClass = new HindiChapElevenAdapter(GameHindiChapEleven.this,arr);
        aman.setAdapter(adaptorClass);

        submit = findViewById(R.id.submit);
        pagdi = findViewById(R.id.pagdi);
        topiya = findViewById(R.id.topiya);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int topi = Integer.parseInt(topiya.getText().toString());
                    int pag = Integer.parseInt(pagdi.getText().toString());

                    if(topi == 2 && pag == 4)
                    {
                        Toast.makeText(GameHindiChapEleven.this, "Correct Answer !!!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LearningActivity.class));
                    }
                    else
                    {
                        Toast.makeText(GameHindiChapEleven.this, "Try Again", Toast.LENGTH_SHORT).show();
                        topiya.setText("");
                        pagdi.setText("");
                        topiya.requestFocus();
                    }
                }
                catch (Exception e)
                {

                }
            }
        });
    }
}