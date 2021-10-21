package com.example.calculator;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class AdvancedCalculatorEngine extends Calculator{

    private static final String bracketsAddRegex = "(sin|cos|tan|sqrt|ln)([0-9\\\\.]+)";
    private static final String logRegex = "(log)([0-9\\\\.]+)";


    AdvancedCalculatorEngine(TextView resultView, TextView expView, Map<CalcButton, Button> buttonMap, ArrayList<Button> digitButtons, Context ctx) {
        super(resultView, expView, buttonMap, digitButtons, ctx);
    }

    public static Double test(String text) {
        return  AdvancedCalculatorEngine.eval(text);
    }

    public static Double eval(String exp) {
        Log.wtf("entry", exp);
        exp = exp.replaceAll(bracketsAddRegex, "$1($2)");
        exp = exp.replaceAll(logRegex, "$110($2)");

        Log.wtf("replaced", exp);
        return CalculatorEngine.eval(exp);
    }
}
