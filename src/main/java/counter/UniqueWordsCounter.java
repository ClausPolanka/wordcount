package counter;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordsCounter {

    private Map<String, Integer> words;

    public UniqueWordsCounter() {
        this.words = new HashMap<>();
    }

    public Map<String, Integer> countUniqueWords(final String sentence) {
        String[] wordsInSentence = sentence.trim().split("[\\S\\-]");
        if (wordsInSentence.length == 0) {
            return new HashMap<>();
        }

        for (String word : wordsInSentence) {
            Integer count = this.words.get(word);
            if (count == null) {
                words.put(word, 1);
            } else {
                words.put(word, count++);
            }
        }

        return words;
    }
}
