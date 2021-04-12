package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.filter.StopWordsFilter;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class WordCounter {

    private static final String WORD_SPLITTING_PATTERN = "([a-zA-Z]+)";

    private StopWordsFilter stopWordsFilter;

    public WordCounter(StopWordsFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
    }

    public int count(InputStream inputStream) {
        if (inputStream == null) {
            return 0;
        }

        Scanner scanner = new Scanner(inputStream);
        int counter = 0;

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split("\\s+");
            counter += Arrays.stream(tokens)
                    .filter(token -> token.matches(WORD_SPLITTING_PATTERN))
                    .filter(token -> !stopWordsFilter.isStopWord(token))
                    .count();
        }

        return counter;
    }
}
