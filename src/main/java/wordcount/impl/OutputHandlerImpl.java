package wordcount.impl;

import wordcount.IWordCounter;

public class OutputHandlerImpl implements IOutputHandler {

    protected final IWordCounter wordCounter;

    public OutputHandlerImpl(IWordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @Override
    public void printOutput(final String inputText) {
        System.out.println("Number of words: " + wordCounter.count(inputText) +
                ", unique: " + wordCounter.countUnique(inputText) +
                "; average word length: " + wordCounter.averageLength(inputText) + " characters");
    }
}
