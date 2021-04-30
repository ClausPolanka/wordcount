package com.oscerba.george.output;

import com.oscerba.george.processor.WordStatistics;

public class ConsoleWriter implements Writeable {

    private final WordStatistics wordStatistics;
    private final boolean indexEnabled;

    public ConsoleWriter(WordStatistics wordStatistics, boolean indexEnabled) {
        this.wordStatistics = wordStatistics;
        this.indexEnabled = indexEnabled;
    }

    @Override
    public void write() {
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f%n", wordStatistics.getCount(), wordStatistics.getUniqueCount(), wordStatistics.getLengthAvg());
        if (indexEnabled) {
            //TODO: condition based on configuration
            System.out.printf("Index (unknown: %d):%n", wordStatistics.getWordNoInDictCount());
            wordStatistics.getIndex().forEach(word -> {
                System.out.print(word.getWord());
                if(!word.isPresentInDict()){
                    System.out.print("*");
                }
                System.out.println();
            });
        }
    }
}
