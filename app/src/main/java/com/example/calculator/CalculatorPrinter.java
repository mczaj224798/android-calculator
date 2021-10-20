package com.example.calculator;

import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

public class CalculatorPrinter {

    private final int MAX_VISIBLE_LENGTH= 21;
    StringBuilder builder = new StringBuilder();
    TextView view;

    CalculatorPrinter(TextView view) {
        this.view = view;
    }

    public void append(String text){
        this.builder.append(text);
        print();
//        String string = builder.toString();
//        this.view.setText(string);
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
        print();
//        this.view.setText("");
    }

    private String trimLeadingZeros(String text) {
        String result = text;
        while (result.charAt(0) == '0' && result.length() >1) {
            result = result.substring(1);
        }
        return result;
    }

    public boolean isLastOp() {
        if (this.builder.length() > 0) {
            String lastChar = this.builder.substring(builder.length() - 1);
            Log.wtf("isLastOp", "string=" + lastChar);
            return (lastChar.equals(Calculator.PLUS) || lastChar.equals(Calculator.MINUS) ||
                    lastChar.equals(Calculator.DIVIDE) || lastChar.equals(Calculator.MULTIPLICATION));
        } else {
            return false;
        }
    }

    public void swapLastOp(Calculator.Operation newOp) {
        removeLastChar();
//        Log.wtf("swapLastOp", "after trim=" + this.builder.toString());
        switch (newOp) {
            case ADD:
                append(Calculator.PLUS);
                break;
            case SUB:
                append(Calculator.MINUS);
                break;
            case MUL:
                append(Calculator.MULTIPLICATION);
                break;
            case DIV:
                append(Calculator.DIVIDE);
                break;
        }
//        Log.wtf("swapLastOp", "after swap=" + this.builder.toString());

    }

    public int getLength() {
        return this.builder.length();
    }

    public void removeLastChar() {
        if (this.builder.length() > 0) {
            this.builder.setLength(this.builder.length() - 1);
        }
    }

    public String getString() {
        return this.view.getText().toString();
    }

    private void print() {
        String text = this.builder.toString();
        if (text.length() > MAX_VISIBLE_LENGTH) {
            text.substring(text.length() - MAX_VISIBLE_LENGTH + 3);
            text = "..." + text;
        }
//        Log.wtf("print", text);
        this.view.setText(text);
    }
}
