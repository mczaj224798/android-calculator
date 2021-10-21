package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicCalculatorActivity extends AppCompatActivity {

    private Button button0, button1, button2,  button3,
            button4, button5, button6, button7, button8, button9;

    private Button buttonComma, buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonEquals;
    private Button buttonCE,  buttonAC,  buttonBack, buttonSave, buttonMem1, buttonMem2;

    private TextView resultView, expView;

    private Calculator calculator;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("exp", this.calculator.expPrinter.getString());
        savedInstanceState.putString("res", this.calculator.resultPrinter.getString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_calculator_activity);

        resultView = (TextView) findViewById(R.id.resultView);
        expView = (TextView) findViewById(R.id.expView);


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

        ArrayList<Button> digitButtons = new ArrayList<>(
                Arrays.asList(button0, button1, button2, button3,
                        button4, button5, button6, button7,
                        button8, button9));

        Map<CalcButton, Button> buttonMap = new HashMap<>();

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMap.put(CalcButton.PLUS, buttonPlus);

        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMap.put(CalcButton.MINUS, buttonMinus);

        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonMap.put(CalcButton.MULTIPLY, buttonMulti);

        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMap.put(CalcButton.DIVIDE, buttonDiv);

        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonMap.put(CalcButton.EQUALS, buttonEquals);

        buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonMap.put(CalcButton.CE, buttonCE);

        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonMap.put(CalcButton.AC, buttonAC);

        buttonComma = (Button) findViewById(R.id.buttonComa);
        buttonMap.put(CalcButton.COMA, buttonComma);

        buttonMem1 = (Button) findViewById(R.id.buttonMem1);
        buttonMap.put(CalcButton.MEM1, buttonMem1);

        buttonMem2 = (Button) findViewById(R.id.buttonMem2);
        buttonMap.put(CalcButton.MEM2, buttonMem2);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonMap.put(CalcButton.BACK, buttonBack);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonMap.put(CalcButton.SAVE, buttonSave);

        this.calculator = new Calculator(resultView, expView, buttonMap, digitButtons, getApplicationContext());

        if ( savedInstanceState != null ) {
            this.calculator.resultPrinter.append(savedInstanceState.getString("res"));
            this.calculator.expPrinter.append(savedInstanceState.getString("exp"));
        }

    }
}