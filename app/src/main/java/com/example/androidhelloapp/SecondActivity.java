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

        User user;
        if (arguments != null) {
            user = (User) arguments.getSerializable(User.class.getSimpleName());
            TextView name = findViewById(R.id.name_activity_second);
            TextView company = findViewById(R.id.company_activity_second);
            TextView age = findViewById(R.id.age_activity_second);

            name.setText("Name: " + user.getName());
            company.setText("Company: " + user.getCompany());
            age.setText("Age: " + user.getAge());
        }

    }
}