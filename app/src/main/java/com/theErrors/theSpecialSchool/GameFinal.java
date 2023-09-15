package com.theErrors.theSpecialSchool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class GameFinal extends AppCompatActivity {
    CircleImageView hut,igloo,flat,bunglow;
    ImageView Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_final);

        init();
        initiate();
    }
    public void init()
    {
        Back = findViewById(R.id.Back);
        hut = findViewById(R.id.hut);
        igloo = findViewById(R.id.igloo);
        flat = findViewById(R.id.flat);
        bunglow = findViewById(R.id.bunglow);
    }
    public void initiate()
    {
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LearningActivity.class));
            }
        });

        hut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams = hut.getLayoutParams();
                layoutParams.width = 500;
                layoutParams.height = 500;
                hut.setLayoutParams(layoutParams);
                hut.setBorderWidth(40);
                hut.setBorderColor(Color.GREEN);

                igloo.setVisibility(View.INVISIBLE);
                flat.setVisibility(View.INVISIBLE);
                bunglow.setVisibility(View.INVISIBLE);
            }
        });

        igloo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams = igloo.getLayoutParams();
                layoutParams.width = 500;
                layoutParams.height = 500;
                igloo.setLayoutParams(layoutParams);
                igloo.setBorderWidth(40);
                igloo.setBorderColor(Color.GREEN);

                hut.setVisibility(View.INVISIBLE);
                flat.setVisibility(View.INVISIBLE);
                bunglow.setVisibility(View.INVISIBLE);
            }
        });

        flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams = flat.getLayoutParams();
                layoutParams.width = 500;
                layoutParams.height = 500;
                flat.setLayoutParams(layoutParams);
                flat.setBorderWidth(40);
                flat.setBorderColor(Color.GREEN);

                hut.setVisibility(View.INVISIBLE);
                igloo.setVisibility(View.INVISIBLE);
                bunglow.setVisibility(View.INVISIBLE);
            }
        });

        bunglow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams = bunglow.getLayoutParams();
                layoutParams.width = 500;
                layoutParams.height = 500;
                bunglow.setLayoutParams(layoutParams);
                bunglow.setBorderWidth(40);
                bunglow.setBorderColor(Color.GREEN);

                hut.setVisibility(View.INVISIBLE);
                igloo.setVisibility(View.INVISIBLE);
                flat.setVisibility(View.INVISIBLE);
            }
        });
    }
}