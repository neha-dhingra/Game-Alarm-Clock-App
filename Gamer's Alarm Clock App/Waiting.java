package com.example.poorvanene.wakeywakey;

//import android.content.Intent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import android.text.format.Time;
import android.speech.tts.TextToSpeech;

import java.io.IOException;

public class Waiting extends AppCompatActivity {

    TextToSpeech tts;
   static String filename = "friday.mp3";
   static MediaPlayer p;

    android.media.MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        android.content.Intent intent = getIntent();
        String alarmtime = intent.getStringExtra("alarmtime");

        String print = alarmtime;
        android.widget.TextView ti = ( android.widget.TextView) findViewById(R.id.helllo);

        ti.setText(print);
        System.out.println("*****"+print);

        Time currentTime = new Time();
        currentTime.setToNow();
        long nowTime = (currentTime.hour * 60) + currentTime.minute;
        long alarmTimez = (Integer.parseInt(print.substring(0, 2)) * 60) + Integer.parseInt(print.substring(3));
        long millisinFuture = (alarmTimez - nowTime) * 60000;

        new android.os.CountDownTimer(millisinFuture, 6000) {

            public void onTick(long millisUntilFinished) {
                System.out.print("It's been a sec");
            }

            public void onFinish() {
                alarmGoOff();
            }

        }.start();


//        if (currentTime.hour == Integer.parseInt(print.substring(0,2)) &&
//        currentTime.minute == Integer.parseInt(print.substring(3)))
//        {
//            alarmGoOff();
//
//        }


    }

    private void alarmGoOff() {

        tts=new TextToSpeech(Waiting.this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub

                    int result=tts.setLanguage(java.util.Locale.US);
                        String text = "Wakey Wakey sunshine! Get up and be your beautiful, awesome self! The world's waiting for your gorgeous eyes Poorva!";
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        };


    });



//        mediaPlayer = android.media.MediaPlayer.create(Waiting.class, resources.hi);
//
//       mediaPlayer.start();
          p = new MediaPlayer();
        try {
            android.content.res.AssetFileDescriptor afd = this.getApplicationContext().getAssets().openFd(filename);
            p.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            p.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.start();
        p.setLooping(true);
            android.content.Intent myIntent = new android.content.Intent (Waiting.this, Maths.class);

       Waiting.this.startActivity(myIntent);
         myIntent.putExtra("name",filename);



    }

    public static void pause()
    {
        p.stop();
    }


}

