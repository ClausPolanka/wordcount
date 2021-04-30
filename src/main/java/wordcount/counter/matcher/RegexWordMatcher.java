package wordcount.counter.matcher;

import java.util.regex.Pattern;

/**
 * RegexWordMatcher checks if word matches some regular expression
 */
public class RegexWordMatcher implements WordMatcher {

    private static final String DEFAULT_WORDS_MATCH_REGEX = "[a-zA-Z]+";

    private final Pattern wordsMatchPattern;

    /**
     * Default constructor with regular expression, which checks, if word is unlimited sequence of characters
     */
    public RegexWordMatcher() {
        this(DEFAULT_WORDS_MATCH_REGEX);
    }

    /**
     * Constructor in order to create RegexWordMatcher with customly defined regular expression.
     * wordsDelimiterRegex is a regex, which will be used to check if word matches.
     * wordsDelimiterRegex should not be null
     */
    public RegexWordMatcher(String wordsMatchRegex) {
        if(wordsMatchRegex == null){
            throw new IllegalArgumentException("Words Match pattern should not be null!");
        }
        //In order to check if wordsMatchRegex meets regex rules
        wordsMatchPattern = Pattern.compile(wordsMatchRegex);
    }

    /**
     * checks if word matches given regex
     */
    @Override
    public boolean isWordMatch(String word) {
        if(word == null){
            return false;
        }
        return word.matches(wordsMatchPattern.pattern());
    }

}
