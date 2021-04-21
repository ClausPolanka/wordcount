package counter;

import evaluator.WordEvaluator;

public class WordCounter {

    private final WordEvaluator evaluator;

    public WordCounter(final WordEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public int countWords(final String sentence, final String delimiter) {
        if (sentence == null || delimiter == null) {
            return 0;
        }

        int result = 0;
        final String[] words = sentence.split(delimiter);

        for (String word : words) {
            if (evaluator.evaluate(word)) {
                result++;
            }
        }
        return result;
    }
}
