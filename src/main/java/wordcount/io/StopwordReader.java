package wordcount.io;

import utils.ResourceFetcher;
import wordcount.error.WrappedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StopwordReader implements IStopwordReader {

    final ResourceFetcher resourceFetcher;

    public StopwordReader(ResourceFetcher resourceFetcher) {
        this.resourceFetcher = resourceFetcher;
    }


    public List<String> readStopwords() {
        URL resource = StopwordReader.class.getClassLoader().getResource("stopwords.txt");
        File file;
        try {
            file = Paths.get(resource.toURI()).toFile();

        } catch (URISyntaxException ex) {
            throw new WrappedException(ErrorCode.ERRORS_ACCESSING_RESOURCE_STOPWORD_READER.name());
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file.getCanonicalPath()))) {

            return reader.lines().collect(Collectors.toList());

        } catch (IOException ex) {
            throw new WrappedException(ErrorCode.ERRORS_IN_STOPWORD_READER.name());
        }
    }

}
