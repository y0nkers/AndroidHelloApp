package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  void testConstraintLayout(Context context) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setBackgroundColor(Color.BLACK);
        TextView textView = new TextView(context);
        textView.setText("Hello Android");
        textView.setTextSize(26);
        textView.setBackgroundColor(Color.CYAN);
        textView.setGravity(Gravity.CENTER);

        // получаем отступ в пикселях для 50 dp
        int margin50inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        // получаем отступ в пикселях для 60 dp
        int margin60inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
        // получаем отступ в пикселях для 40 dp
        int padding40inDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());

        // устанавливаем параметры размеров и расположение элемента
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        // установка внешних отступов
        layoutParams.setMargins(margin60inDp, margin50inDp, margin60inDp, margin50inDp);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 0, 1);
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
        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // выравнивание по центру родительского контейнера
        editTextParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        // добавляем в RelativeLayout
        relativeLayout.addView(editText, editTextParams);

        // устанавливаем параметры положения для Button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // выравнивание справа и снизу от поля EditText
        buttonParams.addRule(RelativeLayout.BELOW, editText.getId());
        buttonParams.addRule(RelativeLayout.ALIGN_RIGHT, editText.getId());
        // добавляем в RelativeLayout
        relativeLayout.addView(button, buttonParams);

        setContentView(relativeLayout);
    }

    public void testTableLayout(Context context) {
        TableLayout tableLayout = new TableLayout( context);

        // Row 1
        TableRow tableRow1 = new TableRow(context);

        TextView textView1 = new TextView(context);
        textView1.setText("Логин");
        tableRow1.addView(textView1, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));

        EditText editText1 = new EditText(context);
        tableRow1.addView(editText1, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

        // Row 2
        TableRow tableRow2 = new TableRow(context);

        TextView textView2 = new TextView(context);
        textView2.setText("Email");
        tableRow2.addView(textView2, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));

        EditText editText2 = new EditText(context);
        tableRow2.addView(editText2, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.f));

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        setContentView(tableLayout);
    }

    public void testFrameLayout(Context context) {
        setContentView(R.layout.frame_layout);
        ImageView img1 = (ImageView)findViewById(R.id.imageView1);
        ImageView img2 = (ImageView)findViewById(R.id.imageView2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setVisibility(View.VISIBLE);
                img1.setVisibility(View.GONE);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setVisibility(View.GONE);
                img1.setVisibility(View.VISIBLE);
            }
        });
    }

    public void testGridLayout(Context context) {
        GridLayout gridLayout = new GridLayout( context);

        gridLayout.setRowCount(3); // количество строк
        gridLayout.setColumnCount(3); // количество столбцов

        for(int i = 1; i <=3; i++){
            Button btn = new Button(context);
            btn.setText(String.valueOf(i));
            gridLayout.addView(btn);
        }

        Button btn4 = new Button(context);
        btn4.setText("4");
        GridLayout.LayoutParams layoutParams4 = new GridLayout.LayoutParams();
        layoutParams4.columnSpec = GridLayout.spec(0,2);
        layoutParams4.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());
        gridLayout.addView(btn4, layoutParams4);


        Button btn5 = new Button(context);
        btn5.setText("5");
        GridLayout.LayoutParams layoutParams5 = new GridLayout.LayoutParams();
        layoutParams5.rowSpec = GridLayout.spec(1,2);
        layoutParams5.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        gridLayout.addView(btn5, layoutParams5);

        Button btn6 = new Button(context);
        btn6.setText("6");
        Button btn7 = new Button(context);
        btn7.setText("7");
        gridLayout.addView(btn6);
        gridLayout.addView(btn7);

        setContentView(gridLayout);
    }

    public void testScrollView(Context context) {
        ScrollView scrollView = new ScrollView(context);

        TextView textView = new TextView(context);
        textView.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum.");
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(100);
        scrollView.addView(textView);
        setContentView(scrollView);
    }

    int clicks = 0;
    public void testClicks() {
        setContentView(R.layout.activity_main);

        TextView clicksText = findViewById(R.id.clicksText);
        // Сначала находим элементы include, которые указаны в activity_main.xml
        View plusButtonView = findViewById(R.id.plus_button);
        View minusButtonView = findViewById(R.id.minus_button);

        // Далее в этих View находим кнопку с определённым id
        Button plusButton = plusButtonView.findViewById(R.id.clickBtn);
        Button minusButton = minusButtonView.findViewById(R.id.clickBtn);

        plusButton.setText("clicks++");
        minusButton.setText("clicks--");

        plusButton.setOnClickListener(v -> {
            clicks++;
            clicksText.setText(clicks + " Clicks");
        });

        minusButton.setOnClickListener(v -> {
            if (clicks > 0) {
                clicks--;
                clicksText.setText(clicks + " Clicks");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        testClicks();
    }
}