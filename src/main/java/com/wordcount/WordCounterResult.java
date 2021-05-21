package com.wordcount;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.function.Function.identity;

public class WordCounterResult {
    public final static String NUMBER_OF_WORDS = "Number of words:";
    public final static String UNIQUE_WORDS = "unique:";
    public final static String AVERAGE_WORD = "average word length:";
    public final static String INDEX = "Index:";

    private final int allWordsCount;
    private final double averageWordLength;
    private final Set<String> uniqueWords;

    public WordCounterResult(int allWordsCount, Set<String> uniqueWords, double averageWordLength) {
        this.allWordsCount = allWordsCount;
        this.uniqueWords = uniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public int getAllWordsCount() {
        return allWordsCount;
    }

    public int getUniqueWordsCount() {
        return uniqueWords.size();
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public String printStats() {
        return format("%s %d, %s %d; %s %.2f", NUMBER_OF_WORDS, allWordsCount, UNIQUE_WORDS, getUniqueWordsCount(), AVERAGE_WORD, averageWordLength);
    }

    public String printIndex() {
        String indexedWords = uniqueWords.stream().sorted(Comparator.comparing(identity(), String.CASE_INSENSITIVE_ORDER)).collect(Collectors.joining("\n"));
        return format("%s\n%s", INDEX, indexedWords);
    }

    public static WordCounterResult of(int allWordsCount, Set<String> uniqueWords, double averageWordLength) {
        return new WordCounterResult(allWordsCount, uniqueWords, averageWordLength);
    }
}
