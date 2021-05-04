package sk.sloboda.wordcount.common;

import java.util.Arrays;

import sk.sloboda.wordcount.validator.WordValidator;

public class WordCounterImpl implements WordCounter {

    private WordValidator validator;

    public WordCounterImpl(WordValidator validator) {
        this.validator = validator;
    }

    @Override
    public long countWords(String input) {
        if (input == null || input.isEmpty()) return 0;

        // replace dots in sentences with space
        input = input.replaceAll("\\.", " ");

        String[] split = input.split("\\s+");
        return Arrays.stream(split).filter(validator::isValidWord).count();
    }
}
