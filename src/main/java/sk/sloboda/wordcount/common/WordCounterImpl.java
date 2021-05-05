package sk.sloboda.wordcount.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import sk.sloboda.wordcount.model.WordCount;
import sk.sloboda.wordcount.validator.WordValidator;

public class WordCounterImpl implements WordCounter {

    private WordValidator validator;

    public WordCounterImpl(WordValidator validator) {
        this.validator = validator;
    }

    @Override
    public WordCount countWords(String input) {
        if (input == null || input.isEmpty()) return new WordCount();

        // replace dots in sentences with space
        input = input.replaceAll("\\.", " ");

        String[] split = input.split("\\s+");
        List<String> words =  Arrays.stream(split).filter(validator::isValidWord).collect(Collectors.toList());
        WordCount result = new WordCount(words.size(), new HashSet<>(words).size());
        if (words.size() > 0) {
            result.setAndRoundAverageLength(words.stream().mapToInt(String::length).average().getAsDouble());
        }
        return result;
    }
}
