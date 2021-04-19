package wordcount;

public class WordCounterImpl implements IWordCounter {

    @Override
    public int count(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        int count = 0;
        final String[] parts = inputText.split("\\s");
        for (final String part : parts) {
            if (isWord(part)) {
                count++;
            }
        }
        return count;
    }

    private boolean isWord(final String part) {
        if (part.isEmpty()) return false;
        for (int i = 0; i < part.length(); i++) {
            final char character = part.charAt(i);
            if (!Character.isLowerCase(character) && !Character.isUpperCase(character)) {
                return false;
            }
        }
        return true;
    }
}
