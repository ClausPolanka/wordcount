package wordcount.domain;

import wordcount.error.WrappedException;
import wordcount.io.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter implements IWordCounter {

    @Override
    public CountResult countWords(String textToCount, List<String> stopWordList) {
        if (textToCount == null) {
            throw new WrappedException(ErrorCode.TEXT_INPUT_IS_NULL.name());
        }

        if (textToCount.equals("")) {
            throw new WrappedException(ErrorCode.TEXT_SHOULD_NOT_BE_EMPTY.name());
        }

        String[] words = textToCount.split("\\s+");

        return  CountResult.of(computeTotal(stopWordList, words), computeUniqueCount(stopWordList, words));

    }

    private long computeUniqueCount(List<String> stopWordList, String[] words) {
        return Arrays
                .stream(words)
                .filter(this::isValid)
                .filter(toBeCompared -> doesNotContainStopwords(stopWordList, toBeCompared))
                .collect(Collectors.toSet())
                .size();
    }

    private long computeTotal(List<String> stopWordList, String[] words) {
        return Arrays
                .stream(words)
                .filter(this::isValid)
                .filter(toBeCompared -> doesNotContainStopwords(stopWordList, toBeCompared))
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

    public static class CountResult {
       private final Long total;
       private final Long unique;

        public Long total() {
            return total;
        }

        public Long unique() {
            return unique;
        }

        private CountResult(Long total, Long unique) {
            this.total = total;
            this.unique = unique;
        }

        public static CountResult of(Long total, Long unique) {
            return new CountResult(total, unique);
        }

    }


}
