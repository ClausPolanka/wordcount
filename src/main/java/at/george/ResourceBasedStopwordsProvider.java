package at.george;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static at.george.WordCountConstants.STOPWORDS_FILE;

public class ResourceBasedStopwordsProvider implements StopwordsProvider {
    @Override
    public List<String> retrieveStopwords() {
        URL stopwordsResource = WordCountApp.class.getClassLoader()
                .getResource(STOPWORDS_FILE);

        if (stopwordsResource == null) {
            //return delegate.count(line);
        }

        return loadStopwords(stopwordsResource);
    }

    private List<String> loadStopwords(URL stopwordsResource) {
        String stopwordsFilePath = stopwordsResource.getFile();

        List<String> stopwords;
        try {
            stopwords = Files.readAllLines(Paths.get(stopwordsFilePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            stopwords = new ArrayList<>();
        }

        return stopwords;
    }
}
