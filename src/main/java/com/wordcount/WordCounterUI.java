package com.wordcount;

public class WordCounterUI {
    public final static String INTRO_TEXT = "Enter Text: ";
    public final static String RESULT_TEXT = "Number of words: ";

    private final WordCounter wordCounter;
    private final OutputInterface outputInterface;
    private final InputInterface inputInterface;

    public WordCounterUI(WordCounter wordCounter, OutputInterface outputInterface, InputInterface inputInterface) {
        this.wordCounter = wordCounter;
        this.outputInterface = outputInterface;
        this.inputInterface = inputInterface;
    }

    void countWords() {
        outputInterface.print(INTRO_TEXT);
        String userInput = inputInterface.getInput();

        int countOfWords = wordCounter.countWords(userInput);
        outputInterface.println(RESULT_TEXT + countOfWords);
    }
}
