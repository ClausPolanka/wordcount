package com.oscerba.george.processor;

import com.oscerba.george.pojo.Word;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordStatistics {

    private final List<Word> index;
    private final long count;
    private final long uniqueCount;
    private final double lengthAvg;
    private final long wordNoInDictCount;

    public WordStatistics(List<Word> words) {
        this.index = words.stream().sorted(Comparator.comparing(Word::getWord)).distinct().collect(Collectors.toList());
        this.count = words.size();
        this.uniqueCount = words.stream().map(Word::getWord).distinct().count();
        this.lengthAvg = words.stream().map(Word::getWord).mapToInt(String::length).average().orElse(Double.NaN);
        this.wordNoInDictCount = words.stream().filter(word -> !word.isPresentInDict()).count();
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

    public long getWordNoInDictCount(){
        return wordNoInDictCount;
    }

    public List<Word> getIndex() {
        return index;
    }
}
