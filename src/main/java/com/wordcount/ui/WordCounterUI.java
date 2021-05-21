package com.wordcount.ui;

import com.wordcount.WordCounter;
import com.wordcount.WordCounterResult;

public class WordCounterUI {
    public final static String INTRO_TEXT = "Enter Text: ";

    private final WordCounter wordCounter;
    private final OutputInterface outputInterface;
    private final InputInterface inputInterface;

    public WordCounterUI(WordCounter wordCounter, OutputInterface outputInterface, InputInterface inputInterface) {
        this.wordCounter = wordCounter;
        this.outputInterface = outputInterface;
        this.inputInterface = inputInterface;
    }

    public void countWords() {
        if (inputInterface.getInputType() == InputType.MANUAL) {
            outputInterface.print(INTRO_TEXT);
        }
        String userInput = inputInterface.getInput();

        WordCounterResult countResult = wordCounter.countWords(userInput);
        outputInterface.println(countResult.printStats());
    }
}
