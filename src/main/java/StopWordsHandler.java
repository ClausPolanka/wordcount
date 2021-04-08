import java.util.List;
import java.util.logging.Logger;

public class StopWordsHandler {

    private Logger LOGGER = Logger.getLogger(StopWordsHandler.class.getName());

    private static final String FILENAME_STOPWORDS = "stopwords.txt";

    private List<String> stopWords;
    private WordFileReader wordFileReader;

    public StopWordsHandler(){
        wordFileReader = new WordFileReader();
        loadStopWordsFromFile();
    }

    private void loadStopWordsFromFile() {
        try {
            stopWords = wordFileReader.loadWords(FILENAME_STOPWORDS);
        } catch (FilenameNotProvidedException e) {
            LOGGER.warning("Error loading stop words due to missing filename");
        }
    }

    public boolean isStopword(String word){
        return stopWords.contains(word.toLowerCase());
    }
}
