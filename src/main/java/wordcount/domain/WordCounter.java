package wordcount.domain;

import wordcount.error.WrappedException;
import wordcount.io.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter implements IWordCounter {

    @Override
    public long countWords(String textToCount, List<String> stopWordList) {
        if (textToCount == null) {
            throw new WrappedException(ErrorCode.TEXT_INPUT_IS_NULL.name());
        }

        if (textToCount.equals("")) {
            throw new WrappedException(ErrorCode.TEXT_SHOULD_NOT_BE_EMPTY.name());
        }

        String[] words = textToCount.split("\\s+");
        return Arrays
                .stream(words)
                .filter(this::isValid)
                .filter(toBeCompared-> doesNotContainStopwords(stopWordList,toBeCompared))
                .count();
    }

    public boolean isValid(String word) {
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        final Matcher matcher = p.matcher(word);
        return matcher.find();
    }

    public boolean doesNotContainStopwords(List<String> stopWords, String toBeCompared) {
        return !stopWords.contains(toBeCompared);
    }

}
