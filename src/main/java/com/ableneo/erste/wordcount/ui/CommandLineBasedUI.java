package com.ableneo.erste.wordcount.ui;

import com.ableneo.erste.wordcount.counter.CounterResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class CommandLineBasedUI implements UI {

    @Override
    public InputStream getInput() {
        System.out.print("Enter text: ");
        return new ByteArrayInputStream(new Scanner(System.in).nextLine().getBytes());
    }

    @Override
    public void writeResults(CounterResult result) {
        System.out.printf("Number of words: %d, unique: %d%n", result.getTotal(), result.getUnique());
    }
}
