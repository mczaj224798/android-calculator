package com.example.calculator;

import android.widget.TextView;

public class CalculatorPrinter {


    StringBuilder builder = new StringBuilder();
    TextView view;
    private boolean error = false;

    CalculatorPrinter(TextView view) {
        this.view = view;
    }

    public void append(String text){
        this.builder.append(text);
        String string = builder.toString();

//        if (string.length() >= 22) {
//            this.error = true;
//            this.view.setText("ERROR: number too big!");
//            clear();
//            return;
//        }
//        // trim leading zeros
//        string = trimLeadingZeros(string);
        this.view.setText(string);
    }

    public void print(String text) {
        append(text);
        clear();
    }

    public void clear() {
        this.builder.setLength(0);
    }

    public void printAndClear(String text) {
        this.builder.setLength(0);
        this.builder.append(text);
        this.view.setText(text);
        this.builder.setLength(0);
    }

    public void reset() {
        this.builder.setLength(0);
        this.view.setText("0.0");
    }

    private String trimLeadingZeros(String text) {
        String result = text;
        while (result.charAt(0) == '0' && result.length() >1) {
            result = result.substring(1);
        }
        return result;
    }

    public String getString() {
        return this.view.getText().toString();
    }
}
