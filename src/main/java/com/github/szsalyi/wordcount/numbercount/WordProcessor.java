package com.github.szsalyi.wordcount.numbercount;

import java.util.List;

public class WordProcessor {

    private UserInterface userInterface;
    private ContentSplit contentSplit;
    private WordCounter wordCounter;

    public WordProcessor(UserInterface pUserInterface) {
        this.userInterface = pUserInterface;
        this.contentSplit = new ContentSplit();
        this.wordCounter = new WordCounter();
    }

    public long count() {
        String userInput = userInterface.userInput();

        List<String> splitInput = contentSplit.stringList(userInput);

        long wordCount = wordCounter.count(splitInput);

        return wordCount;
    }
}
