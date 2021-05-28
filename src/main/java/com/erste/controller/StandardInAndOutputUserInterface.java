package com.erste.controller;

import com.erste.WordCounterApplication;
import com.erste.service.WordCountManager;

import java.util.Scanner;

public class StandardInAndOutputUserInterface implements UserInterface{

    WordCountManager wordCountManager;

    Integer wordCount;

    public StandardInAndOutputUserInterface(WordCountManager wordCountManager) {
        this.wordCountManager = wordCountManager;
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        wordCount = wordCountManager.countWords(input);
        scanner.close();
    }

    @Override
    public void getOutput() {
        System.out.println("Number of words: " + wordCount);
    }
}
