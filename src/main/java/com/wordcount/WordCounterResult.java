package com.wordcount;

import java.util.Set;

import static java.lang.String.format;

public class WordCounterResult {
    public final static String NUMBER_OF_WORDS = "Number of words:";
    public final static String UNIQUE_WORDS = "unique:";
    public final static String AVERAGE_WORD = "average word length:";

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

    public String print() {
        return format("%s %d, %s %d; %s %.2f", NUMBER_OF_WORDS, allWordsCount, UNIQUE_WORDS, getUniqueWordsCount(), AVERAGE_WORD, averageWordLength);
    }

    public static WordCounterResult of(int allWordsCount, Set<String> uniqueWords, double averageWordLength) {
        return new WordCounterResult(allWordsCount, uniqueWords, averageWordLength);
    }
}
