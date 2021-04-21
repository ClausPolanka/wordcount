package counter;


import parser.InputParser;

import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public int countWords(final String sentence) {
        if (sentence == null) {
            return 0;
        }

        int result = 0;
        final String[] words = InputParser.extractWords(sentence);

        for (String word : words) {
            if (pattern.matcher(InputParser.cleanWord(word)).matches()) {
                result++;
            }
        }
        return result;
    }
}
