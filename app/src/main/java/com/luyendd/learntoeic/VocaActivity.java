package com.luyendd.learntoeic;

import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.luyendd.learntoeic.obj.Voca;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class VocaActivity extends AppCompatActivity implements View.OnClickListener {


    TextToSpeech mTTS;
    String TAG = "VocaActivity";
    ImageButton imageButton;
    boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voca);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Contract");

        findViewById(R.id.imagebuttonSpeak1).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak2).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak3).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak4).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak5).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak6).setOnClickListener(this);
        findViewById(R.id.imagebuttonSpeak7).setOnClickListener(this);

        imageButton = findViewById(R.id.imagebuttonFavorite1);
        imageButton.setOnClickListener(this);

        mTTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    int ttsLang = mTTS.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e(TAG, "The Language is not supported!");
                    } else {
                        Log.i(TAG, "Language Supported.");

                    }
                    Log.i(TAG, "Initialization success.");
                }
            }
        });
    }

    private void speak(String words){
        mTTS.speak(words, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imagebuttonFavorite1:
                isFavorite = !isFavorite;
                if(isFavorite)  imageButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_favorite));
                else imageButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_not_favorite));
                break;

            case R.id.imagebuttonSpeak1:
                speak("abide by");
                break;

            case R.id.imagebuttonSpeak2:
                speak("agreement");
                break;

            case R.id.imagebuttonSpeak3:
                speak("assurance");
                break;

            case R.id.imagebuttonSpeak4:
                speak("cancellation");
                break;

            case R.id.imagebuttonSpeak5:
                speak("determine");
                break;

            case R.id.imagebuttonSpeak6:
                speak("engage");
                break;

            case R.id.imagebuttonSpeak7:
                speak("establish");
                break;


        }
    }
}
