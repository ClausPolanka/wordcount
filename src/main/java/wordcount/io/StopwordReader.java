package wordcount.io;

import wordcount.error.WrappedException;
import wordcount.utils.ResourceFetcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StopwordReader implements IStopwordReader {

    final ResourceFetcher resourceFetcher;

    public StopwordReader(ResourceFetcher resourceFetcher) {
        this.resourceFetcher = resourceFetcher;
    }


    public List<String> readStopwords() {

        File file = resourceFetcher.getFileFromResources("stopwords.txt", ErrorCode.ERRORS_ACCESSING_RESOURCE_STOPWORD_READER);

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file.getCanonicalPath()))) {

            return reader.lines().collect(Collectors.toList());

        } catch (IOException ex) {
            throw new WrappedException(ErrorCode.ERRORS_IN_STOPWORD_READER.name());
        }
    }

}
