package com.example.calculator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class AdvancedCalculator extends Calculator{

    AdvancedCalculator(TextView resultView, TextView expView, Map<CalcButton, Button> buttonMap, ArrayList<Button> digitButtons, Context ctx) {
        super(resultView, expView, buttonMap, digitButtons, ctx);

        buttonMap.get(CalcButton.EQUALS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                    Double result = AdvancedCalculatorEngine.eval(expPrinter.getString());
                    if ( result.toString().length() > 18) {
                        DecimalFormat format = new DecimalFormat("0.####E0");
                        format.setMaximumFractionDigits(4);
                        format.setMinimumFractionDigits(0);
                        resultPrinter.clear();
                        resultPrinter.append(format.format(result));
                    } else {
                        resultPrinter.clear();
                        resultPrinter.append(result.toString());
                    }
                } catch (ArithmeticException e) {
                    Toast.makeText(ctx, "Zero Division or malformed expression, go back to school!",
                            Toast.LENGTH_LONG).show();
                }
                lastButtonPressed = CalcButton.EQUALS;
            }
        });

        buttonMap.get(CalcButton.SIN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("sin");
                lastButtonPressed = CalcButton.SIN;
            }
        });

        buttonMap.get(CalcButton.COS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("cos");
                lastButtonPressed = CalcButton.COS;
            }
        });

        buttonMap.get(CalcButton.TAN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("tan");
                lastButtonPressed = CalcButton.TAN;
            }
        });

        buttonMap.get(CalcButton.SQRT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("sqrt");
                lastButtonPressed = CalcButton.SQRT;
            }
        });

        buttonMap.get(CalcButton.X2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("^2");
                lastButtonPressed = CalcButton.X2;
            }
        });

        buttonMap.get(CalcButton.XY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("^");
                lastButtonPressed = CalcButton.XY;
            }
        });

        buttonMap.get(CalcButton.LN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("ln");
                lastButtonPressed = CalcButton.LN;
            }
        });

        buttonMap.get(CalcButton.LOG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("log");
                lastButtonPressed = CalcButton.LOG;
            }
        });

        buttonMap.get(CalcButton.PERCENT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append("%");
                lastButtonPressed = CalcButton.PERCENT;
            }
        });
    }


}
