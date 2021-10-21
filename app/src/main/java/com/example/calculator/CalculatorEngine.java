package com.example.calculator;

import android.util.Log;

import org.mariuszgromada.math.mxparser.Expression;


public class CalculatorEngine {

    public CalculatorEngine() {
    };



    public static Double eval(String exp)  {
        String lastChar = exp.substring(exp.length()-1);
        if(lastChar.equals(Calculator.PLUS) || lastChar.equals(Calculator.MINUS) ||
            lastChar.equals(Calculator.MULTIPLICATION) || lastChar.equals(Calculator.DIVIDE)) {
            exp = exp.substring(0, exp.length()-1);
        }
        Expression e = new Expression(exp.toString().replaceAll("x", "*"));
//        Log.wtf("eval", exp.toString().replaceAll("x", "*"));
        Double res = e.calculate();
//        Log.wtf("eval", "error=" +  e.getErrorMessage());
//        Log.wtf("eval", "result=" + res.toString());
        if ( String.valueOf(res).equals("NaN")) {
            throw new ArithmeticException();
        }
        return e.calculate();
    }
}
