package com.example.calculator;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean choiceATextView = true;
    boolean numbersMode = false;
    Integer firstNumber = 0;
    Integer secondNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeNumbersMode(View view){
       numbersMode =!numbersMode;
        if(numbersMode){
            if (choiceATextView){
                TextView textView = findViewById(R.id.textView);
                textView.setText("-"+firstNumber);
            }
            else{
                TextView textView1 = findViewById(R.id.textView1);
                textView1.setText("-"+secondNumber);
            }
        }
        else {
            if (choiceATextView){
                TextView textView = findViewById(R.id.textView);
                textView.setText(firstNumber.toString());
            }
            else{
                TextView textView1 = findViewById(R.id.textView1);
                textView1.setText(secondNumber.toString());
            }
        }
    }


    public void onClickTextView(View view) {
        choiceATextView = true;
    }

    public void onClickTextView1(View view) {
        choiceATextView = false;
    }

    public void onClickButton(View view) {
        Button button = findViewById(view.getId());
        if(numbersMode){
            if (choiceATextView){
                TextView textView = findViewById(R.id.textView);
                firstNumber = Integer.parseInt(firstNumber.toString()+button.getText());
                textView.setText("-"+firstNumber);
            }
            else{
                TextView textView1 = findViewById(R.id.textView1);
                secondNumber = Integer.parseInt(secondNumber.toString()+button.getText());
                textView1.setText("-"+secondNumber);
            }
        }
        else {
            if (choiceATextView){
                TextView textView = findViewById(R.id.textView);
                firstNumber = Integer.parseInt(firstNumber.toString()+button.getText());
                textView.setText(firstNumber.toString());
            }
            else{
                TextView textView1 = findViewById(R.id.textView1);
                secondNumber = Integer.parseInt(secondNumber.toString()+button.getText());
                textView1.setText(secondNumber.toString());
            }
        }
    }

    public void onClickResult(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView1);
        intent.putExtra("firstNumber",Integer.parseInt(textView.getText().toString()));
        intent.putExtra("secondNumber",Integer.parseInt(textView1.getText().toString()));
        startActivity(intent);
    }

    public void onClickClear(View view){
        if (choiceATextView){
            TextView textView = findViewById(R.id.textView);
            firstNumber=0;
            textView.setText("");
        }
        else{
            TextView textView1 = findViewById(R.id.textView1);
            secondNumber=0;
            textView1.setText("");
        }
    }
}