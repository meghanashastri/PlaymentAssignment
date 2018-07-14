package com.example.meg.playmentassignment.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meg.playmentassignment.R;
import com.example.meg.playmentassignment.customViews.Square;
import com.example.meg.playmentassignment.models.Points;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        Button btnViewCoordinates = (Button) findViewById(R.id.btnViewCoordinates);
        btnViewCoordinates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Points> squareList = new ArrayList<Points>(Square.getCoordinatesList());
                Intent intent = new Intent(MainActivity.this, ViewCoordinatesActivity.class);
                intent.putExtra("squareList", (Serializable) squareList);
                startActivity(intent);
            }
        });
    }
}
