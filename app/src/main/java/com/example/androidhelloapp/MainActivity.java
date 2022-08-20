package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
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

    public void testElements(Context context) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(0xffe8eaf6); // установка фонового цвета
        textView.setTextColor(0xff5c6bc0); // установка цвета текста
        textView.setAllCaps(true); // делаем все буквы заглавными
        textView.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER); // устанавливаем вравнивание текста по центру
        textView.setText("Hello, User!");
        textView.setId(View.generateViewId());
        textView.setTypeface(Typeface.create("casual", Typeface.NORMAL));
        textView.setTextSize(26);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        textView.setLayoutParams(layoutParams);

        TextView textView1 = new TextView(context);
        textView1.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_END);
        textView1.setText("Check out metanit.com");
        Linkify.addLinks(textView1, Linkify.WEB_URLS);
        textView1.setLayoutParams(layoutParams);
        textView1.setId(View.generateViewId());

        ConstraintLayout.LayoutParams layoutParams1 = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams1.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        textView1.setLayoutParams(layoutParams1);

        EditText nameEdit = new EditText(context);
        nameEdit.setId(View.generateViewId());
        nameEdit.setHint("Введите имя");
        nameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        nameEdit.setMaxLines(1);

        ConstraintLayout.LayoutParams nameEditLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        nameEditLayout.topToBottom = textView.getId();
        nameEditLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        nameEditLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        nameEdit.setLayoutParams(nameEditLayout);

        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (nameEdit.getText().toString().matches("")) textView.setText("Hello, User");
                else textView.setText("Hello, " + charSequence + "!");
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        EditText messageEdit = new EditText(context);
        messageEdit.setId(View.generateViewId());
        messageEdit.setHint("Введите сообщение");
        messageEdit.setSingleLine(false);
        messageEdit.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        messageEdit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        messageEdit.setGravity(Gravity.TOP);

        Button inputButton = new Button(context);
        inputButton.setText("Ввод");
        inputButton.setId(View.generateViewId());

        ConstraintLayout.LayoutParams messageEditLayout =  new ConstraintLayout.LayoutParams(0, 0);
        messageEditLayout.topToBottom = nameEdit.getId();
        messageEditLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        messageEditLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        messageEditLayout.bottomToTop = inputButton.getId();
        messageEdit.setLayoutParams(messageEditLayout);

        ConstraintLayout.LayoutParams buttonLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        buttonLayout.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        buttonLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        buttonLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        buttonLayout.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        inputButton.setLayoutParams(buttonLayout);


        TextView nameText = new TextView(context);
        nameText.setId(View.generateViewId());
        nameText.setText("Name: ");

        ConstraintLayout.LayoutParams nameTextLayout = new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        nameTextLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        nameTextLayout.topToBottom = inputButton.getId();
        nameText.setLayoutParams(nameTextLayout);

        TextView messageText = new TextView(context);
        messageText.setId(View.generateViewId());
        messageText.setText("Message: ");

        ConstraintLayout.LayoutParams messageTextLayout = new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        messageTextLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        messageTextLayout.topToBottom = nameText.getId();
        messageText.setLayoutParams(messageTextLayout);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("Name: " + nameEdit.getText());
                messageText.setText("Message: " + messageEdit.getText());
            }
        });

        constraintLayout.addView(textView);
        constraintLayout.addView(textView1);
        constraintLayout.addView(nameEdit);
        constraintLayout.addView(messageEdit);
        constraintLayout.addView(inputButton);
        constraintLayout.addView(nameText);
        constraintLayout.addView(messageText);
        setContentView(constraintLayout);
    }

    public void editText() {
        setContentView(R.layout.test_elements);

        EditText editText = findViewById(R.id.name);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                TextView textView = findViewById(R.id.topText);
                if (editText.getText().toString().matches("")) textView.setText("Hello, User!");
                else textView.setText("Hello, " + charSequence + "!");
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.test_elements);

        testElements(this);
    }

    public void inputInfo(View view) {
        EditText nameEdit = findViewById(R.id.name);
        EditText messageEdit = findViewById(R.id.message);

        TextView nameText = findViewById(R.id.nameText);
        TextView messageText = findViewById(R.id.messageText);

        nameText.setText("Name: " + nameEdit.getText());
        messageText.setText("Message: " + messageEdit.getText());

    }
}