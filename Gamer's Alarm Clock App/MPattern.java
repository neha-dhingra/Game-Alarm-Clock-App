package com.example.poorvanene.wakeywakey;

import java.lang.*;

/**
 * Created by nmskrishna on 5/15/18.
 */

public class MPattern {

    int[] nums = new int[5];
    int firstnum;
    public void generatePattern(){
        firstnum = 6;

         int randOp = (int) (java.lang.Math.random()*2 );
         int nextRandOp = (int) (java.lang.Math.random()*2 );
         int changeNum = (int) (java.lang.Math.random()*5 ) + 1;

         if(randOp==0&& nextRandOp==1)
         {
             nums[0] = firstnum;
             for(int i =1; i< nums.length; i++){
                 nums[i] = nums[i-1] + (changeNum * i);

             }
         }
             if(randOp==0&& nextRandOp==0)
             {
                 nums[0] = firstnum;
                 for(int i =1; i< nums.length; i++){
                     nums[i] = nums[i-1] * (changeNum * i);

                 }
             }
                 if(randOp==1&& nextRandOp==1)
                 { nums[0] = firstnum;
                     for(int i =1; i< nums.length; i++){
                         nums[i] = nums[i-1] * (changeNum + i);

                     }
                 }
                     if(randOp==0&& nextRandOp==1)

                         { nums[0] = firstnum;
                             for(int i =1; i< nums.length; i++){
                                 nums[i] = nums[i-1] * (changeNum + (4* i));

                             }
                     }

    }
    public int getfirstnum(){

    return nums[0];

    }
    public int getsecnum(){

    return nums[1];

    }
    public int getthirdnum(){

    return nums[2];

    }

    public int getfourthnum(){

    return nums[3];

    }





    public int getAnswer(){
        return nums[4];


    }


    public boolean checkNum(int check){
        if(check == getAnswer())
        {return true;}
        return false;

    }









}
