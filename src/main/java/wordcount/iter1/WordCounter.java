package wordcount.iter1;

import java.util.Arrays;

public class WordCounter {
    private static final String IS_A_WORD = "[a-zA-Z]+";

    public long count(String inputString) {
        String[] possibleWords = inputString.split("[ ]+");
        return Arrays.stream(possibleWords)
                .filter(w -> w.matches(IS_A_WORD))
                .count();
    }
}
