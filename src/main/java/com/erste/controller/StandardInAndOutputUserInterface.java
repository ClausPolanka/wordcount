package com.erste.controller;

import com.erste.WordCounterApplication;
import com.erste.service.WordCountManager;

import java.util.Scanner;

public class StandardInAndOutputUserInterface implements UserInterface{

    WordCountManager wordCountManager;

    public StandardInAndOutputUserInterface(WordCountManager wordCountManager) {
        this.wordCountManager = wordCountManager;
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while ("Quit".equals(input)) {
            wordCountManager.countWords(input.split(" "));
        }
    }

    @Override
    public void getOutput() {

    }
}
