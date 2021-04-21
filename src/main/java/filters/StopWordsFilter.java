package filters;

import java.util.HashSet;
import java.util.Set;

public class StopWordsFilter {

    private Set<String> stopWords;

    public StopWordsFilter(final Set<String> stopWords) {
        if (stopWords == null) {
            this.stopWords = new HashSet<>();
        } else {
            this.stopWords = stopWords;
        }
    }

    public String filter(final String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }
        final String[] words = sentence.split("[\\s]+");
        final StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!this.stopWords.contains(word)) {
                builder.append(word);
                builder.append(" ");
            }
        }
        String result = builder.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
