package root.wordcounter;

import root.wordcounter.data.CountingResult;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    public static final String WORD_SEPARATOR_REGEX = "\\s+";

    //hyphen between characters and point at the end optional
    public static final Pattern WORD_REGEX = Pattern.compile("[a-zA-Z]+-?[a-zA-Z]+\\.?");

    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public CountingResult countWords(String text) {
        final String[] wordCandidates = text.split(WORD_SEPARATOR_REGEX);

        final List<String> words = Arrays.stream(wordCandidates)
                .filter(word -> WORD_REGEX.matcher(word).matches())
                .filter(word -> !this.stopWords.contains(word))
                .collect(Collectors.toList());

        final Set<String> uniqueWords = new HashSet<>(words);

        final List<String> index = new ArrayList<>(uniqueWords);
        index.sort(String::compareToIgnoreCase);

        return new CountingResult(words.size(), uniqueWords.size(), getAverage(words), index);
    }

    private double getAverage(List<String> words) {
        final int totalWordLength = words.stream().map(String::length).reduce(Integer::sum).orElse(0);
        final int numWords = words.size();

        if(numWords > 0) {
            return  ((double) totalWordLength) / numWords;
        }
        return 0;
    }
}
