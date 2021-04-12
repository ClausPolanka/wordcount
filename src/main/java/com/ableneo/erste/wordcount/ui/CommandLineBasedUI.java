package com.ableneo.erste.wordcount.ui;

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
    public void writeResults(int count) {
        System.out.println("Number of words: " + count);
    }
}
