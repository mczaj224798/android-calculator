package com.example.calculator;

public class CalculatorMemory {
    private Double value;
    private boolean isSaved;

    CalculatorMemory() {
        this.isSaved = false;
    }

    public void setValue(Double value) {
        this.isSaved = true;
        this.value = value;
    }
    public double getValue() {
        return this.value;
    }

    public void reset() {
        isSaved = false;
    }

    public boolean isSaved() {
        return this.isSaved;
    }
}
