package wordcount.counter.delimiter;

import java.util.regex.Pattern;

/**
 * RegexSentenceSplitter splits sentence using regular expression
 */
public class RegexSentenceSplitter implements SentenceSplitter {

    private static final String DEFAULT_WORDS_DELIMITER_REGEX = "\\s+";

    private final Pattern wordsDelimiterPattern;

    /**
     * Default constructor for sentence splitting by spaces
     */
    public RegexSentenceSplitter() {
        this(DEFAULT_WORDS_DELIMITER_REGEX);
    }

    /**
     * Constructor in order to create RegexSentenceSplitter with customly defined regular expression.
     * wordsDelimiterRegex is a delimiter in form of regex, which should be used for sentence splitting
     * wordsDelimiterRegex should not be null
     */
    public RegexSentenceSplitter(String wordsDelimiterRegex) {
        if (wordsDelimiterRegex == null) {
            throw new IllegalArgumentException("Words delimiter should not be null!");
        }
        //In order to check if wordsDelimiterRegex meets regex rules
        this.wordsDelimiterPattern = Pattern.compile(wordsDelimiterRegex);
    }

    /**
     * splits sentence
     *
     * @param sentence should not be null
     * @return array of words after splitting
     */
    @Override
    public String[] splitSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence is null");
        }
        return sentence.split(wordsDelimiterPattern.pattern());
    }

}
