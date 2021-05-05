package com.example.taskquizapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FinalScore extends AppCompatActivity {

    TextView congratsMsg;
    TextView score;
    Button newQuiz;
    Button finish;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);


        congratsMsg = findViewById(R.id.congratsMsg);
        score = findViewById(R.id.score);
        newQuiz = findViewById(R.id.newQuiz);
        finish = findViewById(R.id.finish);


        Intent thisWindow = getIntent();

        name = thisWindow.getStringExtra("name");
        congratsMsg.setText("Congratulations " + name + "!");
        int tScore = thisWindow.getIntExtra("score", 0);

        score.setText(tScore + "/5");


    }

    public void takeNewQuiz(View view) {
        Intent firstWindow = new Intent(FinalScore.this, MainActivity.class);
        firstWindow.putExtra("name", name);
        startActivity(firstWindow);
    }

    public void exit(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}