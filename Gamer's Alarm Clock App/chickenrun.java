package com.example.poorvanene.wakeywakey;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.widget.Toast;

public class chickenrun extends AppCompatActivity {
    static MediaPlayer p;
    java.util.Timer timer = new java.util.Timer();
    android.os.Handler handler = new android.os.Handler();
    ImageView chicken;
    ImageView car;
    ImageView puppy;
    int height;
    boolean puppymove;
    boolean carmove;
    int randptime=7;
    int randctime=4;
    int width;
    float chickenX;
    float chickenY;
    int time =0;
    float carX;
    float carY;
    float puppyX;
    float puppyY;
    boolean move = true;
    int pc=0;
    int cc=0;
    View fullView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chickenrun);
        //add images to screen xml

        chicken = (ImageView) findViewById(R.id.chicken);
        puppy = (ImageView) findViewById(R.id.puppy);
        car = (ImageView) findViewById(R.id.police);



        WindowManager w = getWindowManager();
        Display display = w.getDefaultDisplay();
        android.graphics.Point s = new android.graphics.Point();
        display.getSize(s);

        height = s.y;
        width = s.x;

        chicken.setX(width / 2);
        chickenY=height;
        chicken.setY(height );
//        puppy.setX(-80.0f);
//        puppy.setY(-80.0f);
//        car.setX(-80.0f);
//        car.setY(-80.0f);
        puppy.setX(50.0f);
        puppy.setY(50.0f);
        car.setX(50.0f);
        car.setY(50.0f);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        if(chickenY<=0){
                            chickenY=height;
                            chicken.setY(height);
                        }
                     if(move==true)
               {
                    chickenY-=5;
               }
               if((time%15)==randptime){
                          puppymove=true;

               }
               if((time%15)==randctime){
                            carmove=true;

                        }
                chicken.setY(chickenY);
               if(istouching(chicken))
                    {
                        time=0;
                        android.widget.Toast.makeText(getApplicationContext(), "Wooop you killed chick, try again!!!",
                                android.widget.Toast.LENGTH_SHORT).show();
                    }
                    time++;
                    if(time==1500){
                        shutOffAlarm();
                    }
                    if(puppymove==true){
                        if(pc ==0)
                        {
                            puppyY=(int) (Math.random()*height);
                        puppy.setY(puppyY);
                        }
                        puppyX-=5;
                        puppy.setX(puppyX);
                        pc++;
                        if(puppyX<=0){
                            pc=0;
                            puppymove=false;
                            puppyX=width;
                            puppy.setX(puppyX);
                            randptime= (int) (Math.random()*11)+3;
                        }

                    }
                        if(carmove==true){
                            if(cc ==0)
                            {
                                carY=(int) (Math.random()*height);
                                car.setY(carY);
                            }
                            carX+=5;
                            car.setX(carX);
                            cc++;
                            if(carX>=width){
                                cc=0;
                                carmove=false;
                                carX=0;
                                car.setX(carX);
                                randctime= (int) (Math.random()*11)+3;
                            }
                        }
                    }
                });
            }

        }, 0, 10);

}

    private void shutOffAlarm() {
        //turn off ring alarm sound
        android.widget.Toast.makeText(getApplicationContext(), "Okay, I'll shut up now!",
                Toast.LENGTH_LONG).show();
        timer.cancel();
        Waiting.pause();

    }

    private boolean istouching(ImageView chicken) {
        if(puppy.getY()-80<=chicken.getY()
                && chicken.getY()<=puppy.getY()+80
                && puppy.getX()-80<=chicken.getX()
                && chicken.getX()<=puppy.getX()+80)
            return true;
        if(car.getY()-80<=chicken.getY()
                && chicken.getY()<=car.getY()+80
                && car.getX()-80<=chicken.getX()
                && chicken.getX()<=car.getX()+80 )
            return true;


        return false;


    }





    public void move(View view) {
            move = !move;
    }








    }











