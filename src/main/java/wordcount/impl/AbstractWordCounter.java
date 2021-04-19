package wordcount.impl;

import wordcount.IWordCounter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AbstractWordCounter implements IWordCounter {

    @Override
    public int count(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        return extractWords(inputText).size();
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

    @Override
    public double averageLength(String inputText) {
        return new BigDecimal(
                extractWords(inputText).stream()
                        .mapToDouble(String::length)
                        .average()
                        .orElseThrow(() -> new RuntimeException("Unable to calculate average length"))
        ).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public List<String> getIndex(String inputText) {
        return extractWords(inputText).stream()
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }

    private List<String> extractWords(final String inputText) {
        final String[] parts = splitToWords(inputText);
        List<String> words = new ArrayList<>();
        for (final String part : parts) {
            if (isWord(part)) {
                words.add(part);
            }
        }
        return words;
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
