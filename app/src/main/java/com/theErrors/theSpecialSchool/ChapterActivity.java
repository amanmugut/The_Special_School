package com.theErrors.theSpecialSchool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChapterActivity extends AppCompatActivity {

    public static final Integer RecordAudioRequestCode = 1;
    String res = "";
    SpeechRecognizer sr = null;
    RelativeLayout rlFooter, rlSpeech;
    ImageView ivMic;
    TextView tvSubject;
    RecyclerView rvChapter;
    ImageView ivBack;
    CircleImageView civUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    Intent i;
    int subj;
    int comps = 0;
    int chapCount = 0;
    String uid = "";
    String chapter[];
    boolean cmp[];
    int img[];
    String subject[] = {"Hindi", "Mathematics", "English Language", "English Literature", "Environmental Sciences", "General Knowledge"};

    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        i = getIntent();

        comps = i.getIntExtra("Complete", 0);
        //Toast.makeText(getApplicationContext(), comps + "", Toast.LENGTH_SHORT).show();
        uid = FirebaseAuth.getInstance().getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        subj = i.getIntExtra("Subject", 0);

        sr = SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(new listener());

        rlSpeech = findViewById(R.id.rlSpeech);
        rlFooter = findViewById(R.id.rlFooter);
        ivMic = findViewById(R.id.ivMic);
        ivBack = findViewById(R.id.ivBack);
        tvSubject = findViewById(R.id.tvSubject);
        rvChapter = findViewById(R.id.rvChapter);
        civUser = findViewById(R.id.civUser);

        String uid = FirebaseAuth.getInstance().getUid();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference().child("Children").child(uid).child(uid);
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(ChapterActivity.this).load(uri).into(civUser);
            }
        });

        civUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChapterActivity.this, UserInfoActivity.class));
            }
        });

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


        tvSubject.setText(subject[i.getIntExtra("Subject", 0)]);
        if (i.getIntExtra("Subject", 0) == 0) {
            chapter = new String[19];
            img = new int[19];
            cmp = new boolean[19];
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

            img[0] = R.mipmap.h1;
            img[1] = R.mipmap.h2;
            img[2] = R.mipmap.h3;
            img[3] = R.mipmap.h4;
            img[4] = R.mipmap.h5;
            img[5] = R.mipmap.h6;
            img[6] = R.mipmap.h7;
            img[7] = R.mipmap.h8;
            img[8] = R.mipmap.h9;
            img[9] = R.mipmap.h10;
            img[10] = R.mipmap.h11;
            img[11] = R.mipmap.h12;
            img[12] = R.mipmap.h13;
            img[13] = R.mipmap.h14;
            img[14] = R.mipmap.h15;
            img[15] = R.mipmap.h16;
            img[16] = R.mipmap.h17;
            img[17] = R.mipmap.h18;
            img[18] = R.mipmap.h19;

            for (int i = 0; i < 19; i++) {
                if (i < comps)
                    cmp[i] = true;
                else
                    cmp[i] = false;
            }
        }
        if (i.getIntExtra("Subject", 0) == 1) {
            chapter = new String[13];
            img = new int[13];
            cmp = new boolean[13];
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
            img[0] = R.drawable.m40;
            img[1] = R.drawable.m41;
            img[2] = R.drawable.m42;
            img[3] = R.drawable.m43;
            img[4] = R.drawable.m44;
            img[5] = R.drawable.m45;
            img[6] = R.drawable.m46;
            img[7] = R.drawable.m47;
            img[8] = R.drawable.m48;
            img[9] = R.drawable.m49;
            img[10] = R.drawable.m50;
            img[11] = R.drawable.m52;

            for (int i = 0; i < 13; i++) {
                if (i < comps)
                    cmp[i] = true;
                else
                    cmp[i] = false;
            }
        }
        if (i.getIntExtra("Subject", 0) == 2) {
            img = new int[10];
            chapter = new String[10];
            cmp = new boolean[10];
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
            img[0] = R.drawable.elit1;
            img[1] = R.drawable.elit2;
            img[2] = R.drawable.elit3;
            img[3] = R.drawable.elit4;
            img[4] = R.drawable.elit5;
            img[5] = R.drawable.elit6;
            img[6] = R.drawable.elit7;
            img[7] = R.drawable.elit8;
            img[8] = R.drawable.elit9;
            img[9] = R.drawable.elit10;

            for (int i = 0; i < 10; i++) {
                if (i < comps)
                    cmp[i] = true;
                else
                    cmp[i] = false;
            }
        }
        if (i.getIntExtra("Subject", 0) == 4) {
            img = new int[24];
            chapter = new String[24];
            cmp = new boolean[24];
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
            img[0] = R.mipmap.es1;
            img[1] = R.mipmap.es2;
            img[2] = R.mipmap.es3;
            img[3] = R.mipmap.es4;
            img[4] = R.mipmap.es5;
            img[5] = R.mipmap.es6;
            img[6] = R.mipmap.es7;
            img[7] = R.mipmap.es8;
            img[8] = R.mipmap.es9;
            img[9] = R.mipmap.es10;
            img[10] = R.mipmap.es11;
            img[11] = R.mipmap.es12;
            img[12] = R.mipmap.es13;
            img[13] = R.mipmap.es14;
            img[14] = R.mipmap.es15;
            img[15] = R.mipmap.es16;
            img[16] = R.mipmap.es17;
            img[17] = R.mipmap.es18;
            img[18] = R.mipmap.es19;
            img[19] = R.mipmap.es20;
            img[20] = R.mipmap.es20;
            img[21] = R.mipmap.es20;
            img[22] = R.mipmap.es20;
            img[23] = R.mipmap.es20;
            for (int i = 0; i < 24; i++) {
                if (i < comps)
                    cmp[i] = true;
                else
                    cmp[i] = false;
            }
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (t1 != null) {
                    t1.stop();
                    t1.shutdown();
                }
                finish();
            }
        });

        rlSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = "Chapters are: " + Arrays.toString(chapter);
                //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        ChapterAdapter chapterAdapter = new ChapterAdapter();
        rvChapter.setLayoutManager(new LinearLayoutManager(this));
        rvChapter.setAdapter(chapterAdapter);
        chapterAdapter.notifyDataSetChanged();
    }

    public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_single_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvName.setText(chapter[position]);
            holder.tvChapter.setText("Chapter " + (position + 1));
            Glide.with(getApplicationContext()).load(img[position]).into(holder.ivThumbnail);
            holder.cb.setChecked(cmp[position]);
            holder.rlChapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(ChapterActivity.this, LearningActivity.class);
                    in.putExtra("Subject", i.getIntExtra("Subject", 0));
                    in.putExtra("Chapter", position);
                    startActivity(in);
                }
            });
        }

        @Override
        public int getItemCount() {
            return chapter.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            AppCompatCheckBox cb;
            TextView tvName, tvChapter;
            ImageView ivThumbnail;
            RelativeLayout rlChapter;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cb = itemView.findViewById(R.id.cb);
                rlChapter = itemView.findViewById(R.id.rlChapter);
                tvChapter = itemView.findViewById(R.id.tvChapter);
                tvName = itemView.findViewById(R.id.tvName);
                ivThumbnail = itemView.findViewById(R.id.ivThumbmnail);
            }
        }
    }

    @Override
    public void onBackPressed() {

    }

    class listener implements RecognitionListener {
        public void onReadyForSpeech(Bundle params) {
            ivMic.setImageResource(R.drawable.ic_mic_on);
            Toast.makeText(ChapterActivity.this, "Listening", Toast.LENGTH_SHORT).show();
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
            //Toast.makeText(ChapterActivity.this, "Ended", Toast.LENGTH_SHORT).show();
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
            if (res.equals("BACK")) {
                finish();
            }
            if (subj == 1) {
                //Toast.makeText(ChapterActivity.this, res, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //tvmic.setText("");
                        boolean flag = false;
                        String math[] = {
                                "Shapes and space",
                                "Numbers from 1 to 9",
                                "Addition",
                                "Subtraction",
                                "Numbers from 10 to 20",
                                "Time",
                                "Measurement",
                                "Numbers from 21 to 50",
                                "Data handling",
                                "Patterns",
                                "Numbers from 51 to 100",
                                "Money",
                                "How many part"};

                        for (int i = 0; i < math.length; i++) {
                            if (math[i].equalsIgnoreCase(res)) {
                                flag = true;
                                Intent in = new Intent(ChapterActivity.this, LearningActivity.class);
                                in.putExtra("Subject", subj);
                                in.putExtra("Chapter", i);
                                startActivity(in);
                            }
                        }
                        if (flag == false) {
                            Toast.makeText(ChapterActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //tvmic.setText("");
                                    ivMic.performClick();
                                }
                            }, 1000);
                        }
                    }
                }, 1000);
            }
            else if (subj == 0) {
                //Toast.makeText(ChapterActivity.this, res, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //tvmic.setText("");
                        boolean flag = false;
                        String hind[] = {"jhula", "aam ki kahani", "patte hi patte"
                                , "pakodi", "rasoighar", "chuho", "bandar aur gilhari",
                                "patang", "gend balla", "bandar gaya khet mai bhag", "ek budhiya", "mai bhi"
                                , "lalu aur peelu", "chakai ke chakdum", "chhoti ka kamaal", "chaar chane", "bhagdad", "haleem chala chand per",
                        "haathi chilam challam"};

                        for (int i = 0; i < hind.length; i++) {
                            if (hind[i].equalsIgnoreCase(res)) {
                                flag = true;
                                Intent in = new Intent(ChapterActivity.this, LearningActivity.class);
                                in.putExtra("Subject", subj);
                                in.putExtra("Chapter", i);
                                startActivity(in);
                            }
                        }
                        if (flag == false) {
                            Toast.makeText(ChapterActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //tvmic.setText("");
                                    ivMic.performClick();
                                }
                            }, 1000);
                        }
                    }
                }, 1000);
            }
            else if (subj == 2) {
                //Toast.makeText(ChapterActivity.this, res, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //tvmic.setText("");
                        boolean flag = false;
                        String elit[] = {"A Happy Child Three Little Pigs", "After A Bath The Bubble The Straw And The Shoe",
                                "One Little Kitten Lalu And Peelu", "Once I Saw A Bird Mittu And The Yellow Mango","Merry-Go-Round Circle",
                        "If I Were An Apple Our Tree","A Kite Sundari","A Little Trutle The Tiger And The Mosquito",
                                "Clouds Anandi's Rainbow","Flying-Man The Tailor And His Friend"};
                        for (int i = 0; i < elit.length; i++) {
                            if (elit[i].equalsIgnoreCase(res)) {
                                flag = true;
                                Intent in = new Intent(ChapterActivity.this, LearningActivity.class);
                                in.putExtra("Subject", subj);
                                in.putExtra("Chapter", i);
                                startActivity(in);
                            }
                        }
                        if (flag == false) {
                            Toast.makeText(ChapterActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //tvmic.setText("");
                                    ivMic.performClick();
                                }
                            }, 1000);
                        }
                    }
                }, 1000);
            } else {
                //Toast.makeText(ChapterActivity.this, res, Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //tvmic.setText("");
                        boolean flag = false;
                        String elit[] = {"POONAM DAY OUT", "THE MAGIC GARDEN", "BIRD TALK"
                                , "NINA AND THE BABY SPARROWS", "LITTLE BY LITTLE", "THE ENORMOUS TURNIP", "SEA SONG",
                                "A LITTLE FISH STORY", "THE BALLOON MAN", "THE YELLOW BUTTERFLY", "TRAINS", "THE STORY OF THE ROAD"
                                , "PUPPY AND I", "LITTLE TIGER BIG TIGER", "WHAT'S IN THE MAILBOX", "MY SILLY SISTER",
                                "DON'T TELL", "HE IS  MY BROTHER", "HOW CREATURES MOVE", "THE SHIP OF THE DESERT"};
                        for (int i = 0; i < elit.length; i++) {
                            if (elit[i].equals(res)) {
                                flag = true;
                                Intent in = new Intent(ChapterActivity.this, LearningActivity.class);
                                in.putExtra("Subject", subj);
                                in.putExtra("Chapter", i);
                                startActivity(in);
                            }
                        }
                        if (flag == false) {
                            Toast.makeText(ChapterActivity.this, "Try Again " + res, Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //tvmic.setText("");
                                    ivMic.performClick();
                                }
                            }, 1000);
                        }
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