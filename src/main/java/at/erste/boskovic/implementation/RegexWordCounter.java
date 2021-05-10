package at.erste.boskovic.implementation;

import at.erste.boskovic.WordCounter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public final class RegexWordCounter implements WordCounter {

    private final String wordDefinitionRegex;
    private final String spaceBetweenWordsDefinitionRegex;
    private InputStream stopWordsInputStream;
    private List<String> stopWords = new ArrayList<>();


    public RegexWordCounter(final String wordDefinitionRegex, final String spaceBetweenWordsDefinitionRegex) {
        this.wordDefinitionRegex = wordDefinitionRegex;
        this.spaceBetweenWordsDefinitionRegex = spaceBetweenWordsDefinitionRegex;
    }

    public RegexWordCounter(String wordDefinitionRegex, String spaceBetweenWordsDefinitionRegex, InputStream stopWordInputStream) {
        this.wordDefinitionRegex = wordDefinitionRegex;
        this.spaceBetweenWordsDefinitionRegex = spaceBetweenWordsDefinitionRegex;
        this.stopWordsInputStream = stopWordInputStream;
        Scanner myReader = new Scanner(stopWordsInputStream);

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            stopWords.add(line);
        }
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
        return potentialWord.matches(wordDefinitionRegex) && !isStopWord(potentialWord);
    }

    private long countWords(String[] potentialWords){
        return Stream.of(potentialWords).filter(this::isWord).count();
    }

    private boolean isStopWord(String potentialWord){
        return stopWords.stream().anyMatch(sw -> sw.equals(potentialWord));
    }
}
