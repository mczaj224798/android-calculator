package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdvancedCalculatorActivity extends AppCompatActivity {

    private Button button0, button1, button2,  button3,
            button4, button5, button6, button7, button8, button9;

    private Button buttonComma, buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonEquals;
    private Button buttonCE,  buttonAC,  buttonBack, buttonSave, buttonMem1, buttonMem2;
    private Button buttonSin, buttonCos, buttonTan, buttonLog, buttonLn, buttonSqrt, buttonX2;
    private Button buttonXY, buttonPercent, buttonBracketsOpen, buttonBracketsClose;
    private Calculator calculator;

    private TextView resultView, expView;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.wtf("SAVE", "exp=" + this.calculator.expPrinter.getString());
        Log.wtf("SAVE", "exp=" + this.calculator.resultPrinter.getString());

        savedInstanceState.putString("exp", this.calculator.expPrinter.getString());
        savedInstanceState.putString("res", this.calculator.resultPrinter.getString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.advanced_calculator_activity);

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

        buttonSin =(Button) findViewById(R.id.buttonSin);
        buttonMap.put(CalcButton.SIN, buttonSin);

        buttonCos =(Button) findViewById(R.id.buttonCos);
        buttonMap.put(CalcButton.COS, buttonCos);

        buttonTan =(Button) findViewById(R.id.buttonTan);
        buttonMap.put(CalcButton.TAN, buttonTan);

        buttonLog =(Button) findViewById(R.id.buttonLog);
        buttonMap.put(CalcButton.LOG, buttonLog);

        buttonLn =(Button) findViewById(R.id.buttonLn);
        buttonMap.put(CalcButton.LN, buttonLn);

        buttonSqrt =(Button) findViewById(R.id.buttonSqrt);
        buttonMap.put(CalcButton.SQRT, buttonSqrt);

        buttonX2 =(Button) findViewById(R.id.buttonSquare);
        buttonMap.put(CalcButton.X2, buttonX2);

        buttonXY =(Button) findViewById(R.id.buttonSquareY);
        buttonMap.put(CalcButton.XY, buttonXY);

        buttonPercent =(Button) findViewById(R.id.buttonPro);
        buttonMap.put(CalcButton.PERCENT, buttonPercent);

        buttonBracketsOpen = (Button) findViewById(R.id.buttonBracketsOpen);
        buttonMap.put(CalcButton.BRACKETS_OPEN, buttonBracketsOpen);

        buttonBracketsClose =(Button) findViewById(R.id.buttonBracketsClose);
        buttonMap.put(CalcButton.BRACKETS_CLOSE, buttonBracketsClose);

        this.calculator = new AdvancedCalculator(resultView, expView, buttonMap, digitButtons, getApplicationContext());
        if (savedInstanceState != null) {
            this.calculator.resultPrinter.append(savedInstanceState.getString("res"));
            this.calculator.expPrinter.append(savedInstanceState.getString("exp"));
            Log.wtf("LOAD", "exp=" + savedInstanceState.getString("exp"));
            Log.wtf("LOAD", "res=" + savedInstanceState.getString("res"));
        }
    }
}