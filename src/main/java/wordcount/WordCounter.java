package wordcount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
    // single full-stop at the end is not causing word to be ignored
    private final static Pattern isAWordRegex = Pattern.compile("([a-zA-Z]+(-)?[a-zA-Z+]+|[a-zA-Z]+)(\\.)?");
    private final static Pattern wordSplitRegex = Pattern.compile("[\\s]+");

    private final WordCounterOptions options;

    public WordCounter(WordCounterOptions options) {
        this.options = options;
    }

    public WordCounterOutput calculateOutput(String inputString) {
        List<String> possibleWords = Arrays.asList(wordSplitRegex.split(inputString));

        List<String> matchedWords = possibleWords.stream()
                .filter(w -> isAWordRegex.matcher(w).matches())
                .filter(w -> !options.getStopWords().contains(w))
                .collect(Collectors.toList());

        long wordCount = matchedWords.size();
        Set<String> uniqueWords = new HashSet<>(matchedWords);

        double average = calculateAverage(matchedWords);

        return new WordCounterOutput()
                .setUniqueCount(uniqueWords.size())
                .setWordCount(wordCount)
                .setWordAverage(average);
    }

    /**
     * @return 0.0 if there are no matched words. Otherwise total normalized character count divided by matchedWord count
     */
    private double calculateAverage(List<String> matchedWords) {
        if (matchedWords.isEmpty()) {
            return 0.0;
        }

        int totalCharacterCount = matchedWords
                .stream()
                .map(this::normalizeForAverage)
                .mapToInt(String::length)
                .sum();

        double size = matchedWords.size();
        double average = totalCharacterCount / size;
        return Math.round(average * 100.0) / 100.0d;
    }

    /**
     * normalizes the matchedWord for the average
     *
     *
     * e.g: "full." will be returned as "full"
     *
     * @param matchedWord a matched matchedWord
     * @return the matchedWord without the characters to be included in the average
     */
    private String normalizeForAverage(String matchedWord) {
        if (matchedWord.endsWith(".")) {
            matchedWord = matchedWord.substring(0, matchedWord.length() - 1);
        }
        return matchedWord;
    }
}
