package wordcounter.counter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private static final String WORD_REGEX = "[a-zA-Z]+";
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWordsIn(String text) {
        String[] candidates = text.trim().split(" ");
        List<String> result = Arrays.stream(candidates)
                .filter(w -> WORD_PATTERN.matcher(w).matches() && !stopWords.contains(w))
                .collect(Collectors.toList());
        return result.size();
    }
}
