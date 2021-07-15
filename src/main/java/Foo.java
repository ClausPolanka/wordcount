import java.util.ArrayList;
import java.util.List;

public class Foo {
    private final String[] stopWords;

    public Foo() {
        this.stopWords = new String[]{};
    }

    public Foo(String[] stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String input) {
        String[] strings = input.split("\\s");

        strings = removeStopWords(strings);

        // check special chars within the word
        int nonWords = countNonWords(strings);

        return strings.length - nonWords;
    }

    private String[] removeStopWords(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word: words) {
            if (!isStopWord(word)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean isStopWord(String word) {
        boolean isStopWord = false;

        for (String stopWord: stopWords) {
            if (stopWord.equals(word)) {
                isStopWord = true;
                break;
            }
        }
        return isStopWord;
    }

    private int countNonWords(String[] strings) {
        int nonWords = 0;

        for (String word: strings) {
            if (isNonWord(word)) {
                nonWords ++;
            }
        }

        return nonWords;
    }

    private boolean isNonWord(String word) {
        String[] nonWordParts = word.split("\\W");
        if (nonWordParts.length > 1) {
            return true;
        }
        return false;
    }
}
