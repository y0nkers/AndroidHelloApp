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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;


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
        TextView topText = new TextView(context);
        topText.setBackgroundColor(0xffe8eaf6); // установка фонового цвета
        topText.setTextColor(0xff5c6bc0); // установка цвета текста
        topText.setAllCaps(true); // делаем все буквы заглавными
        topText.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER); // устанавливаем вравнивание текста по центру
        topText.setText("Hello, User!");
        topText.setId(View.generateViewId());
        topText.setTypeface(Typeface.create("casual", Typeface.NORMAL));
        topText.setTextSize(26);

        ConstraintLayout.LayoutParams topTextLayout = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        topTextLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        topTextLayout.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        topText.setLayoutParams(topTextLayout);

        EditText nameEdit = new EditText(context);
        nameEdit.setId(View.generateViewId());
        nameEdit.setHint("Введите имя");
        nameEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        nameEdit.setMaxLines(1);

        ConstraintLayout.LayoutParams nameEditLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        nameEditLayout.topToBottom = topText.getId();
        nameEditLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        nameEditLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        nameEdit.setLayoutParams(nameEditLayout);

        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (nameEdit.getText().toString().matches("")) topText.setText("Hello, User");
                else topText.setText("Hello, " + charSequence + "!");
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

        ConstraintLayout.LayoutParams inputButtonLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        inputButtonLayout.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        inputButtonLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        inputButtonLayout.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        inputButtonLayout.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        inputButton.setLayoutParams(inputButtonLayout);

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

        Button toastButton = new Button(context);
        toastButton.setText("Toast");
        toastButton.setId(View.generateViewId());

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Default toast
                /*Toast toast = Toast.makeText(context, "Toast!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 160);
                toast.show();*/

                // Custom toast
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, null);
                TextView text = layout.findViewById(R.id.toastText);
                text.setText("Toast!");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP, 0, 160);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

        Button snackbarButton = new Button(context);
        snackbarButton.setText("Snackbar");
        snackbarButton.setId(View.generateViewId());

        snackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Snackbar!", Snackbar.LENGTH_LONG);
                snackbar.setAction("Next", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(context, "Toast!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP, 0, 160);
                        toast.show();
                    }
                });

                snackbar.setTextColor(0XFF81C784);
                snackbar.setBackgroundTint(0XFF555555);
                snackbar.setActionTextColor(0XFF0277BD);
                snackbar.show();
            }
        });

        ConstraintLayout.LayoutParams toastButtonLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        toastButtonLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        toastButtonLayout.topToBottom = messageText.getId();
        toastButton.setLayoutParams(toastButtonLayout);

        ConstraintLayout.LayoutParams snackbarButtonLayout =  new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        snackbarButtonLayout.leftToRight = toastButton.getId();
        snackbarButtonLayout.topToBottom = messageText.getId();
        snackbarButton.setLayoutParams(snackbarButtonLayout);

        CheckBox checkBox = new CheckBox(context);
        checkBox.setId(View.generateViewId());
        checkBox.setText("Checkbox");

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) Toast.makeText(context, "Checkbox checked!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(context, "Checkbox unchecked!", Toast.LENGTH_SHORT).show();
            }
        });

        ConstraintLayout.LayoutParams checkBoxLayout = new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        checkBoxLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        checkBoxLayout.topToBottom = toastButton.getId();
        checkBox.setLayoutParams(checkBoxLayout);

        ToggleButton toggleButton = new ToggleButton(context);
        toggleButton.setId(View.generateViewId());
        toggleButton.setTextOff("Выключено");
        toggleButton.setText(toggleButton.getTextOff());
        toggleButton.setTextOn("Включено");
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((ToggleButton) view).isChecked();
                if (checked) Toast.makeText(context, "Свет включен", Toast.LENGTH_LONG).show();
                else Toast.makeText(context, "Свет выключен", Toast.LENGTH_LONG).show();
            }
        });

        ConstraintLayout.LayoutParams toggleButtonLayout = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        toggleButtonLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        toggleButtonLayout.topToBottom = checkBox.getId();
        toggleButton.setLayoutParams(toggleButtonLayout);

        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setId(View.generateViewId());
        radioGroup.setOrientation(RadioGroup.HORIZONTAL);

        ConstraintLayout.LayoutParams radioGroupLayout = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        radioGroupLayout.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        radioGroupLayout.topToBottom = toggleButton.getId();
        radioGroup.setLayoutParams(radioGroupLayout);

        RadioButton radioButton1 = new RadioButton(context);
        radioButton1.setId(View.generateViewId());
        radioButton1.setText("Java");
        radioGroup.addView(radioButton1);

        RadioButton radioButton2 = new RadioButton(context);
        radioButton2.setId(View.generateViewId());
        radioButton2.setText("Kotlin");
        radioGroup.addView(radioButton2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == radioButton1.getId()) Toast.makeText(context, "Выбрана Java", Toast.LENGTH_LONG).show();
                else if (id == radioButton2.getId()) Toast.makeText(context, "Выбрана Kotlin", Toast.LENGTH_LONG).show();
            }
        });

        constraintLayout.addView(topText);
        constraintLayout.addView(nameEdit);
        constraintLayout.addView(messageEdit);
        constraintLayout.addView(inputButton);
        constraintLayout.addView(nameText);
        constraintLayout.addView(messageText);
        constraintLayout.addView(toastButton);
        constraintLayout.addView(snackbarButton);
        constraintLayout.addView(checkBox);
        constraintLayout.addView(toggleButton);
        constraintLayout.addView(radioGroup);

        ConstraintLayout.LayoutParams constraintLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT );
        constraintLayout.setLayoutParams(constraintLayoutParams);

        ScrollView scrollView = new ScrollView(context);
        scrollView.setFillViewport(true);
        scrollView.addView(constraintLayout);

        setContentView(scrollView);
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

    public void dateTimePickersTest() {
        TextView dateTextView = findViewById(R.id.dateTextView);
        DatePicker datePicker = findViewById(R.id.datePicker);

        // Месяц начиная с нуля. Для отображения добавляем 1.
        datePicker.init(2020, 02, 01, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                // Отсчет месяцев начинается с нуля. Для отображения добавляем 1.
                dateTextView.setText("Дата: " + view.getDayOfMonth() + "/" + (view.getMonth() + 1) + "/" + view.getYear());

                // альтернативная запись
                // dateTextView.setText("Дата: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        });

        TextView timeTextView = findViewById(R.id.timeTextView);
        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeTextView.setText("Время: " + hourOfDay + ":" + String.format("%02d", minute));
                //timeTextView.setText("Время: " + view.getHour() + ":" + view.getMinute());
            }
        });
    }

    public void seekBarTest() {
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textView = findViewById(R.id.seekBarValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText(String.valueOf(progress));
                //textView.setText(String.valueOf(seekBar.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_elements);

        dateTimePickersTest();
        seekBarTest();
        //testElements(this);
    }

    public void inputInfo(View view) {
        EditText nameEdit = findViewById(R.id.name);
        EditText messageEdit = findViewById(R.id.message);

        TextView nameText = findViewById(R.id.nameText);
        TextView messageText = findViewById(R.id.messageText);

        nameText.setText("Name: " + nameEdit.getText());
        messageText.setText("Message: " + messageEdit.getText());

        Toast toast = Toast.makeText(this, "Toast!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

        Snackbar.make(view, "Snackbar!", Snackbar.LENGTH_LONG).show();
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        TextView checkboxText = findViewById(R.id.checkboxText);

        switch(view.getId()) {
            case R.id.checkbox1:
                if (checked) Toast.makeText(this, "Checkbox1 checked!",Toast.LENGTH_LONG).show();
                else Toast.makeText(this, "Checkbox1 unchecked!",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox2:
                if (checked) Toast.makeText(this, "Checkbox2 checked!",Toast.LENGTH_LONG).show();
                else Toast.makeText(this, "Checkbox2 unchecked!",Toast.LENGTH_LONG).show();
                break;
            default:
                checkboxText.setText("");
                break;
        }

        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        CheckBox checkbox2 = findViewById(R.id.checkbox2);
        String selectedItems = "";
        if (checkbox1.isChecked()) selectedItems += checkbox1.getText() + " ";
        if (checkbox2.isChecked()) selectedItems += checkbox2.getText();
        checkboxText.setText(selectedItems);
    }

    public void onToggleClicked(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) Toast.makeText(this, "Свет включен", Toast.LENGTH_LONG).show();
        else Toast.makeText(this, "Свет выключен", Toast.LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        TextView radioText = findViewById(R.id.radioText);
        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.java:
                if (checked) radioText.setText("Выбрана Java");
                break;
            case R.id.kotlin:
                if (checked) radioText.setText("Выбран Kotlin");
                break;
        }
    }
}