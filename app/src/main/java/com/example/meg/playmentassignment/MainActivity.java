package com.example.meg.playmentassignment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meg.playmentassignment.customViews.Square;

public class MainActivity extends AppCompatActivity {
    Square drawView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new Square(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);

    }
}
