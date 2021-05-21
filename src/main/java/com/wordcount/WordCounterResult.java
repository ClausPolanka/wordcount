package com.wordcount;

import static java.lang.String.format;

public class WordCounterResult {
    public final static String NUMBER_OF_WORDS = "Number of words:";
    public final static String UNIQUE_WORDS = ", unique:";

    private final int allWordsCount;
    private final int uniqueWordsCount;

    public WordCounterResult(int allWordsCount, int uniqueWordsCount) {
        this.allWordsCount = allWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    public int getAllWordsCount() {
        return allWordsCount;
    }

    public int getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    @Override
    public String toString() {
        return format("%s %d%s %d", NUMBER_OF_WORDS, allWordsCount, UNIQUE_WORDS, uniqueWordsCount);
    }
}
