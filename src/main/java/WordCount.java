import java.io.FileNotFoundException;
import java.util.List;

public class WordCount {

    private static final String WORD_REGEX = "[a-zA-Z]+";

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public int getNumberOfWords(String text) throws FileNotFoundException, FormatException {
        return getNumberOfWords(text, false);
    }

    public int getNumberOfWords(String text, boolean excludeStopWords) throws FileNotFoundException, FormatException {

        if (text == null || text.isEmpty()){
            return 0;
        }

        int count = 0;
        FileOpener fileOpener = new FileOpener();
        List<String> lines = fileOpener.openTextFileFromResources(STOP_WORDS_FILE_NAME);

        if (excludeStopWords) {
            for (String line : lines) {
                text = text.replaceAll(line, "");
            }
        }

        for (String word : text.split(" ")){
            if (isWord(word)) count++;
        }

        return count;
    }

    private boolean isWord(String word){
        return word.matches(WORD_REGEX);
    }
}