package sk.sloboda.wordcount.validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static sk.sloboda.wordcount.common.Constants.WORD_REGEX;

public class WordValidatorImpl implements WordValidator {

    private List<String> stopWords;

    /**
     * Initialize validator with predefined stop words
     */
    public WordValidatorImpl() {
        stopWords = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("input/stopwords.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                stopWords.add(line.toLowerCase());
            }
        } catch (IOException e) {
            System.err.printf("Unable to load stopwords from file cause: %s.", e.getCause());
        }
    }

    @Override
    public boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        return (!stopWords.contains(word.toLowerCase()) && word.matches(WORD_REGEX));
    }
}
