import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterService {
    private final String[] stopWords;
    private int uniqueWordCount = 0;
    private int totalWordCount = 0;

    public WordCounterService() {
        this.stopWords = new String[]{};
    }

    public WordCounterService(String[] stopWords) {
        this.stopWords = stopWords;
    }

    public void countWords(String input) {
        if (emptyInput(input)) {
            return;
        }

        String[] strings = input.split("\\s");
        strings = removeWrongWordsAndStripSymbols(strings);
        totalWordCount = strings.length;

        HashSet<String> uniqueWordSet = new HashSet<>(Arrays.asList(strings));
        uniqueWordCount = uniqueWordSet.size();
    }

    private boolean emptyInput(String input) {
        return input == null || input.trim().equals("");
    }

    private String[] removeWrongWordsAndStripSymbols(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word: words) {
            if (isWord(word) && !isStopWord(word)) {
                result.add(stripSymbols(word));
            }
        }

        return result.toArray(new String[0]);
    }

    private String stripSymbols(String word) {
        return word.replaceAll("[\\.,:;!?]", "");
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

    private boolean isWord(String word) {
        Pattern pattern = Pattern.compile("[a-zA-Z,:\\.;?!\\-]+");
        Matcher result = pattern.matcher(word);

        return result.matches();
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    public int getTotalWordCount() {
        return totalWordCount;
    }
}
