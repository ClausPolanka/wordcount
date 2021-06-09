package root.wordcounter;

import root.wordcounter.StopWordsProviderInterface;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

    public static final String WHITESPACE_REGEX = "\\s+";
    public static final Pattern WORD_REGEX = Pattern.compile("[a-zA-Z]+");

    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public long countWords(String text) {
        String[] allWords = text.split(WHITESPACE_REGEX);
        return Arrays.stream(allWords).filter(word -> WORD_REGEX.matcher(word).matches() &&
                !this.stopWords.contains(word)).count();
    }
}
