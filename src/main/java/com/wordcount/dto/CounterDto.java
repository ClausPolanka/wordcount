package com.wordcount.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterDto that = (CounterDto) o;
        return numberOfWords == that.numberOfWords && numberOfUniqueWords == that.numberOfUniqueWords;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfWords, numberOfUniqueWords);
    }

    @Override
    public String toString() {
        return "CounterDto{" +
                "numberOfWords=" + numberOfWords +
                ", numberOfUniqueWords=" + numberOfUniqueWords +
                '}';
    }
}
