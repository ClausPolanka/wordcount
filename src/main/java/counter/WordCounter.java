package counter;

import evaluator.WordEvaluator;

public class WordCounter {

    private final WordEvaluator evaluator;

    public WordCounter(final WordEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public int countWords(final String sentence) {
        if (sentence == null) {
            return 0;
        }

        int result = 0;
        final String[] words = sentence.split("[\\S\\-]");

        for (String word : words) {
            if (evaluator.evaluate(word)) {
                result++;
            }
        }
        return result;
    }
}
