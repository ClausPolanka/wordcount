package com.ableneo.erste.wordcount.counter;

public class CounterResult {

    private int total;
    private int unique;
    private double averageWordLength;

    public CounterResult(int total, int unique, double averageWordLength) {
        this.total = total;
        this.unique = unique;
        this.averageWordLength = averageWordLength;
    }

    public int getTotal() {
        return total;
    }

    public int getUnique() {
        return unique;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }
}
