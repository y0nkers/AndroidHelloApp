package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void toMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // FLAG_ACTIVITY_REORDER_TO_FRONT - перемещает activity на вершину стека, если она уже есть в стеке
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        // FLAG_ACTIVITY_CLEAR_TOP - все активности, которые в стеке выше вызываемой будут закрыты
        // FLAG_ACTIVITY_SINGLE_TOP - если активность уже запущена и находится на вершине стека, то новая активность не будет создаваться
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        // FLAG_ACTIVITY_NO_HISTORY - позволяет не сохранять активность в стеке. При уходе из неё она закрывается
        startActivity(intent);
    }
}