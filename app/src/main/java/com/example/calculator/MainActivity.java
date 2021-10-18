package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String DIV = "\\";
    private final static String MULTIPLY = "*";
    private final static String CE = "CE";
    private final static String AC = "AC";
    private final static String EQUALS = "=";
    private final static String COMMA = ",";

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;


    private Button buttonComma;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMulti;
    private Button buttonDiv;
    private Button buttonEquals;
    private Button buttonCE;
    private Button buttonAC;
    private Button buttonPro;
    private TextView view;


    private Button mapButton(int buttonId, String text)
    {
        Button button = (Button) findViewById(buttonId);
        button.setText(text);
        return button;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (TextView) findViewById(R.id.textView);
        view.setText("0.0");

        button0 = mapButton(R.id.button0, "0");
        button1 = mapButton(R.id.button1, "1");
        button2 = mapButton(R.id.button2, "2");
        button3 = mapButton(R.id.button3, "3");
        button4 = mapButton(R.id.button4, "4");
        button5 = mapButton(R.id.button5, "5");
        button6 = mapButton(R.id.button6, "6");
        button7 = mapButton(R.id.button7, "7");
        button8 = mapButton(R.id.button8, "8");
        button9 = mapButton(R.id.button9, "9");

        ArrayList<Button> digitButtons = new ArrayList<>(
                Arrays.asList(button0, button1, button2, button3,
                        button4, button5, button6, button7,
                        button8, button9));


        Map<CalcButton, Button> buttonMap = new HashMap<>();

        buttonPlus = mapButton(R.id.buttonPlus, "+");
        buttonMap.put(CalcButton.PLUS, buttonPlus);

        buttonMinus = mapButton(R.id.buttonMinus, "-");
        buttonMap.put(CalcButton.MINUS, buttonMinus);

        buttonMulti = mapButton(R.id.buttonMulti, "*");
        buttonMap.put(CalcButton.MULTIPLY, buttonMulti);

        buttonDiv = mapButton(R.id.buttonDiv, "/");
        buttonMap.put(CalcButton.DIVIDE, buttonDiv);

        buttonEquals = mapButton(R.id.buttonEquals, "=");
        buttonMap.put(CalcButton.EQUALS, buttonEquals);

        buttonCE = mapButton(R.id.buttonCE, "CE");
        buttonMap.put(CalcButton.CE, buttonCE);

        buttonAC = mapButton(R.id.buttonAC, "AC");
        buttonMap.put(CalcButton.AC, buttonAC);

        buttonComma = mapButton(R.id.buttonComa, ",");
        buttonMap.put(CalcButton.COMMA, buttonComma);

        buttonPro = mapButton(R.id.buttonPro, "%");
        buttonMap.put(CalcButton.PERCENT, buttonPro);

        Calculator calculator = new Calculator(view, buttonMap, digitButtons, getApplicationContext());
    }
}