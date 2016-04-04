package com.adolph.jrm.thefirstdemo_screenlock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GestureLock extends View {

    private Point[][] points = new Point[3][3];
    private boolean inited = false;
    private float bitmapR;

    private Bitmap bitmapPointError;
    private Bitmap bitmapPointPress;
    private Bitmap bitmapPointNormal;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public GestureLock(Context context) {
        super(context);
    }

    public GestureLock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GestureLock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!inited){
            init();
        }

        drawPoints(canvas);
    }

    private void drawPoints(Canvas canvas){
        for(int i = 0;i < points.length; i++){
            for(int j = 0;j < points[0].length; j++){
                if(points[i][j].state == Point.STATE_NORMAL){

                    canvas.drawBitmap(bitmapPointNormal,points[i][j].x - bitmapR,points[i][j].y - bitmapR,paint);

                }else if(points[i][j].state == Point.STATE_PRESS){

                    canvas.drawBitmap(bitmapPointPress,points[i][j].x - bitmapR,points[i][j].y - bitmapR,paint);

                }else {

                    canvas.drawBitmap(bitmapPointError,points[i][j].x - bitmapR,points[i][j].y - bitmapR,paint);

                }
            }
        }
    }

    private void init(){

        bitmapPointError = BitmapFactory.decodeResource(getResources(), R.drawable.error);
        bitmapPointPress = BitmapFactory.decodeResource(getResources(), R.drawable.press);
        bitmapPointNormal = BitmapFactory.decodeResource(getResources(), R.drawable.normal);

        bitmapR = bitmapPointError.getHeight() / 2;

        int width = getWidth();
        int height = getHeight();
        int offset = Math.abs(width - height) / 2;
        int offset_x, offset_y;
        int space;

        if(width > height){
            space = height / 4;
            offset_x = offset;
            offset_y = 0;
        }else {
            space = width / 4;
            offset_x = 0;
            offset_y = offset;
        }

        points[0][0] = new Point(offset_x + space, offset_y + space);
        points[0][1] = new Point(offset_x + space * 2, offset_y + space);
        points[0][2] = new Point(offset_x + space * 3, offset_y + space);

        points[1][0] = new Point(offset_x + space, offset_y + space * 2);
        points[1][1] = new Point(offset_x + space * 2, offset_y + space * 2);
        points[1][2] = new Point(offset_x + space * 3, offset_y + space * 2);

        points[2][0] = new Point(offset_x + space, offset_y + space * 3);
        points[2][1] = new Point(offset_x + space * 2, offset_y + space * 3);
        points[2][2] = new Point(offset_x + space * 3, offset_y + space * 3);

        inited = true;
    }

}
