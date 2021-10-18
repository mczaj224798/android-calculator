package com.example.calculator;

import android.util.Log;

import org.mariuszgromada.math.mxparser.Expression;

import javax.sql.StatementEvent;

public class CalculatorEngine {

    private final String CALC_ENG = "CalculatorEngine";

    private enum States {
        LEFT, OP, RIGHT
    }

    public enum Operation {
        ADD, SUB, DIV, MUL, NO_OP
    }

    private Double left, right, res;
    private Operation lastOp;
    private States state;

    public CalculatorEngine() {
        this.left = 0.0;
        this.right = 0.0;
        this.lastOp = Operation.NO_OP;
        this.state = States.LEFT;
    };

    public Double getResult() {
        return this.left;
    }

    public void add(Double value){
        Log.wtf("CALC", "Add " + this.left + " and " + value);
        this.left = this.left + value;
        this.lastOp = Operation.ADD;
    }

    public void sub(Double value){
        Log.wtf("CALC", "Sub " + this.left + " and " + value);
        this.left = this.left - value;
        this.lastOp = Operation.SUB;
    }
    public void mul(Double value){
        Log.wtf("CALC", "Mul " + this.left + " and " + value);
        if (this.lastOp.equals(Operation.NO_OP)) {
            this.lastOp = Operation.MUL;
//        } else {
           this.left = this.left * value;
           this.lastOp = Operation.MUL;
//        }
    }

    public void div(Double value){
        Log.wtf("CALC", "Div " + this.left + " and " + value);
        this.left = this.left / value;
        this.lastOp = Operation.DIV;
    }

    public void setOp(Operation op) {
        this.lastOp = op;
    }

    public void calculate(Double value){
        switch (this.lastOp) {
            case ADD:
                this.add(value);
                break;
            case SUB:
                this.sub(value);
                break;
            case MUL:
                this.mul(value);
                break;
            case DIV:
                break;
            case NO_OP:
        }
//        this.lastOp = Operation.NO_OP;
    }

    public void reset() {
        this.lastOp = Operation.NO_OP;
        this.left = 0.0;
    }


}
