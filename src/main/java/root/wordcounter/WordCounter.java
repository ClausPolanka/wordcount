package root.wordcounter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        String[] wordCandidates = text.split(WORD_SEPARATOR_REGEX);
        Set<String> uniqueWords;

        List<String> words = Arrays.stream(wordCandidates).filter(word -> WORD_REGEX.matcher(word).matches())
                .filter(word -> !this.stopWords.contains(word))
                .collect(Collectors.toList());

        uniqueWords = new HashSet<>(words);

        int totalWordLength = words.stream().map(String::length).reduce(Integer::sum).orElse(0);
        int numWords = words.size();
        double averageWordLen = 0;

        if(numWords > 0) {
            averageWordLen = ((double) totalWordLength) / numWords;
        }

        return new CountingResult(numWords, uniqueWords.size(), averageWordLen);
    }
}
