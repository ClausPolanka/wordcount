import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class StopWordsHandler {

    private Logger LOGGER = Logger.getLogger(StopWordsHandler.class.getName());

    private static final String FILENAME_STOPWORDS = "stopwords.txt";

    private Set<String> stopWords;

    public StopWordsHandler(){
        loadStopWordsFromFile();
    }

    private void loadStopWordsFromFile() {
        stopWords = new HashSet<>();

        try {
            File file = getStopWordsFileFromResource();
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            stopWords.addAll(lines);

        } catch (URISyntaxException e) {
            LOGGER.warning("Error occurred trying to load stopwords from file: "+ e.getMessage());
        } catch (IOException e) {
            LOGGER.warning("Error occurred trying to read stopwords: "+ e.getMessage());
        }
    }

    private File getStopWordsFileFromResource() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(StopWordsHandler.FILENAME_STOPWORDS);
        if (resource == null) {
            throw new IllegalArgumentException("file not found: " + StopWordsHandler.FILENAME_STOPWORDS);
        } else {
            return new File(resource.toURI());
        }
    }

    public boolean isStopword(String word){
        return stopWords.contains(word.toLowerCase());
    }
}
