package com.example.meg.playmentassignment.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;

public class Square extends View {

    Paint paint = new Paint();
    float startX = 0f;
    float startY = 0f;

    float endX = 0f;
    float endY = 0f;

    boolean isDown = false;
    Canvas canvas;

    public Square(Context context) {
        super(context);
        init();
    }

    public Square(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public Square(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setFocusable(true);
        paint = new Paint();
        canvas = new Canvas();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
    }


    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawColor(Color.TRANSPARENT);
        if (isDown) {
            canvas.drawRect(startX, startY, endX, endY, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onActionDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                onActionMove(event);
                break;
            case MotionEvent.ACTION_UP:
                onActionUp(event);
                break;
            default:
                break;
        }

        // Re draw
        invalidate();

        return true;
    }

    private void onActionDown(MotionEvent event) {
        startX = event.getX();
        startY = event.getY();

        endY = 0;
        endX = 0;

    }

    private void onActionMove(MotionEvent event) {
        endX = event.getX();
        endY = event.getY();
        isDown = true;
    }

    private void onActionUp(MotionEvent event) {
        endX = event.getX();
        endY = event.getY();
        isDown = true;
    }

}
