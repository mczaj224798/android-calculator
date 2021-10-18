package com.example.calculator;

import android.content.Context;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Calculator {
    private CalculatorEngine engine;
    private CalculatorPrinter printer;

    private boolean digitClicked = false;
    private Context ctx;

    Calculator(TextView textView, Map<CalcButton, Button> buttonMap,
               ArrayList<Button> digitButtons, Context ctx) {
        this.printer = new CalculatorPrinter(textView);
        this.engine = new CalculatorEngine();
        this.ctx = ctx;

        for (int i=0; i<10; i++) {
            int finalI = i;
            digitButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    printer.append(String.valueOf(finalI));
                    digitClicked = true;
                    Log.wtf("CALC", "Digit true");
                }
            });
        }

        buttonMap.get(CalcButton.CE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printer.reset();
                engine.reset();
            }
        });

        buttonMap.get(CalcButton.PLUS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitClicked) {
                    engine.add(Double.parseDouble(printer.getString()));
                    Double result = engine.getResult();
                    printer.printAndClear(result.toString());
                    digitClicked = false;
                } else {
                    engine.setOp(CalculatorEngine.Operation.ADD);
                }
            }
        });

        buttonMap.get(CalcButton.MINUS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitClicked) {
                    engine.sub(Double.parseDouble(printer.getString()));
                    Double result = engine.getResult();
                    printer.printAndClear(result.toString());
                    digitClicked = false;
                } else {
                    engine.setOp(CalculatorEngine.Operation.SUB);
                }
            }
        });

        buttonMap.get(CalcButton.MULTIPLY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitClicked) {
                    engine.mul(Double.parseDouble(printer.getString()));
                    Double result = engine.getResult();
                    printer.printAndClear(result.toString());
                    digitClicked = false;
                } else {
                    engine.setOp(CalculatorEngine.Operation.MUL);
                }
            }
        });

        buttonMap.get(CalcButton.DIVIDE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitClicked) {
                    if (printer.getString().equals("0.0") || printer.getString().equals("0")) {
                        Toast.makeText(ctx, "Zero Division, go back to school!",
                                Toast.LENGTH_SHORT).show();

                    } else{
                        engine.div(Double.parseDouble(printer.getString()));
                        Double result = engine.getResult();
                        printer.printAndClear(result.toString());
                        digitClicked = false;
                    }
                } else {
                    engine.setOp(CalculatorEngine.Operation.DIV);
                }
            }
        });

        buttonMap.get(CalcButton.EQUALS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (digitClicked) {
                    engine.calculate(Double.parseDouble(printer.getString()));
                    Double result = engine.getResult();
                    printer.printAndClear(result.toString());
                    digitClicked = false;
//                }
            }
        });
    }


}
