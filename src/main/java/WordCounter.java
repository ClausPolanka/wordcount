public class WordCounter {

    private final Evaluator evaluator;

    public WordCounter(final Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public int countWords(String sentence, String delimiter) {
        int result = 0;
        String[] words = sentence.split(delimiter);

        for (int i = 0; i < words.length; i++) {
            if (evaluator.evaluate(words[i])) {
                result++;
            }
        }
        return result;
    }
}
