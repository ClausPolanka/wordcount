package root.service.impl;

import root.service.WordCounterInterface;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DefaultWordCounter implements WordCounterInterface {

    public static final String WHITESPACE_REGEX = "\\s+";
    public static final Pattern WORD_REGEX = Pattern.compile("[a-zA-Z]+");


    @Override
    public long countWords(String text) {
        if(text != null) {
            String[] allWords = text.split(WHITESPACE_REGEX);
            return Arrays.stream(allWords).filter(word -> WORD_REGEX.matcher(word).matches()).count();
        }
        return 0;
    }
}
