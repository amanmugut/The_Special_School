package com.theErrors.theSpecialSchool;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PodcastActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    String subject[] = {"Hindi", "Mathematics", "English Language", "English Literature", "Environmental Sciences", "General Knowledge"};
    String chapter[];
    String pod;
    String res = "";

    int comps[] = {0, 0, 0, 0, 0, 0};
    Intent i;
    int subj;
    int chap;
    TextView tvName;
    ImageView ivBack;
    MediaPlayer mp;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    CardView cvPlayPause, cvForward, cvBackward;
    ImageView ivAlbum, ivPlayPause;
    String uid = "";
    double startTime = 0;
    double finalTime = 0;

    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1, tx2;

    public static int oneTimeOnly = 0;
    String dyn;

    RelativeLayout rlFooter;
    SpeechRecognizer sr = null;
    ImageView ivMic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast);

        uid = FirebaseAuth.getInstance().getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        cvPlayPause = findViewById(R.id.cvPlayPause);
        cvBackward = findViewById(R.id.cvBackward);
        cvForward = findViewById(R.id.cvForward);
        ivAlbum = findViewById(R.id.ivAlbum);
        ivPlayPause = findViewById(R.id.ivPlayPause);
        tx1 = findViewById(R.id.textView2);
        tx2 = findViewById(R.id.textView3);
        tvName = findViewById(R.id.tvName);
        ivBack = findViewById(R.id.ivBack);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        rlFooter = findViewById(R.id.rlFooter);
        ivMic = findViewById(R.id.ivMic);
        seekbar.setClickable(false);

        sr = SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(new listener());

        i = getIntent();
        subj = i.getIntExtra("Subject", 0);
        chap = i.getIntExtra("Chapter", 0);
        chapInit();
        podInit();

        mmInit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mmInflate(dyn);
            }
        }, 500);


        rlFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                sr.startListening(intent);
            }
        });
        tvName.setText(chapter[chap]);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                finish();
            }
        });

        cvPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying() == false) {
                    Glide.with(getApplicationContext()).load(R.drawable.pause).into(ivPlayPause);
                    //Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                    mp.start();

                    finalTime = mp.getDuration();
                    startTime = mp.getCurrentPosition();

                    if (oneTimeOnly == 0) {
                        seekbar.setMax((int) finalTime);
                        oneTimeOnly = 1;
                    }

                    tx2.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                            finalTime)))
                    );

                    tx1.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                            startTime)))
                    );

                    seekbar.setProgress((int) startTime);
                    myHandler.postDelayed(UpdateSongTime, 100);
                } else {
                    Glide.with(getApplicationContext()).load(R.drawable.play).into(ivPlayPause);
                    mp.pause();
                }
            }
        });

        cvForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mp.seekTo((int) startTime);
                    //Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cvBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    mp.seekTo((int) startTime);
                    //Toast.makeText(getApplicationContext(), "You have Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        //soughted by me
        mp.stop();
    }
    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    public void chapInit() {
        //Toast.makeText(getApplicationContext(), "chap", Toast.LENGTH_SHORT).show();
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
            chapter[3] = "Subtraction";
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
            chapter = new String[10];
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
    }

    public void podInit() {

        if (subj == 0) {
            pod = "C" + (chap + 1);
        }
        if (subj == 1) {
            pod = "C" + (chap + 1);
        }
        if (subj == 2) {
            pod = "C" + (chap + 1) + ".mp3";
        }
        //Toast.makeText(getApplicationContext(), pod, Toast.LENGTH_SHORT).show();
        podPlay();

    }

    public void podPlay() {
        /*databaseReference = firebaseDatabase.getReference().child("Children").child(uid).child("Progress");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                comps[0] = Integer.parseInt(snapshot.child("Hindi").getValue().toString());
                comps[1] = Integer.parseInt(snapshot.child("Mathematics").getValue().toString());
                comps[2] = Integer.parseInt(snapshot.child("EnglishLanguage").getValue().toString());
                comps[3] = Integer.parseInt(snapshot.child("EnglishLiterature").getValue().toString());
                comps[4] = Integer.parseInt(snapshot.child("Environmental").getValue().toString());
                comps[5] = Integer.parseInt(snapshot.child("GeneralKnowledge").getValue().toString());
                Toast.makeText(getApplicationContext(), Arrays.toString(comps), Toast.LENGTH_SHORT).show();
                if (subj == 1 && (chap + 1) > comps[1]) {
                    Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", (chap + 1) + "", comps[2] + "", comps[3] + "", comps[4] + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Progress Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if (subj == 3 && (chap + 1) > comps[3]) {
                    Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", comps[1] + "", comps[2] + "", (chap + 1) + "", comps[4] + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Progress Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if (subj == 4 && (chap + 1) > comps[4]) {
                    Toast.makeText(getApplicationContext(), "Runs", Toast.LENGTH_SHORT).show();
                    ProgressData pd = new ProgressData(comps[0] + "", comps[1] + "", comps[2] + "", comps[3] + "", (chap + 1) + "", comps[5] + "");
                    databaseReference.setValue(pd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Progress Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        */

        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        firebaseStorage = FirebaseStorage.getInstance();
        if (subj == 0) {
            storageReference = firebaseStorage.getReference("Podcast").child("Hindi").child(pod);
        }
        else if (subj == 1) {
            storageReference = firebaseStorage.getReference("Podcast").child("Maths").child(pod);
        } else if (subj == 2) {
            storageReference = firebaseStorage.getReference("Podcast").child("English").child(pod);
        } else {
            Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
        }

        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                final String url = uri.toString();
                try {
                    mp.setDataSource(url);
                    mp.setOnPreparedListener(PodcastActivity.this);
                    mp.prepareAsync();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finalTime = mp.getDuration();
                            startTime = mp.getCurrentPosition();
                            seekbar.setMax((int) finalTime);
                            seekbar.setProgress((int) startTime);
                            myHandler.postDelayed(UpdateSongTime, 100);
                        }
                    }, 2000);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getApplicationContext(), "Failed" + e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mp.getCurrentPosition();
            finalTime = mp.getDuration();
            tx1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            tx2.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime)))
            );
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    public void mmInit() {
        if (subj == 0) {
            dyn = "MMD" + (chap + 1) + ".gif";
        }
        if (subj == 1) {
            dyn = "M" + (chap + 1) + ".gif";
        }
        if (subj == 2) {
            dyn = "E" + (chap + 1) + ".gif";
        }
        //stat = "MMS" + (chap + 1) + ".png";

        //mmInflate(stat);
    }

    public void mmInflate(String a) {
        if (subj == 0) {
            storageReference = firebaseStorage.getReference().child("GIF").child("hindi").child(a);
        }
        else if (subj == 1) {
            storageReference = firebaseStorage.getReference().child("GIF").child("maths").child(a);
        }
        else if (subj == 2) {
            storageReference = firebaseStorage.getReference().child("GIF").child("english").child(a);
        }
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // ivMindMap.setImageURI(uri);
                Glide.with(PodcastActivity.this).load(uri).into(ivAlbum);
            }
        });
    }

    class listener implements RecognitionListener {
        public void onReadyForSpeech(Bundle params) {
            ivMic.setImageResource(R.drawable.ic_mic_on);
            Toast.makeText(PodcastActivity.this, "Listening", Toast.LENGTH_SHORT).show();
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
            } else {
                Toast.makeText(PodcastActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
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

}