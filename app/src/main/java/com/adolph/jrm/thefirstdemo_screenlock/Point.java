package com.adolph.jrm.thefirstdemo_screenlock;

/**
 * Created by Adolph on 16/4/4.
 */
public class Point {

    public static int STATE_NORMAL = 0;
    public static int STATE_PRESS = 1;
    public static int STATE_ERROR = 2;


    float x, y;
    int state = STATE_NORMAL;

    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }

}