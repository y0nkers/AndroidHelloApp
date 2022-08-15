package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        /*TextView textView = findViewById(R.id.header);
        textView.setText("Hello Android"); */

        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        constraintLayout.setBackgroundColor(Color.BLACK);
        TextView textView = new TextView(this);
        textView.setText("Hello Android");
        textView.setTextSize(26);
        textView.setBackgroundColor(Color.CYAN);

        // получаем отступ в пикселях для 50 dp
        int margin50inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        // получаем отступ в пикселях для 60 dp
        int margin60inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
        // получаем отступ в пикселях для 40 dp
        int padding40inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());

        // устанавливаем параметры размеров и расположение элемента
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        // установка внешних отступов
        layoutParams.setMargins(margin60inDp, margin50inDp, margin60inDp, margin50inDp);
        // эквивалент app:layout_constraintLeft_toLeftOf="parent"
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        // эквивалент app:layout_constraintTop_toTopOf="parent"
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        // устанавливаем параметры для textView
        textView.setLayoutParams(layoutParams);
        // установка внутренних отступов
        textView.setPadding(padding40inDp, padding40inDp, padding40inDp, padding40inDp);
        // добавляем TextView в ConstraintLayout
        constraintLayout.addView(textView);
        setContentView(constraintLayout);
    }
}