public class WordEvaluator implements Evaluator {
    @Override
    public boolean evaluate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return !containsNumbers(input);
    }

    private boolean containsNumbers(String string) {
        for (int i = 0; i < string.length(); i++) {
            return !Character.isLetter(string.charAt(i));
        }
        return false;
    }
}
