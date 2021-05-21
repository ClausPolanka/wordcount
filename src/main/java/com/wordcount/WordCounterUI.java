package com.wordcount;

import java.util.function.Supplier;

public class WordCounterUI {
    private final static String INTRO_TEXT = "Enter Text: ";
    private final static String RESULT_TEXT = "Number of words: ";

    private final WordCounter wordCounter;
    private final OutputInterface outputInterface;
    private final Supplier<String> userInputSupplier;

    public WordCounterUI(WordCounter wordCounter, OutputInterface outputInterface, Supplier<String> userInputSupplier) {
        this.wordCounter = wordCounter;
        this.outputInterface = outputInterface;
        this.userInputSupplier = userInputSupplier;
    }

    void countWords() {
        outputInterface.print(INTRO_TEXT);
        String userInput = userInputSupplier.get();

        int countOfWords = wordCounter.countWords(userInput);
        outputInterface.println(RESULT_TEXT + countOfWords);
    }
}
