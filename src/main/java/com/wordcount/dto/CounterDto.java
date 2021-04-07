package com.wordcount.dto;

public class CounterDto {

    private final long numberOfWords;
    private final long numberOfUniqueWords;

    public CounterDto(long numberOfWords, long numberOfUniqueWords) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public long getNumberOfWords() {
        return numberOfWords;
    }

    public long getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }
}
