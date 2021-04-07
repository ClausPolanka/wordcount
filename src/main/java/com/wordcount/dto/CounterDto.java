package com.wordcount.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CounterDto {

    private final long numberOfWords;
    private final long numberOfUniqueWords;
    private final BigDecimal averageWorldLength;

    public CounterDto(long numberOfWords, long numberOfUniqueWords, BigDecimal averageWorldLength) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
        this.averageWorldLength = averageWorldLength;
    }

    public long getNumberOfWords() {
        return numberOfWords;
    }

    public long getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }

    public BigDecimal getAverageWorldLength() {
        return averageWorldLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterDto that = (CounterDto) o;
        return numberOfWords == that.numberOfWords && numberOfUniqueWords == that.numberOfUniqueWords && Objects.equals(averageWorldLength, that.averageWorldLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfWords, numberOfUniqueWords, averageWorldLength);
    }

    @Override
    public String toString() {
        return "CounterDto{" +
                "numberOfWords=" + numberOfWords +
                ", numberOfUniqueWords=" + numberOfUniqueWords +
                ", averageWorldLength=" + averageWorldLength +
                '}';
    }
}
