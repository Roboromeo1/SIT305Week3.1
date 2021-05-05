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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QuizStartActivity extends AppCompatActivity implements View.OnClickListener {


    TextView questionNo;
    TextView question;
    Button answer1;
    Button answer2;
    Button answer3;
    Button submitButton;
    ProgressBar progressBar;
    TextView outOfQuestions;

    int correct = 0;
    int questionCount = 1;
    int currentQuestionIndex = 0;
    String name;




    String[] ques1choices = new String[]{"Apple", "Microsoft", "Google"};
    String[] ques2choices = new String[]{"Video Driver", "Wifi Driver", "Bluetooth Driver"};
    String[] ques3choices = new String[]{"Redhat", "Mac", "Linux"};
    String[] ques4choices = new String[]{"Android Package kit", "Android packages", "Android packages Kernal"};
    String[] ques5choices = new String[]{"AVI", "MP4", "MPEG"};

    Questions[] questions = new Questions[]{
        new Questions("Andorid is developed by ?", "Google", ques1choices),
        new Questions("Which Code used in Andorid is not opensource", "Wifi Driver", ques2choices),
        new Questions("Android is based on which kernal ?", "Linux", ques3choices),
        new Questions("What is Apk in Android ?", "Android Package kit", ques4choices),
        new Questions("Which Media Format is not supported by android ?", "AVI", ques5choices),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);


        TextView welcomeName = findViewById(R.id.welcomeName);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        welcomeName.setText("Welcome " + name +"!");




        questionNo = findViewById(R.id.questionNo);
        question = findViewById(R.id.question);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        submitButton = findViewById(R.id.submitbtn);
        progressBar = findViewById(R.id.progressBar);
        outOfQuestions = findViewById(R.id.outOfQuestions);


        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        submitButton.setOnClickListener(this);


        updateQuestion();
        settingAnswers(questions[currentQuestionIndex].getChoices());


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.answer1: {
                buttonDisable();
                checkAnswer1(answer1.getText().toString());
                break;
            }
            case R.id.answer2: {
                buttonDisable();
                checkAnswer2(answer2.getText().toString());
                break;
            }
            case R.id.answer3: {
                buttonDisable();
                checkAnswer3(answer3.getText().toString());
                break;
            }
            case R.id.submitbtn: {
                if (currentQuestionIndex < 4) {


                    if (answer1.isEnabled() || answer2.isEnabled() || answer3.isEnabled())
                    {
                        Toast.makeText(this, "Please Select 1 option!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        currentQuestionIndex += 1;
                        updateQuestion();
                    }
                }
                else
                {
                    Intent lastWindow = new Intent(QuizStartActivity.this, FinalScore.class);
                    lastWindow.putExtra("score", correct);
                    lastWindow.putExtra("name", name);
                    startActivity(lastWindow);
                }
                break;
            }
        }

    }

    public void checkAnswer1(String answer)
    {

        if (answer == questions[currentQuestionIndex].getRightAnswer())
        {
            answer1.setBackgroundColor(Color.GREEN);
            correct++;
        }
        else
        {
            answer1.setBackgroundColor(Color.RED);
            if (answer2.getText().toString() == questions[currentQuestionIndex].getRightAnswer())
            {
                answer2.setBackgroundColor(Color.GREEN);
            }
            else
            {
                answer3.setBackgroundColor(Color.GREEN);
            }
        }


    }
    public void checkAnswer2(String answer)
    {

        if (answer == questions[currentQuestionIndex].getRightAnswer())
        {
            answer2.setBackgroundColor(Color.GREEN);
            correct++;
        }
        else
        {
            answer2.setBackgroundColor(Color.RED);
            if (answer1.getText().toString() == questions[currentQuestionIndex].getRightAnswer())
            {
                answer1.setBackgroundColor(Color.GREEN);
            }
            else
            {
                answer3.setBackgroundColor(Color.GREEN);
            }
        }


    }
    public void checkAnswer3(String answer)
    {

        if (answer == questions[currentQuestionIndex].getRightAnswer())
        {
            answer3.setBackgroundColor(Color.GREEN);
            correct++;
        }
        else
        {
            answer3.setBackgroundColor(Color.RED);
            if (answer2.getText().toString() == questions[currentQuestionIndex].getRightAnswer())
            {
                answer2.setBackgroundColor(Color.GREEN);
            }
            else
            {
                answer1.setBackgroundColor(Color.GREEN);
            }
        }


    }

    public void updateQuestion()
    {

        outOfQuestions.setText((questionCount-1) + "/5");
        progressBar.setProgress(questionCount - 1);
        questionNo.setText("Question " + questionCount);
        questionCount++;
        question.setText(questions[currentQuestionIndex].getQuestion());
        settingAnswers(questions[currentQuestionIndex].getChoices());


    }

    public void settingAnswers(String[] choices)
    {
        answer1.setText(choices[0]);
        answer2.setText(choices[1]);
        answer3.setText(choices[2]);
        resetColor();
        buttonEnable();
    }

    public void resetColor()
    {
        answer1.setBackgroundColor(Color.WHITE);
        answer2.setBackgroundColor(Color.WHITE);
        answer3.setBackgroundColor(Color.WHITE);
    }
    public void buttonDisable()
    {
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
    }

    public void buttonEnable()
    {
        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);
    }
}

