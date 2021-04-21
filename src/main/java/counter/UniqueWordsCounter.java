package counter;

import parser.InputParser;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordsCounter {

    private Map<String, Integer> words;

    public UniqueWordsCounter() {
        this.words = new HashMap<>();
    }

    public int countUniqueWords(final String sentence) {
        final String[] wordsInSentence = InputParser.extractWords(sentence);
        if (wordsInSentence.length == 0) {
            return 0;
        }

        for (String word : wordsInSentence) {
            Integer count = words.get(InputParser.cleanWord(word));
            if (count == null) {
                words.put(word, 1);
            } else {
                words.put(word, count + 1);
            }
        }

        return words.size();
    }
}
