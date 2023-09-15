package com.theErrors.theSpecialSchool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class LearningActivity extends AppCompatActivity {

    static boolean flag = false;
    public static final Integer RecordAudioRequestCode = 1;
    String res = "";
    SpeechRecognizer sr = null;
    String subject[] = {"Hindi", "Mathematics", "English Language", "English Literature", "Environmental Sciences", "General Knowledge"};
    String chapter[];
    RelativeLayout rlMindmaps, rlPodcasts, rlQuiz, rlGames, rlFooter, rlSpeech;
    FirebaseAuth mAuth;
    TextView tvChapter;
    ImageView ivBack, ivMic;
    CircleImageView civUser;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    String uid = "";


    int subj, chap;

    int comps[] = {0, 0, 0, 0, 0, 0};

    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        uid = FirebaseAuth.getInstance().getUid();
        //Toast.makeText(getApplicationContext(), uid, Toast.LENGTH_SHORT).show();
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        sr = SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(new listener());

        rlSpeech = findViewById(R.id.rlSpeech);
        rlFooter = findViewById(R.id.rlFooter);
        ivMic = findViewById(R.id.ivMic);
        civUser = findViewById(R.id.civUser);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference().child("Children").child(uid).child(uid);
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(LearningActivity.this).load(uri).into(civUser);
            }
        });

        civUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LearningActivity.this, UserInfoActivity.class));
            }
        });

        Intent i = getIntent();
        subj = i.getIntExtra("Subject", 0);
        chap = i.getIntExtra("Chapter", 0);
        //Toast.makeText(getApplicationContext(), subj + " " + chap, Toast.LENGTH_SHORT).show();
        if (subj == 0) {
            chapter = new String[19];
            chapter[0] = "झूला";
            chapter[1] = "आम की कहानी";
            chapter[2] = "पत्ते ही पत्ते";
            chapter[3] = "पकौड़ी";
            chapter[4] = "रसोईघर";
            chapter[5] = "चूहो";
            chapter[6] = "बंदर और गिलहरी ";
            chapter[7] = "पतंग";
            chapter[8] = "गेंद-बल्ला";
            chapter[9] = "बंदर गया खेत में भाग";
            chapter[10] = "एक बुढ़िया";
            chapter[11] = "मैं भी...";
            chapter[12] = "लालू और पीलू";
            chapter[13] = "चकई के चकदुम";
            chapter[14] = "छोटी का कमाल";
            chapter[15] = "चार चने ";
            chapter[16] = "भगदड़ ";
            chapter[17] = "हलीम चला चाँद पर";
            chapter[18] = "हाथी चल्लम चल्लम";
        }
        if (subj == 1) {
            chapter = new String[13];
            chapter[0] = "Shapes and space";
            chapter[1] = "Numbers from one to nine";
            chapter[2] = "Addition";
            chapter[3] = "Substraction";
            chapter[4] = "Numbers from 10 to 20";
            chapter[5] = "Time";
            chapter[6] = "Measurement";
            chapter[7] = "Numbers from 21 to 50";
            chapter[8] = "Data handling";
            chapter[9] = "Patterns";
            chapter[10] = "Numbers from 51 to 100";
            chapter[11] = "Money";
            chapter[12] = "How many part";
        }
        if (subj == 2) {
            chapter = new String[20];
            chapter[0] = "A Happy Child Three Little Pigs";
            chapter[1] = "After A Bath The Bubble The Straw And The Shoe";
            chapter[2] = "One Little Kitten Lalu And Peelu";
            chapter[3] = "Once I Saw A Bird Mittu And The Yellow Mango";
            chapter[4] = "Merry-Go-Round Circle";
            chapter[5] = "If I Were An Apple Our Tree";
            chapter[6] = "A Kite Sundari";
            chapter[7] = "A Little Trutle The Tiger And The Mosquito";
            chapter[8] = "Clouds Anandi's Rainbow";
            chapter[9] = "Flying-Man The Tailor And His Friend";
       }
        if (subj == 4) {
            chapter = new String[24];
            chapter[0] = "Poonam's Day Out";
            chapter[1] = "The Plant Fairy";
            chapter[2] = "Water O Water";
            chapter[3] = "Our First School";
            chapter[4] = "Chhotu's House";
            chapter[5] = "Foods We Eat";
            chapter[6] = "Saying Without Speaking";
            chapter[7] = "Flying High";
            chapter[8] = "It's Raining";
            chapter[9] = "What Is Cooking";
            chapter[10] = "From Here To There";
            chapter[11] = "Work We Do";
            chapter[12] = "Sharing Our Feeling";
            chapter[13] = "The Story Of Food";
            chapter[14] = "Making Pots";
            chapter[15] = "Games We Play";
            chapter[16] = "Here Comes a Letter";
            chapter[17] = "A House Like This!";
            chapter[18] = "Our Friends - Animals";
            chapter[19] = "Drop By Drop";
            chapter[20] = "Families Can Be Different";
            chapter[21] = "Left - Right";
            chapter[22] = "A Beautiful Cloth";
            chapter[23] = "Web Of Life";
        }

        mAuth = FirebaseAuth.getInstance();

        ivBack = findViewById(R.id.ivBack);
        tvChapter = findViewById(R.id.tvChapter);
        rlGames = findViewById(R.id.rlGames);
        rlMindmaps = findViewById(R.id.rlMindmaps);
        rlPodcasts = findViewById(R.id.rlPodcasts);
        rlQuiz = findViewById(R.id.rlQuiz);

        tvChapter.setText(chapter[i.getIntExtra("Chapter", 0)]);

        rlFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                sr.startListening(intent);
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        rlGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(subj == 0 && chap == 0)
                {
                    startActivity(new Intent(LearningActivity.this, MatchHindiChapOne.class));
                }
                else if(subj == 0 && chap == 1)
                {
                    startActivity(new Intent(LearningActivity.this, MatchHindiChapTwo.class));
                }
                else if(subj == 0 && chap == 2)
                {
                    startActivity(new Intent(LearningActivity.this, MatchHindiChapThree.class));
                }
                else if(subj == 0 && chap == 3)
                {
                    startActivity(new Intent(LearningActivity.this, MatchHindiChapFour.class));
                }
                else if(subj == 0 && chap == 4)
                {
                    startActivity(new Intent(LearningActivity.this, MatchHindiChapFive.class));
                }
                else if(subj == 0 && chap == 5)
                {
                    startActivity(new Intent(LearningActivity.this, GameHindiChapSix.class));
                }
                else if(subj == 0 && chap == 6)
                {
                    startActivity(new Intent(LearningActivity.this, GameHindiChapSeven.class));
                }
                else if(subj == 0 && chap == 7)
                {
                    startActivity(new Intent(LearningActivity.this, GameHindiChapEight.class));
                }
                else if(subj == 0 && chap == 8)
                {
                    startActivity(new Intent(LearningActivity.this, GameHindiChapNine.class));
                }
                else if(subj == 0 && chap == 10)
                {
                    startActivity(new Intent(LearningActivity.this, GameHindiChapEleven.class));
                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Under Development", Toast.LENGTH_SHORT).show();
//                }
            }
        });


        rlPodcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent in = new Intent(LearningActivity.this, PodcastActivity.class);
                    in.putExtra("Subject", subj);
                    in.putExtra("Chapter", chap);
                    startActivity(in);
            }
        });

        rlQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Maths
                if (subj == 1 && chap == 0)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER2MATHSONE.class));
                }
                else if (subj == 1 && chap == 1)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER6MATHONE.class));
                }
                else if (subj == 1 && chap == 2)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER11MATHONE.class));
                }
                else if (subj == 1 && chap == 3)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTERFOURMATHSONE.class));
                }
                else if (subj == 1 && chap == 4)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTERFIVEMATHONE.class));
                }
                else if (subj == 1 && chap == 5)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER6MATHONE.class));
                }
                else if (subj == 1 && chap == 6)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER7MATHONE.class));
                }
                else if (subj == 1 && chap == 7)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER8MATHONE.class));
                }
                else if (subj == 1 && chap == 8)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER9MATHONE.class));
                }
                else if (subj == 1 && chap == 9)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER10MATHONE.class));
                }
                else if (subj == 1 && chap == 10)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER11MATHONE.class));
                }
                else if (subj == 1 && chap == 11)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER12MATHONE.class));
                }
                else if (subj == 1 && chap == 12)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER13MATHONE.class));
                }
                else if (subj == 0 && chap == 0)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER2HINDIONE.class));
                }
                else if (subj == 0 && chap == 1)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER2HINDIONE.class));
                }
                else if (subj == 0 && chap == 2)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTERTHREEHINDIONE.class));
                }
                else if (subj == 0 && chap == 3)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTERFOURHINDIONE.class));
                }
                else if (subj == 0 && chap == 4)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTERFIVEHINDIONE.class));
                }
                else if (subj == 0 && chap == 5)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER6HINDIONE.class));
                }
                else if (subj == 0 && chap == 6)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER7HINDIONE.class));
                }
                else if (subj == 0 && chap == 7)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER8HINDIONE.class));
                }
                else if (subj == 0 && chap == 8)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER9HINDIONE.class));
                }
                else if (subj == 0 && chap == 9)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER10HINDIONE.class));
                }
                else if (subj == 0 && chap == 10)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER11HINDIONE.class));
                }
                else if (subj == 0 && chap == 11)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER12HINDIONE.class));
                }
                else if (subj == 0 && chap == 12)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER13HINDIONE.class));
                }
                else if (subj == 0 && chap == 13)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER14HINDIONE.class));
                }
                else if (subj == 0 && chap == 14)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER15HINDIONE.class));
                }
                else if (subj == 0 && chap == 15)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER16HINDIONE.class));
                }
                else if (subj == 0 && chap == 16)
                {
                    startActivity(new Intent(LearningActivity.this, CHAPTER17HINDIONE.class));
                }

            }
        });
        rlMindmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subj == 0) {
                    Intent in = new Intent(LearningActivity.this, MindMapActivity.class);
                    in.putExtra("Subject", subj);
                    in.putExtra("Chapter", chap);
                    startActivity(in);
                }
                else if (subj == 1) {
                    Intent in = new Intent(LearningActivity.this, MindMapActivity.class);
                    in.putExtra("Subject", subj);
                    in.putExtra("Chapter", chap);
                    startActivity(in);
                }
                else if (subj == 2) {
                    Intent in = new Intent(LearningActivity.this, MindMapActivity.class);
                    in.putExtra("Subject", subj);
                    in.putExtra("Chapter", chap);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(), "Under Development", Toast.LENGTH_SHORT).show();

                }
            }
        });

        rlSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = "How would you like to learn : Mind Maps , Podcasts , Games , Quiz ";
                //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }

    class listener implements RecognitionListener {
        public void onReadyForSpeech(Bundle params) {
            ivMic.setImageResource(R.drawable.ic_mic_on);
            Toast.makeText(LearningActivity.this, "Listening", Toast.LENGTH_SHORT).show();
        }

        public void onBeginningOfSpeech() {
            ivMic.setImageResource(R.drawable.ic_mic_on);
        }

        public void onRmsChanged(float rmsdB) {
        }

        public void onBufferReceived(byte[] buffer) {
        }

        public void onEndOfSpeech() {
            ivMic.setImageResource(R.drawable.ic_mic_off);
            //Toast.makeText(LearningActivity.this, "Ended", Toast.LENGTH_SHORT).show();
            //Log.d(TAG, "onEndofSpeech");
        }

        public void onError(int error) {
        }

        public void onResults(Bundle results) {
            String z = "";
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            for (int i = 0; i < matches.size(); i++) {
                z = z + matches.get(i);
            }
            res = z.toUpperCase();
            //Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            if (res.equals("BACK")) {
                finish();
            } else if (res.equals("PODCAST")) {
                rlPodcasts.performClick();
            } else if (res.equals("MIND MAPS")) {
                rlMindmaps.performClick();
            } else if (res.equals("GAMES")) {
                rlGames.performClick();
            } else if (res.equals("QUIZ")) {
                rlQuiz.performClick();
            } else {
                Toast.makeText(LearningActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivMic.performClick();
                    }
                }, 1000);
            }
        }

        public void onPartialResults(Bundle partialResults) {

            //Log.d(TAG, "onPartialResults");
        }

        public void onEvent(int eventType, Bundle params) {

            //Log.d(TAG, "onEvent " + eventType);
        }
    }


    public void givenQuiz() {
        //flag = false;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Children").child(uid).child("Progress");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                comps[0] = Integer.parseInt(snapshot.child("Hindi").getValue().toString());
                comps[1] = Integer.parseInt(snapshot.child("Mathematics").getValue().toString());
                comps[2] = Integer.parseInt(snapshot.child("EnglishLanguage").getValue().toString());
                comps[3] = Integer.parseInt(snapshot.child("EnglishLiterature").getValue().toString());
                comps[4] = Integer.parseInt(snapshot.child("Environmental").getValue().toString());
                comps[5] = Integer.parseInt(snapshot.child("GeneralKnowledge").getValue().toString());
                //Toast.makeText(getApplicationContext(), Arrays.toString(comps), Toast.LENGTH_SHORT).show();
                if (subj == 1 && (chap + 1) > comps[1]) {
                    //flag = true;
                   // Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", (chap + 1) + "", comps[2] + "", comps[3] + "", comps[4] + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                           // Toast.makeText(getApplicationContext(), "Progress Updated" + flag, Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(LearningActivity.this, QuizActivity.class);
                            in.putExtra("Subject", subj);
                            in.putExtra("Chapter", chap);
                            startActivity(in);
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Already Given", Toast.LENGTH_SHORT).show();
                }
                if (subj == 2 && (chap + 1) > comps[3]) {
                    //flag = true;
                   // Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", comps[1] + "", comps[2] + "", (chap + 1) + "", comps[4] + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                           // Toast.makeText(getApplicationContext(), "Progress Updated", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(LearningActivity.this, QuizActivity.class);
                            in.putExtra("Subject", subj);
                            in.putExtra("Chapter", chap);
                            startActivity(in);
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Already Given", Toast.LENGTH_SHORT).show();
                }
                if (subj == 4 && (chap + 1) > comps[4]) {
                    //flag = true;
                    //Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", comps[1] + "", comps[2] + "", comps[3] + "", (chap + 1) + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            //Toast.makeText(getApplicationContext(), "Progress Updated", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(LearningActivity.this, QuizActivity.class);
                            in.putExtra("Subject", subj);
                            in.putExtra("Chapter", chap);
                            startActivity(in);
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Already Given", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //Toast.makeText(getApplicationContext(), flag + "", Toast.LENGTH_SHORT).show();
    }
}


