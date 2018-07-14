package com.example.meg.playmentassignment.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meg.playmentassignment.R;
import com.example.meg.playmentassignment.models.Points;

import java.util.List;

public class ViewCoordinatesActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_coordinates);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        List<Points> list = (List<Points>) intent.getSerializableExtra("squareList");

        ViewGroup parent = (ViewGroup) findViewById(R.id.coordinatesLayout);
        for (int i = 0; i < list.size(); i++) {
            View view;
            view = addTextToView(String.valueOf(list.get(i).getStartX()), String.valueOf(list.get(i).getStartY()),
                    String.valueOf(list.get(i).getEndX()), String.valueOf(list.get(i).getEndX()), i);
            parent.addView(view);
        }
    }

    //method to add views dynamically to the layout
    private View addTextToView(String startX, String startY, String endX, String endY, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.text_view, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 20, 20);
        textView.setText("Square " + (i + 1) + " ( " + startX + ", " + startY + " )"
                + "( " + endX + ", " + startY + ")" +
                "( " + endX + ", " + endY + " )" +
                "( " + startX + ", " + endY + " )");

        return view;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
