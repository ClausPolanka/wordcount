package com.ableneo.erste.wordcount.counter;

import com.ableneo.erste.wordcount.filter.StopWordsFilter;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCounter {

    private static final String WORD_SPLITTING_PATTERN = "([a-zA-Z-.]+)";

    private final StopWordsFilter stopWordsFilter;
    private final HashSet<String> uniqueWords;

    public WordCounter(StopWordsFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
        this.uniqueWords = new HashSet<>();
    }

    public CounterResult count(InputStream inputStream) {
        if (inputStream == null) {
            return new CounterResult(0, 0);
        }

        Scanner scanner = new Scanner(inputStream);
        int counter = 0;

        while (scanner.hasNextLine()) {

            List<String> tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(token -> token.endsWith(".") ? token.substring(0, token.length() - 1) : token)
                    .collect(Collectors.toList());

            tokens = tokens.stream()
                    .flatMap(token -> Arrays.stream(token.split("-")))
                    .collect(Collectors.toList());

            List<String> words = tokens.stream()
                    .filter(token -> token.matches(WORD_SPLITTING_PATTERN))
                    .filter(token -> !stopWordsFilter.isStopWord(token))
                    .collect(Collectors.toList());

            counter += words.size();
            uniqueWords.addAll(words);
        }

        return new CounterResult(counter, uniqueWords.size());
    }
}
