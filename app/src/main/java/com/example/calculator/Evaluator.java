package com.example.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evaluator {
    private final String ADD = "+";
    private final String SUB = "-";
    private final String DIV = "\\";
    private final String MUL ="*";
    private final List<String> operators = new ArrayList(Arrays.asList(ADD, SUB, DIV, MUL));

    public Evaluator() {};

    public Double evaluate(String string) {
        Double result = 0.0;

        String[] div = string.split("(\\d*\\.?\\d+)|([+-/*])");

        for(int i =2; i< div.length; i=i+2) {
            switch (div[i-1]) {

            }
        }
        return result;
    }

    private boolean isOperator(String text) {
        boolean result = false;
        for(String operator : operators) {
            if(text.equals(operator)) {
                result = true;
            }
        }
        return  result;
    }
}
