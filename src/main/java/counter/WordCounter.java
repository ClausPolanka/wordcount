package counter;


import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public int countWords(final String sentence) {
        if (sentence == null) {
            return 0;
        }

        int result = 0;
        final String[] words = sentence.split("[\\s\\-]+");

        for (String word : words) {
            if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            if (pattern.matcher(word).matches()) {
                result++;
            }
        }
        return result;
    }
}
