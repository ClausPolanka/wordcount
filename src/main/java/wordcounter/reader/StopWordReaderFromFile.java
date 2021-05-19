package wordcounter.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StopWordReaderFromFile implements StopWordReader {

    private List<String> content;

    public List<String> getStopWords() {
        return content;
    }

    public StopWordReaderFromFile(String filePath) {
        Path path;
        try {
            path = Paths.get(ClassLoader.getSystemResource(filePath).toURI());
            content = Files.readAllLines(path);
        } catch (URISyntaxException | IOException | NullPointerException ex) {
            throw new IllegalArgumentException();
        }
    }
}
