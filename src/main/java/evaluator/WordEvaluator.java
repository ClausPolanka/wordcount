package evaluator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class WordEvaluator {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");
    private final Set<String> stopWords;

    public WordEvaluator() {
        this.stopWords = new HashSet<>();
    }

    public WordEvaluator(final Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    /**
     * evaluate a <strong>word</strong> whether it's valid or not
     * a word is valid iff it contains letters, no numbers and no spaces
     *
     * @param input the <strong>word</strong> to evaluate
     * @return true if it's only a word, false otherwise
     */
    public boolean evaluate(final String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        if (this.stopWords.contains(input)) {
            return false;
        }
        return pattern.matcher(input).matches();
    }
}
