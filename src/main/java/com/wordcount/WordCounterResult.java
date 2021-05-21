package com.wordcount;

import static java.lang.String.format;

public class WordCounterResult {
    public final static String NUMBER_OF_WORDS = "Number of words:";
    public final static String UNIQUE_WORDS = "unique:";
    public final static String AVERAGE_WORD = "average word length:";

    private final int allWordsCount;
    private final int uniqueWordsCount;
    private final double averageWordLength;

    public WordCounterResult(int allWordsCount, int uniqueWordsCount, double averageWordLength) {
        this.allWordsCount = allWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
        this.averageWordLength = averageWordLength;
    }

    public int getAllWordsCount() {
        return allWordsCount;
    }

    public int getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    @Override
    public String toString() {
        return format("%s %d, %s %d; %s %.2f", NUMBER_OF_WORDS, allWordsCount, UNIQUE_WORDS, uniqueWordsCount, AVERAGE_WORD, averageWordLength);
    }

    public static WordCounterResult of(int allWordsCount, int uniqueWordsCount, double averageWordLength) {
        return new WordCounterResult(allWordsCount, uniqueWordsCount, averageWordLength);
    }
}
