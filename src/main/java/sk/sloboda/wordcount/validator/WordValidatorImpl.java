package sk.sloboda.wordcount.validator;

import static sk.sloboda.wordcount.common.Constants.WORD_REGEX;

public class WordValidatorImpl implements WordValidator {

    @Override
    public boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        return word.matches(WORD_REGEX);
    }
}
