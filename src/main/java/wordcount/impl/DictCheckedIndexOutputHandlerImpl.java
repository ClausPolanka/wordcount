package wordcount.impl;

import wordcount.IDictionary;
import wordcount.IWordCounter;

public class DictCheckedIndexOutputHandlerImpl extends OutputHandlerImpl {

    private final IDictionary dictionary;

    public DictCheckedIndexOutputHandlerImpl(IWordCounter wordCounter, IDictionary dictionary) {
        super(wordCounter);
        this.dictionary = dictionary;
    }

    @Override
    public void printOutput(final String inputText) {
        super.printOutput(inputText);
        System.out.println("Index:");
        wordCounter.getIndex(inputText)
                .stream()
                .map(word -> word + (dictionary.contains(word) ? "" : "*"))
                .forEach(System.out::println);
    }
}
