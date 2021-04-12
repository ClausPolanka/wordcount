package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.stopwords.StopWordReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WordCountApplication {

    public static void main(String[] args) throws IOException {
        List<String> stopWords = new StopWordReader().readFromResourceFile("stopwords/stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWords);

        System.out.println("Enter text: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int count = wordCounter.count(input);
        System.out.println("Number of words: " + count);
    }
}
