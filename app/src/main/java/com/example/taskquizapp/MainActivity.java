package com.example.taskquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameEnterEdit);

        Intent mainWindow = getIntent();
        name.setText(mainWindow.getStringExtra("name"));



    }

    public void GameStart(View view) {
        Intent intent = new Intent(getApplicationContext(), QuizStartActivity.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }
}