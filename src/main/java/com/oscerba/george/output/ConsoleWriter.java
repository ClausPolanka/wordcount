package com.oscerba.george.output;

import com.oscerba.george.pojo.WordStatistics;

public class ConsoleWriter implements Writeable {

    private final WordStatistics wordStatistics;
    private final boolean indexEnabled;

    public ConsoleWriter(WordStatistics wordStatistics, boolean indexEnabled) {
        this.wordStatistics = wordStatistics;
        this.indexEnabled = indexEnabled;
    }

    @Override
    public void write() {
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f\n",wordStatistics.getCount(), wordStatistics.getUniqueCount(), wordStatistics.getLengthAvg());
        if (indexEnabled){
            System.out.println("Index:");
            wordStatistics.getWords().forEach(System.out::println);
        }
    }
}
