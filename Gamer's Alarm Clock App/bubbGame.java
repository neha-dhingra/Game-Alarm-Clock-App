package com.example.poorvanene.wakeywakey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubbGame extends AppCompatActivity {

  List<IB> bArr = new  ArrayList<IB>();
    List<Integer> nArr = new  ArrayList<Integer>();
    int [] numordered = new  int[12];
    int prevButtonIndex =-1;
    Board board = new Board();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubb_game);

        for(int k=0; k<12; k++){

            IB b = new IB();
            bArr.add(b);
        }

        bArr.get(0).setImageButton((ImageButton) findViewById(R.id.imageButton0));
        bArr.get(0).settv((android.widget.TextView) findViewById(R.id.textView0));

        bArr.get(1).setImageButton((ImageButton) findViewById(R.id.imageButton1));
        bArr.get(1).settv((android.widget.TextView) findViewById(R.id.textView1));

        bArr.get(2).setImageButton((ImageButton) findViewById(R.id.imageButton2));
        bArr.get(2).settv((android.widget.TextView) findViewById(R.id.textView2));

        bArr.get(3).setImageButton((ImageButton) findViewById(R.id.imageButton3));
        bArr.get(3).settv((android.widget.TextView) findViewById(R.id.textView3));

        bArr.get(4).setImageButton((ImageButton) findViewById(R.id.imageButton4));
        bArr.get(4).settv((android.widget.TextView) findViewById(R.id.textView4));

        bArr.get(5).setImageButton((ImageButton) findViewById(R.id.imageButton5));
        bArr.get(5).settv((android.widget.TextView) findViewById(R.id.textView5));

        bArr.get(6).setImageButton((ImageButton) findViewById(R.id.imageButton6));
        bArr.get(6).settv((android.widget.TextView) findViewById(R.id.textView6));

        bArr.get(7).setImageButton((ImageButton) findViewById(R.id.imageButton7));
        bArr.get(7).settv((android.widget.TextView) findViewById(R.id.textView7));

        bArr.get(8).setImageButton((ImageButton) findViewById(R.id.imageButton8));
        bArr.get(8).settv((android.widget.TextView) findViewById(R.id.textView8));

        bArr.get(9).setImageButton((ImageButton) findViewById(R.id.imageButton9));
        bArr.get(9).settv((android.widget.TextView) findViewById(R.id.textView9));

        bArr.get(10).setImageButton((ImageButton) findViewById(R.id.imageButton10));
        bArr.get(10).settv((android.widget.TextView) findViewById(R.id.textView10));

        bArr.get(11).setImageButton((ImageButton) findViewById(R.id.imageButton11));
        bArr.get(11).settv((android.widget.TextView) findViewById(R.id.textView11));




    for(int i=0; i<12;i++){

        int num = (int) (Math.random()*100);
        nArr.add(num);
        bArr.get(i).setNum(num);
        bArr.get(i).setText(num);
        System.out.println("!!!!!!");
            System.out.println(bArr.get(i).getNum());

    }


        for(int j=0; j<12;j++){
        numordered[j] = nArr.get(j);
        }

        Arrays.sort(numordered);

    }




    public void checkButton(View view) {
        int index=0;
        for(int i=0; i<12; i++){
           if(bArr.get(i).getImageButton().getId() == (view.getId()) )
           {
               index = i;
               break;
           }
        }

       int num = bArr.get(index).getNum();

        //store previous button clickeds index
        //check if this button is in array after the previous button
        //if yes make it disappear and update previous butttons index
       if(num== numordered [prevButtonIndex+1])
        {

            prevButtonIndex++;
           android.widget.Toast.makeText(getApplicationContext(), "Noicee!!",
                    android.widget.Toast.LENGTH_SHORT).show();
           ImageButton butts = (ImageButton) findViewById(view.getId());

            butts.setClickable(false);
            butts.setEnabled(false);
            butts.setVisibility(View.GONE);


        }

        if(prevButtonIndex== 11)
        {
            android.widget.Toast.makeText(getApplicationContext(), "Look what sleepyhead finally woke up!!",
                    android.widget.Toast.LENGTH_SHORT).show();
          //  next();

            android.content.Intent myIntent = new android.content.Intent (bubbGame.this, chickintro.class);

            bubbGame.this.startActivity(myIntent);
        }



    }}

