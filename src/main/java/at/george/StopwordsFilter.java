package at.george;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static at.george.WordCountConstants.SPLIT_SYMBOL;
import static at.george.WordCountConstants.STOPWORDS_FILE;

public class StopwordsFilter implements Processor {

    private final Processor delegate;

    public StopwordsFilter(Processor delegate) {
        this.delegate = delegate;
    }


    @Override
    public long process(String line) {
        URL stopwordsResource = WordCountApp.class.getClassLoader()
                .getResource(STOPWORDS_FILE);

        if (stopwordsResource == null) {
            return delegate.process(line);
        }

        List<String> stopwords = loadStopwords(stopwordsResource);
        List<String> stopwordsTrimmed = trimStopwords(stopwords);
        line = filterStopwords(line, stopwordsTrimmed);

        return delegate.process(line);
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

    private List<String> trimStopwords(List<String> stopwords) {
        return stopwords.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private String filterStopwords(String line, final List<String> stopwords) {
        return Arrays.stream(line.split(SPLIT_SYMBOL))
                .filter(word -> !stopwords.contains(word))
                .collect(Collectors.joining(SPLIT_SYMBOL));
    }
}
