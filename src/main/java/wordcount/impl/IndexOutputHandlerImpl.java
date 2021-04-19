package wordcount.impl;

import wordcount.IWordCounter;

public class IndexOutputHandlerImpl extends OutputHandlerImpl {

    public IndexOutputHandlerImpl(IWordCounter wordCounter) {
        super(wordCounter);
    }

    @Override
    public void printOutput(final String inputText) {
        super.printOutput(inputText);
        System.out.println("Index:");
        wordCounter.getIndex(inputText).forEach(System.out::println);
    }
}
