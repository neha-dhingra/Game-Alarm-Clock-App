package com.example.poorvanene.wakeywakey;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Maths extends AppCompatActivity {

    static MediaPlayer p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        android.content.Intent intent = getIntent();
        String filename = intent.getStringExtra("name");
      MPattern gen = new MPattern();
      gen.generatePattern();
      int first = gen.getfirstnum();
      int second = gen.getsecnum();
      int third = gen.getthirdnum();
      int fourth = gen.getfourthnum();
      int ans = gen.getAnswer();


//        p = new MediaPlayer();
//        try {
//            android.content.res.AssetFileDescriptor afd = this.getApplicationContext().getAssets().openFd(filename);
//            p.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
//            afd.close();
//            p.prepare();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        p.start();





        android.widget.TextView firstt = (android.widget.TextView) findViewById(R.id.textView2);
        firstt.setText(Integer.toString(first));

        android.widget.TextView secc = (android.widget.TextView) findViewById(R.id.textView3);
        secc.setText(Integer.toString(second));

        android.widget.TextView thirdd = (android.widget.TextView) findViewById(R.id.textView4);
        thirdd.setText(Integer.toString(third));

        android.widget.TextView fourthh = (android.widget.TextView) findViewById(R.id.textView5);
        fourthh.setText(Integer.toString(fourth));

        android.widget.RadioButton choice1 = (android.widget.RadioButton) findViewById(R.id.radioButton);
        choice1.setText(Integer.toString((int) (java.lang.Math.random()*1000)));


        android.widget.RadioButton choice2 = (android.widget.RadioButton) findViewById(R.id.radioButton2);
        choice2.setText(Integer.toString(ans));


        android.widget.RadioButton choice3 = (android.widget.RadioButton) findViewById(R.id.radioButton3);
        choice3.setText(Integer.toString((int) (java.lang.Math.random()*1000)));

        android.widget.RadioButton choice4 = (android.widget.RadioButton) findViewById(R.id.radioButton4);
        choice4.setText(Integer.toString((int) (java.lang.Math.random()*1000)));


    }


    public void check(android.view.View view){

    boolean check = ((android.widget.RadioButton ) view).isChecked();

      switch(view.getId()){

          case R.id.radioButton:

              if(check)
              {
                  showIncorrectToast();
              }
              break;
          case R.id.radioButton2:

              if(check)
              {
                    showCorrectToast();
                    next(view);
              }
              break;
          case R.id.radioButton3:

              if(check)
              {
                  showIncorrectToast();
              }
              break;
          case R.id.radioButton4:

              if(check)
              {
                  showIncorrectToast();
              }
              break;
      }






    }

    private void showIncorrectToast() {
        android.widget.Toast.makeText(getApplicationContext(), "Try again dumbo!",
                android.widget.Toast.LENGTH_SHORT).show();
    }

    private void showCorrectToast() {
        android.widget.Toast.makeText(getApplicationContext(), "Smarty pants get a life!",
                android.widget.Toast.LENGTH_SHORT).show();
    }

    private void next(android.view.View view) {
        android.content.Intent myIntent = new android.content.Intent (Maths.this, bubbGame.class);

        Maths.this.startActivity(myIntent);

    }

}
