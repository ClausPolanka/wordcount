package wordcounter;

import stopwords.Stopwords;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class WordCounterUtils {
    public static final String WHITESPACE = " ";

    private WordCounterUtils() {
        //private access
    }

    public static List<String> retrieveWordsFromUserInput(String input) {
        List<String> words = Arrays.asList(input.split(WHITESPACE));
        return words.stream()
                .filter(WordCounterUtils::isCountable)
                .collect(toList());
    }

    public static boolean isCountable(String word) {
        return !Stopwords.getStopwords().contains(word);
    }
}
