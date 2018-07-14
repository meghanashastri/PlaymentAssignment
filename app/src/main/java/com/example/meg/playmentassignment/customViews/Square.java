package com.example.meg.playmentassignment.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import com.example.meg.playmentassignment.models.Points;
import java.util.ArrayList;
import java.util.List;




public class Square extends View {

    Canvas canvas;
    Paint paint = new Paint();

    // up/down/move
    String currentAction = "none";

    //start coordinates of the square
    int startX = 0;
    int startY = 0;

    //end coordinated of the square
    //set to 1 to avoid drawing square on initialisation
    int endX = 1;
    int endY = 1;

    //List of all squares draw on the canvas
    List<Points> mSquareList = new ArrayList<>();




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

        //clear the canvas
        canvas.drawColor(Color.TRANSPARENT);


        //onTap add square to list
        if((startX == endX) && (startY == endY))
        {


            //capturing points
            Points points = new Points();

            points.setStartX(startX);
            points.setStartY(startY);
            points.setEndX(endX + 200);
            points.setEndY(endY + 200);

            //adding each square to the list
            mSquareList.add(points);
        }

        //draw all squares

        for(int i=0; i< mSquareList.size(); i++){
            //draw a square
            canvas.drawRect(mSquareList.get(i).getStartX(), mSquareList.get(i).getStartY(),
                    mSquareList.get(i).getEndX() , mSquareList.get(i).getEndY(), paint);
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
            case MotionEvent.ACTION_CANCEL:
                onActionCancel(event);
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
        currentAction = "down";

        startX = (int)event.getX();
        startY = (int)event.getY();
    }

    private void onActionCancel(MotionEvent event) {

        currentAction = "cancel";
    }

    private void onActionMove(MotionEvent event) {

        currentAction = "move";

        endX = (int)event.getX();
        endY =(int)event.getY();

    }

    private void onActionUp(MotionEvent event) {

        currentAction = "up";

        endX = (int)event.getX();
        endY = (int)event.getY();

    }

}
