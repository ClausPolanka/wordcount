import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterService {
    private final String[] stopWords;

    public WordCounterService() {
        this.stopWords = new String[]{};
    }

    public WordCounterService(String[] stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String input) {
        if (emptyInput(input)) {
            return 0;
        }

        String[] strings = input.split("\\s");
        strings = removeStopWords(strings);

        int nonWords = countNonWords(strings);
        return strings.length - nonWords;
    }

    private boolean emptyInput(String input) {
        return input == null || input.trim().equals("");
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
        Pattern pattern = Pattern.compile("[a-zA-Z,:\\.;?!]+");
        Matcher result = pattern.matcher(word);

        return !result.matches();
    }
}
