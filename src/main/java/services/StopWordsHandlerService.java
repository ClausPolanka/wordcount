package services;

import exceptions.FilenameNotProvidedException;
import unit.WordFileReader;

import java.util.List;
import java.util.logging.Logger;

public class StopWordsHandlerService {

    private Logger LOGGER = Logger.getLogger(StopWordsHandlerService.class.getName());

    private static final String FILENAME_STOPWORDS = "stopwords.txt";

    private List<String> stopWords;
    private WordFileReader wordFileReader;

    public StopWordsHandlerService(){
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
