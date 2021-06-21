package wordcount.io;

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

public class StopWordReader implements IStopWordReader {

    public List<String> readStopWords()  {
        URL resource = StopWordReader.class.getClassLoader().getResource("stopwords.txt");
        File file;
        try {
             file = Paths.get(resource.toURI()).toFile();

        }
        catch(URISyntaxException ex) {
            throw new WrappedException(Errors.ERRORS_ACCESSING_RESOURCE_STOPWORD_READER.name());
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file.getCanonicalPath()))) {

        return reader.lines().collect(Collectors.toList());

        } catch(IOException ex) {
            throw new WrappedException(Errors.ERRORS_IN_STOPWORD_READER.name());
        }
    }

}
