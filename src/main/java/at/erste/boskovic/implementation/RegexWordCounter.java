package at.erste.boskovic.implementation;

import at.erste.WordCounter;

import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class RegexWordCounter implements WordCounter {

    private String wordDefinitionRegex;
    private String spaceBetweenWordsDefinitionRegex;

    public RegexWordCounter(String wordDefinitionRegex, String spaceBetweenWordsDefinitionRegex) {
        this.wordDefinitionRegex = wordDefinitionRegex;
        this.spaceBetweenWordsDefinitionRegex = spaceBetweenWordsDefinitionRegex;
    }

    @Override
    public long countWords(String sentence) {
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
        return Stream.of(potentialWords).filter(potentialWord -> isWord(potentialWord)).count();
    }
}
