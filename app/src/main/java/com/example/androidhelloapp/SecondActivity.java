package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle arguments = getIntent().getExtras();
        String message = arguments.get("message").toString();

        TextView centerText = (TextView)findViewById(R.id.centerText);
        centerText.setText(message);
    }
}