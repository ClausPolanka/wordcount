package wordcount.impl;

import wordcount.IWordCounter;

public class WordCounterAllowedDashImpl extends WordCounterStopWordsImpl implements IWordCounter {

    public WordCounterAllowedDashImpl(String filename) {
        super(filename);
    }

    @Override
    protected boolean isWord(final String part) {
        if (part.isEmpty()) return false;
        for (int i = 0; i < part.length(); i++) {
            final char character = part.charAt(i);
            if (!Character.isLowerCase(character) &&
                    !Character.isUpperCase(character) &&
                    !Character.toString(character).equals("-")) {
                return false;
            }
        }
        return !STOP_WORDS.contains(part);
    }

    @Override
    protected String[] splitToWords(String input) {
        return input.split("[\\s.]");
    }
}
