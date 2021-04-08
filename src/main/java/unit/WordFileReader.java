package unit;

import exceptions.FilenameNotProvidedException;
import exceptions.NotValidWordStringException;
import services.WordSplitService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WordFileReader {

    private Logger LOGGER = Logger.getLogger(WordFileReader.class.getName());

    private List<String> words;
    private WordSplitService wordSplitService;

    public WordFileReader() {
        words = new ArrayList<>();
        wordSplitService = new WordSplitService();
    }

    public List<String> loadWords(String filename) throws FilenameNotProvidedException {
        if(filename == null || filename.isEmpty()){
            throw new FilenameNotProvidedException();
        }
        try {
            File file = loadFileResource(filename);
            return loadWordsFromFile(file);

        } catch (URISyntaxException e) {
            LOGGER.warning("Error occurred trying to load stopwords from file: "+ e.getMessage());
        }
        return null;
    }

    private List<String> loadWordsFromFile(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for(String line: lines){
                words.addAll(wordSplitService.splitWordsFromString(line));
            }

        } catch (IOException | NotValidWordStringException e) {
            LOGGER.warning("Error occurred trying to read file '"+file.getAbsolutePath()+"': "+ e.getMessage());
        }
        return words;
    }

    private File loadFileResource(String filename) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("file not found: " + filename);
        } else {
            return new File(resource.toURI());
        }
    }
}
