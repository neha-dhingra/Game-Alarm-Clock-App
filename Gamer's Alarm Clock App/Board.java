package com.example.poorvanene.wakeywakey;

import java.util.Arrays;

/**
 * Created by nmskrishna on 5/17/18.
 */

public class Board {

    int [] arr = new int[18];

    public Board(){

        for(int i =0; i<18; i++){

            Bubble b = new Bubble();
            arr[i]= b.getNum();

        }

        Arrays.sort(arr);

    }

    public int getArrNum(int i){


        return arr[i];

    }




}
