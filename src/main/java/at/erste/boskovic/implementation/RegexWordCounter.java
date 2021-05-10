package at.erste.boskovic.implementation;

import at.erste.WordCounter;

import java.util.stream.Stream;

import static java.util.Objects.isNull;

public final class RegexWordCounter implements WordCounter {

    private final String wordDefinitionRegex;
    private final String spaceBetweenWordsDefinitionRegex;

    public RegexWordCounter(final String wordDefinitionRegex, final String spaceBetweenWordsDefinitionRegex) {
        this.wordDefinitionRegex = wordDefinitionRegex;
        this.spaceBetweenWordsDefinitionRegex = spaceBetweenWordsDefinitionRegex;
    }

    @Override
    final public long countWords(String sentence) {
        if (isNull(sentence)){
            return 0;
        }

        String[] potentialWords = splitPotentialWords(sentence);
        return countWords(potentialWords);
    }

    private String[] splitPotentialWords(String sentence){
        return sentence.split(spaceBetweenWordsDefinitionRegex);
    }

    private boolean isWord(String potentialWord){
        return potentialWord.matches(wordDefinitionRegex);
    }

    private long countWords(String[] potentialWords){
        return Stream.of(potentialWords).filter(this::isWord).count();
    }
}
