import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StopWords {

    private static final String FILENAME = "stopwords.txt";
    private static final String[] stopWords;

    static {
        InputStream resource = StopWords.class.getClassLoader().getResourceAsStream(FILENAME);
        if (resource != null) {
            List<String> stopWordsFromFile = new ArrayList<>();

            new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8)).lines().forEach(stopWordsFromFile::add);
            stopWords = stopWordsFromFile.toArray(new String[0]);
        } else {
            stopWords = new String[0];
        }
    }

    public String[] stopWordsAsList() {
        return stopWords;
    }
}
