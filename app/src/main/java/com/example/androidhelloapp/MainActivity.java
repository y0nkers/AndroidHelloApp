package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  void testConstraintLayout(Context context) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setBackgroundColor(Color.BLACK);
        TextView textView = new TextView(context);
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

    public void testLinearLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, 0, 1);
        layoutParams.gravity = Gravity.CENTER;

        TextView textView1 = new TextView(context);
        textView1.setText("Hello Java!");
        textView1.setTextSize(30);
        textView1.setBackgroundColor(Color.GRAY);
        linearLayout.addView(textView1, layoutParams);

        TextView textView2 = new TextView(context);
        textView2.setText("Hello World!");
        textView2.setTextSize(30);
        textView2.setBackgroundColor(Color.GRAY);
        linearLayout.addView(textView2, layoutParams);

        TextView textView3 = new TextView(context);
        textView3.setText("Hello Android!");
        textView3.setTextSize(30);
        textView3.setBackgroundColor(Color.GRAY);
        linearLayout.addView(textView3, layoutParams);

        setContentView(linearLayout);
    }

    public void testRelativeLayout(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);

        EditText editText = new EditText(context);
        editText.setHint("Email");
        editText.setId(EditText.generateViewId());

        Button button = new Button(context);
        button.setText("Отправить");

        // устанавливаем параметры положения для EditText
        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        // выравнивание по центру родительского контейнера
        editTextParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        // добавляем в RelativeLayout
        relativeLayout.addView(editText, editTextParams);

        // устанавливаем параметры положения для Button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        // выравнивание справа и снизу от поля EditText
        buttonParams.addRule(RelativeLayout.BELOW, editText.getId());
        buttonParams.addRule(RelativeLayout.ALIGN_RIGHT, editText.getId());
        // добавляем в RelativeLayout
        relativeLayout.addView(button, buttonParams);

        setContentView(relativeLayout);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*TextView textView = findViewById(R.id.header);
        textView.setText("Hello Android"); */

        testRelativeLayout(this);
        //setContentView(R.layout.relative_layout);
    }
}