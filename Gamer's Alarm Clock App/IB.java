package com.example.poorvanene.wakeywakey;

import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by nmskrishna on 5/22/18.
 */

public class IB {

    int numButton;
    android.widget.TextView tv;
    android.widget.ImageButton ib;



    public void setNum(int num){

        numButton=num;


    }

    public int getNum(){

        return numButton;

    }

    public ImageButton getImageButton(){

        return ib;

    }

    public void settv(android.widget.TextView TextView){

        tv= TextView;


    }

    public void setText(int n){
    String s = Integer.toString(n);
        tv.setText(s);


    }
    public void setImageButton(ImageButton ib){

        this.ib = ib;


    }





}
