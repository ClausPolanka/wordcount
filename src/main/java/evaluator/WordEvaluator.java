package evaluator;

import java.util.Set;

public class WordEvaluator implements Evaluator {

    private final Set<String> stopwords;

    public WordEvaluator() {
        this.stopwords = null;
    }

    public WordEvaluator(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    /**
     * evaluate a <strong>word</strong> whether it's valid or not
     * a word is valid iff it contains letters, no numbers and no spaces
     *
     * @param input the <strong>word</strong> to evaluate
     * @return true if it's only a word, false otherwise
     */
    @Override
    public boolean evaluate(final String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        if (this.stopwords != null && this.stopwords.contains(input)) {
            return false;
        }
        return !containsNumbers(input);
    }

    private boolean containsNumbers(final String word) {
        boolean flag;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            flag = !Character.isLetter(character);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
