package com.ableneo.erste.wordcount.counter;

public class CounterResult {

    private int total;
    private int unique;

    public CounterResult(int total, int unique) {
        this.total = total;
        this.unique = unique;
    }

    public int getTotal() {
        return total;
    }

    public int getUnique() {
        return unique;
    }
}
