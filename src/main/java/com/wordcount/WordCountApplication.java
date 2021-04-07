package com.wordcount;


import com.wordcount.counter.Counter;
import com.wordcount.io.InputOutputHelper;

public class WordCountApplication {

    public static void main(String args[]) {
        Counter counter = new Counter();
        InputOutputHelper inputOutputHelper = new InputOutputHelper();

        String input = inputOutputHelper.read(args);

        long numberOfWords = counter.countWords(input);
        System.out.println("Number of words: " + numberOfWords);
    }

}
