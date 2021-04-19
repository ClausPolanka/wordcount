package wordcount;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounterImpl implements IWordCounter {

    private static final Set<String> STOP_WORDS = new HashSet<>();

    public WordCounterImpl() {
    }

    public WordCounterImpl(String filename) {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename)) {
            if (is == null) {
                throw new RuntimeException("Resource not found");
            }
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (isWord(line)) {
                    STOP_WORDS.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        int count = 0;
        final String[] parts = splitToWords(inputText);
        for (final String part : parts) {
            if (isWord(part) && !STOP_WORDS.contains(part)) {
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
            if (isWord(part) && !STOP_WORDS.contains(part)) {
                unique.add(part);
            }
        }
        return unique.size();
    }

    private String[] splitToWords(String input) {
        return input.split("[\\s.-]");
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
