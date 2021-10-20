package com.example.calculator;

import android.util.Log;

import org.mariuszgromada.math.mxparser.Expression;

import javax.sql.StatementEvent;

public class CalculatorEngine {

    private StringBuilder expBuilder = new StringBuilder();

    public CalculatorEngine() {

    };

    public void test() {
        Expression e = new Expression("2/0");
        Log.wtf("CALC", String.valueOf(e.calculate()));
    }

    public Double eval(String exp) {
        String lastChar = exp.substring(exp.length()-1);
        if(lastChar.equals(Calculator.PLUS) || lastChar.equals(Calculator.MINUS) ||
            lastChar.equals(Calculator.MULTIPLICATION) || lastChar.equals(Calculator.DIVIDE)) {
            exp = exp.substring(0, exp.length()-1);
        }
        Expression e = new Expression(exp.toString().replaceAll("x", "*"));
        Log.wtf("eval", exp.toString().replaceAll("x", "*"));
        Double res = e.calculate();
        if ( String.valueOf(res).equals("NaN")) {
            throw new ArithmeticException();
        }
        return e.calculate();
    }

//    public Double getResult() {
//        return this.left;
//    }
//
//    public void add(Double value){
//        Log.wtf("CALC", "Add " + this.left + " and " + value);
//        this.left = this.left + value;
//        this.lastOp = Operation.ADD;
//
//    }
//
//    public void sub(Double value){
//        Log.wtf("CALC", "Sub " + this.left + " and " + value);
//        this.left = this.left - value;
//        this.lastOp = Operation.SUB;
//    }
//    public void mul(Double value){
//        Log.wtf("CALC", "Mul " + this.left + " and " + value);
//        if (this.lastOp.equals(Operation.NO_OP)) {
//            this.lastOp = Operation.MUL;
////        } else {
//           this.left = this.left * value;
//           this.lastOp = Operation.MUL;
////        }
//    }
//
//    public void div(Double value){
//        Log.wtf("CALC", "Div " + this.left + " and " + value);
//        this.left = this.left / value;
//        this.lastOp = Operation.DIV;
//    }
//
//    public void setOp(Operation op) {
//        this.lastOp = op;
//    }
//
//    public void calculate(Double value){
//        switch (this.lastOp) {
//            case ADD:
//                this.add(value);
//                break;
//            case SUB:
//                this.sub(value);
//                break;
//            case MUL:
//                this.mul(value);
//                break;
//            case DIV:
//                break;
//            case NO_OP:
//        }
////        this.lastOp = Operation.NO_OP;
//    }
//
//    public void reset() {
//        this.lastOp = Operation.NO_OP;
//        this.left = 0.0;
//    }


}
