package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonComa;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMulti;
    Button buttonDiv;
    Button buttonEquals;
    Button buttonCE;
    Button buttonSqrt;
    Button buttonSquare;
    Button buttonPower;
    TextView viewer;

    private double result = 0;
    private String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonComa = (Button) findViewById(R.id.buttonComa);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonSqrt = (Button) findViewById(R.id.buttonSqrt);
        buttonSquare = (Button) findViewById(R.id.buttonSquare);
        buttonPower = (Button) findViewById(R.id.buttonPower);

        viewer = (TextView) findViewById(R.id.textView);
        viewer.setText("0");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewer.setText("1");
            }
        });
    }
}