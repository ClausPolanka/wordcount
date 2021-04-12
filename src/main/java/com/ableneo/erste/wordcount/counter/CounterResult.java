package com.ableneo.erste.wordcount.counter;

import java.util.Set;

public class CounterResult {

    private int total;
    private int unique;
    private double averageWordLength;
    private Set<String> uniqueWords;

    public CounterResult(int total, int unique, Set<String> uniqueWords, double averageWordLength) {
        this.total = total;
        this.unique = unique;
        this.uniqueWords = uniqueWords;
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

    public Set<String> getUniqueWords() {
        return uniqueWords;
    }
}
