package com.example.quizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questioncount,questions;
    private Button opt1btn,opt2btn,opt3btn,opt4btn;
    private ArrayList<quizModal> quizModalArrayList;
    Random random;
    int currentScore = 0,questionsAttempted = 0,currentpos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questioncount = findViewById(R.id.noofques);
        questions = findViewById(R.id.questionspace);
        opt1btn = findViewById(R.id.opt1);
        opt2btn = findViewById(R.id.opt2);
        opt3btn = findViewById(R.id.opt3);
        opt4btn = findViewById(R.id.opt4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentpos = random.nextInt(quizModalArrayList.size());
        setdatatoViews(currentpos);
        opt1btn.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt1btn.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionsAttempted++;
            currentpos = random.nextInt(quizModalArrayList.size());
            setdatatoViews(currentpos);
        });
        opt2btn.setOnClickListener(v -> {
            if(Objects.equals(quizModalArrayList.get(currentpos).getAnswer().trim().toLowerCase(), opt2btn.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionsAttempted++;
            currentpos = random.nextInt(quizModalArrayList.size());
            setdatatoViews(currentpos);
        });
        opt3btn.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt3btn.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionsAttempted++;
            currentpos = random.nextInt(quizModalArrayList.size());
            setdatatoViews(currentpos);
        });
        opt4btn.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(opt4btn.getText().toString().trim().toLowerCase())){
                currentScore++;
            }
            questionsAttempted++;
            currentpos = random.nextInt(quizModalArrayList.size());
            setdatatoViews(currentpos);
        });

    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.ScoreIdLL));
        TextView scoreNum = bottomSheetView.findViewById(R.id.scoreTV);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.Restart);
        scoreNum.setText("Your score is \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentpos = random.nextInt(quizModalArrayList.size());
                setdatatoViews(currentpos);
                questionsAttempted = 0;
                currentScore = 0;
                bottomSheetDialog.cancel();

            }

        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
    private void setdatatoViews(int currentpos){
        questioncount.setText("Questions Attempted: "+questionsAttempted+"/10");
        if(questionsAttempted>=10){
            showBottomSheet();
        }
        else{
            questions.setText(quizModalArrayList.get(currentpos).getQuestion());
            opt1btn.setText(quizModalArrayList.get(currentpos).getOption1());
            opt2btn.setText(quizModalArrayList.get(currentpos).getOption2());
            opt3btn.setText(quizModalArrayList.get(currentpos).getOption3());
            opt4btn.setText(quizModalArrayList.get(currentpos).getOption4());
        }


    }
    private void getQuizQuestion(ArrayList<quizModal> quizModalArrayList) {
        quizModalArrayList.add(new quizModal("Who invented Java Programming?","Guido van Rossum ","James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling"));
        quizModalArrayList.add(new quizModal("Which statement is true about Java?"," Java is a sequence-dependent programming language.","Java is a code dependent programming language.","Java is a platform-dependent programming language."," Java is a platform independent programming language.","Java is a platform independent programming language."));
        quizModalArrayList.add(new quizModal("Which component is used to compile, debug and execute the java programs?","JRE","JIT","JDK","JVM","JDK"));
        quizModalArrayList.add(new quizModal("Which one of the following is not a Java feature?","Object-oriented","Use of pointers","Portable","Dynamic and Extensible","Use of pointers"));
        quizModalArrayList.add(new quizModal("Which of these cannot be used for a variable name in Java?","Identifier & keyword","identifier","keyword","None of the mentioned","keyword"));
        quizModalArrayList.add(new quizModal("What is the extension of java code files?",".js",".txt",".class",".java",".java"));
        quizModalArrayList.add(new quizModal("Which environment variable is used to set the java path?","MAVEN_HOME","CLASSPATH","JAVA","JAVA_HOME","JAVA_HOME"));
        quizModalArrayList.add(new quizModal("Which of the following is not an OOPS concept in Java?","Polymorphism","Inheritance","Compilation","Encapsulation","Compilation"));
        quizModalArrayList.add(new quizModal("What is not the use of “this” keyword in Java?","Referring to the instance variable when a local variable has the same name.","Passing itself to the method of the same class.","Passing itself to another method.","Calling another constructor in constructor chaining.","Passing itself to the method of the same class"));
        quizModalArrayList.add(new quizModal("Which of the following is a type of polymorphism in Java Programming?","Multiple polymorphism","Compile time polymorphism","Multilevel polymorphism","Execution time polymorphism","Compile time polymorphism"));

    }
}