package com.ableneo.erste.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountApplication {

    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();

        System.out.println("Enter text: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int count = wordCounter.count(input);
        System.out.println("Number of words: " + count);
    }
}
