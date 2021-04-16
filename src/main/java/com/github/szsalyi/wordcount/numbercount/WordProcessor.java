package com.github.szsalyi.wordcount.numbercount;

import java.util.List;

public class WordProcessor {

    private UserIO userIO;
    private ContentSplit contentSplit;
    private WordCounter wordCounter;

    public WordProcessor(UserIO userIO) {
        this.userIO = userIO;
        this.contentSplit = new ContentSplit();
        this.wordCounter = new WordCounter();
    }

    public void count() {
        String userInput = userIO.userInput();

        List<String> splitInput = contentSplit.stringList(userInput);

        userIO.printResult(wordCounter.count(splitInput));
    }
}
