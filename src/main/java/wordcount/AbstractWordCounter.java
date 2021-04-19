package wordcount;

import java.util.HashSet;
import java.util.Set;

public class AbstractWordCounter implements IWordCounter {

    @Override
    public int count(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        int count = 0;
        final String[] parts = splitToWords(inputText);
        for (final String part : parts) {
            if (isWord(part)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countUnique(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        final Set<String> unique = new HashSet<>();
        final String[] parts = splitToWords(inputText);
        for (final String part : parts) {
            if (isWord(part)) {
                unique.add(part);
            }
        }
        return unique.size();
    }

    protected boolean isWord(final String part) {
        if (part.isEmpty()) return false;
        for (int i = 0; i < part.length(); i++) {
            final char character = part.charAt(i);
            if (!Character.isLowerCase(character) && !Character.isUpperCase(character)) {
                return false;
            }
        }
        return true;
    }

    protected String[] splitToWords(String input) {
        return input.split("[\\s.-]");
    }
}
