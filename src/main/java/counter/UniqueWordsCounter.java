package counter;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordsCounter {

    private Map<String, Integer> words;

    public UniqueWordsCounter() {
        this.words = new HashMap<>();
    }

    public Map<String, Integer> countUniqueWords(final String sentence) {
        if (sentence == null || sentence.trim().length() == 0) {
            return new HashMap<>();
        }
        String[] wordsInSentence = sentence.trim().split("[\\s\\-]+");
        if (wordsInSentence.length == 0) {
            return new HashMap<>();
        }

        for (String word : wordsInSentence) {
            if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            Integer count = words.get(word);
            if (count == null) {
                words.put(word, 1);
            } else {
                words.put(word, count + 1);
            }
        }

        return words;
    }
}
