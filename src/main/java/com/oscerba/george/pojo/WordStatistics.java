package com.oscerba.george.pojo;

import java.util.List;

public class WordStatistics {

    private final List<String> words;
    private final long count;
    private final long uniqueCount;
    private final double lengthAvg;

    public WordStatistics(List<String> words) {
        this.words = words;
        this.count = words.size();
        this.uniqueCount = words.stream().distinct().count();
        this.lengthAvg = words.stream().mapToInt(String::length).average().orElse(Double.NaN);
    }

    public long getCount() {
        return count;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }

    public double getLengthAvg() {
        return lengthAvg;
    }

    public List<String> getWords() {
        return words;
    }
}
