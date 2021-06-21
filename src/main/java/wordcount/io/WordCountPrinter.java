package wordcount.io;

import wordcount.domain.WordCounter;

public class WordCountPrinter {

    private WordCountPrinter() {
    }

    public static void printCount(WordCounter.CountResult count) {
        System.out.print(String.format("Number of words: %s, unique is: %s", count.total(), count.unique()));
    }

}
