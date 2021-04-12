package com.ableneo.erste.wordcount.ui;

import com.ableneo.erste.wordcount.counter.CounterResult;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbctractUI {

    public abstract InputStream getInput() throws IOException;

    public void writeResults(CounterResult result) {
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f %n",
                result.getTotal(), result.getUnique(), result.getAverageWordLength());
    }
}
