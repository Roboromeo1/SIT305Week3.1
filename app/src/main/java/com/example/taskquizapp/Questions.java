package com.example.taskquizapp;

public class Questions {

    private String question;
    private String rightAnswer;
    private String[] choices;

    public Questions(String question, String rightAnswer, String[] choices){
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }


    public String getRightAnswer() {
        return rightAnswer;
    }


    public String[] getChoices() {
        return choices;
    }
}
