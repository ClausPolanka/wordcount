package com.oscerba.george.output;

import com.oscerba.george.pojo.WordStatistics;

public class ConsoleWriter implements Writeable {

    private final WordStatistics wordStatistics;

    public ConsoleWriter(WordStatistics wordStatistics) {
        this.wordStatistics = wordStatistics;
    }

    @Override
    public void write() {
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f",wordStatistics.getCount(), wordStatistics.getUniqueCount(), wordStatistics.getLengthAvg());
    }
}
