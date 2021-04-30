package wordcounter;

import java.util.Arrays;
import java.util.List;

public final class WordCounterUtils {
    public static final String SPACE_CHAR_REGEX = " ";

    private WordCounterUtils() {
        //private access
    }

    public static List<String> retrieveWordsFromUserInput(String input) {
        return Arrays.asList(input.split(SPACE_CHAR_REGEX));
    }
}
