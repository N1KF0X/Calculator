package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle arguments = getIntent().getExtras();
        TextView textView2 = findViewById(R.id.textView2);
        String firstNumber;
        String secondNumber;
        Integer result = arguments.getInt("firstNumber")+arguments.getInt("secondNumber");
        if(arguments.getInt("firstNumber")<0){
           firstNumber = "("+arguments.get("firstNumber").toString()+")";
        }
        else {
            firstNumber = arguments.get("firstNumber").toString();
        }

        if(arguments.getInt("secondNumber")<0){
            secondNumber = "("+arguments.get("secondNumber").toString()+")";
        }
        else {
            secondNumber = arguments.get("secondNumber").toString();
        }
        textView2.setText(firstNumber+" + "+secondNumber+" = "+result);
    }
    public void onClickReturn(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}