package wordcount.impl;

import wordcount.IWordCounter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounterStopWordsImpl extends AbstractWordCounter implements IWordCounter {

    protected static final Set<String> STOP_WORDS = new HashSet<>();

    public WordCounterStopWordsImpl(String filename) {
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
    protected boolean isWord(String part) {
        return super.isWord(part) && !STOP_WORDS.contains(part);
    }
}
