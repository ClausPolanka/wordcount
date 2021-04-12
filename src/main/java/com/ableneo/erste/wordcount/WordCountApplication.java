package com.ableneo.erste.wordcount;

public class WordCountApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        System.out.println("Enter text: ");
        String input = System.console().readLine();
        int count = wordCounter.count(input);
        System.out.println("Enter text: " + count + "\\n");
    }
}
