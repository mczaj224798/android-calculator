package com.example.calculator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Calculator {
    private CalculatorEngine engine;
    private CalculatorPrinter resultPrinter;
    private CalculatorPrinter expPrinter;
    private CalculatorMemory mem1;
    private CalculatorMemory mem2;

    private Context ctx;

    private CalcButton lastButtonPressed = CalcButton.INIT;

    public static final String MINUS = "-";
    public static final String DIVIDE = "/";
    public static final String PLUS = "+";
    public static final String MULTIPLICATION = "x";
    public static final String COMA = ".";

    public enum Operation {
        ADD, SUB, DIV, MUL
    }


    Calculator(TextView resultView, TextView expView, Map<CalcButton, Button> buttonMap,
               ArrayList<Button> digitButtons, Context ctx) {
        this.resultPrinter = new CalculatorPrinter(resultView);
        this.expPrinter = new CalculatorPrinter(expView);
        this.engine = new CalculatorEngine();
        this.mem1 = new CalculatorMemory();
        this.mem2 = new CalculatorMemory();
        this.ctx = ctx;

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            digitButtons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expPrinter.append(String.valueOf(finalI));
                    lastButtonPressed = CalcButton.NUMBER;
                }
            });
        }

        buttonMap.get(CalcButton.PLUS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expPrinter.isLastOp()) {
                    Log.wtf("CALC", "last is op");
                    expPrinter.swapLastOp(Operation.ADD);
                } else {
                    expPrinter.append(PLUS);
                }
                lastButtonPressed = CalcButton.PLUS;
            }
        });

        buttonMap.get(CalcButton.MINUS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expPrinter.isLastOp()) {
                    expPrinter.swapLastOp(Operation.SUB);
                } else {
                    expPrinter.append(MINUS);
                }
                lastButtonPressed = CalcButton.MINUS;
            }
        });

        buttonMap.get(CalcButton.DIVIDE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expPrinter.isLastOp()) {
                    expPrinter.swapLastOp(Operation.DIV);
                } else {
                    expPrinter.append(DIVIDE);
                }
                lastButtonPressed = CalcButton.DIVIDE;
            }
        });

        buttonMap.get(CalcButton.MULTIPLY).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expPrinter.isLastOp()) {
                    expPrinter.swapLastOp(Operation.MUL);
                } else {
                    expPrinter.append(MULTIPLICATION);
                }
                lastButtonPressed = CalcButton.MULTIPLY;
            }
        });

        buttonMap.get(CalcButton.EQUALS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double result = engine.eval(expPrinter.getString());
                    resultPrinter.append(String.valueOf(result));
                    resultPrinter.clear();
//                    expPrinter.clear();
                } catch (ArithmeticException e) {
                    Toast.makeText(ctx, "Zero Division in expression, go back to school!",
                            Toast.LENGTH_LONG).show();
                }
                lastButtonPressed = CalcButton.EQUALS;
            }
        });

        buttonMap.get(CalcButton.BACK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.removeLastChar();
                expPrinter.append("");
                lastButtonPressed = CalcButton.BACK;
            }
        });

        buttonMap.get(CalcButton.CE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.reset();
                lastButtonPressed = CalcButton.CE;
            }
        });

        buttonMap.get(CalcButton.AC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.reset();
                resultPrinter.reset();
                mem1.reset();
                mem2.reset();
                lastButtonPressed = CalcButton.AC;
            }
        });

        buttonMap.get(CalcButton.SAVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Please choose memory!",
                        Toast.LENGTH_LONG).show();
                lastButtonPressed = CalcButton.SAVE;
            }
        });buttonMap.get(CalcButton.MEM1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastButtonPressed.equals(CalcButton.SAVE)) {
                    mem1.setValue(Double.parseDouble(resultPrinter.getString()));
                    Toast.makeText(ctx, "Value saved to Memory1!",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (mem1.isSaved()) {
                        if (!expPrinter.isLastOp() && expPrinter.getLength() >0) {
                            expPrinter.append(PLUS);
                        }
                        expPrinter.append(String.valueOf(mem1.getValue()));
                    } else {
                        Toast.makeText(ctx, "Nothing stored in Memory1!",
                                Toast.LENGTH_LONG).show();
                    }
                }
                lastButtonPressed = CalcButton.MEM1;
            }
        });

        buttonMap.get(CalcButton.MEM2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastButtonPressed.equals(CalcButton.SAVE)) {
                    mem2.setValue(Double.parseDouble(resultPrinter.getString()));
                    Toast.makeText(ctx, "Value savedd to Memory2!",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (mem2.isSaved()) {
                        if (!expPrinter.isLastOp() && expPrinter.getLength() >0) {
                            expPrinter.append(PLUS);
                        }
                        expPrinter.append(String.valueOf(mem2.getValue()));
                    } else {
                        Toast.makeText(ctx, "Nothing store in Memory2!",
                                Toast.LENGTH_LONG).show();
                    }
                }
                lastButtonPressed = CalcButton.MEM2;
            }
        });

        buttonMap.get(CalcButton.COMA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expPrinter.append(COMA);
                lastButtonPressed = CalcButton.COMA;
            }
        });


    }
}
