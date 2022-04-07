package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;
    Integer firstNumber = 0;
    Integer secondNumber = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null && savedInstanceState.containsKey("firstNumber")
                && savedInstanceState.containsKey("secondNumber"))
        {
            firstNumber = savedInstanceState.getInt("firstNumber");
            secondNumber = savedInstanceState.getInt("secondNumber");
        }
        intent = new Intent(this, MainActivity2.class);
        intent.putExtra("firstNumber", firstNumber);
        intent.putExtra("secondNumber", secondNumber);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("firstNumber", firstNumber);
        outState.putInt("secondNumber", secondNumber);
    }

    public void onClickNegative(View view){
        try {
            firstNumber = Integer.parseInt(editText.getText().toString());
            if (firstNumber > 0) {
                editText.setText("-" + firstNumber);
            }
            if (firstNumber < 0) {
                firstNumber *= -1;
                editText.setText(firstNumber.toString());
            }
        }
        catch (Exception ex){
            Toast.makeText(this, "Неверный ввод", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickNegative1(View view){
        try {
            secondNumber = Integer.parseInt(editText1.getText().toString());
            if (secondNumber > 0) {
                editText1.setText("-" + secondNumber);
            }
            if (secondNumber < 0) {
                secondNumber *= -1;
                editText1.setText(secondNumber.toString());
            }
        }
        catch (Exception ex){
            Toast.makeText(this, "Неверный ввод", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickSum(View view){
        try {
            firstNumber = Integer.parseInt(editText.getText().toString());
            secondNumber = Integer.parseInt(editText1.getText().toString());
            intent.putExtra("firstNumber", firstNumber);
            intent.putExtra("secondNumber", secondNumber);
            startActivity(intent);
        }
        catch (Exception ex){
            Toast.makeText(this, "Неверный ввод", Toast.LENGTH_LONG).show();
        }
    }


}