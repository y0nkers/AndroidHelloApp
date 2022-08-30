package com.example.androidhelloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle arguments = getIntent().getExtras();

        User user;
        if (arguments != null) {
            // user = (User) arguments.getSerializable(UserSerializable.class.getSimpleName());
            user = arguments.getParcelable(User.class.getSimpleName());
            TextView name = findViewById(R.id.name_activity_second);
            TextView company = findViewById(R.id.company_activity_second);
            TextView age = findViewById(R.id.age_activity_second);

            name.setText("Name: " + user.getName());
            company.setText("Company: " + user.getCompany());
            age.setText("Age: " + user.getAge());
        }

    }

    public void onCancelClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onButton1Click(View v) {
        sendMessage("Доступ разрешен");
    }

    public void onButton2Click(View v) {
        sendMessage("Доступ запрещен");
    }

    public void onButton3Click(View v) {
        sendMessage("Недопустимый возраст");
    }

    private void sendMessage(String message) {

        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_MESSAGE, message);
        setResult(RESULT_OK, data);
        finish();
    }

    public void toThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}