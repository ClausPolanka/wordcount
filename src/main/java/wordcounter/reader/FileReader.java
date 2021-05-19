package wordcounter.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    private List<String> content;

    public List<String> getContent() {
        return content;
    }

    public FileReader(String filePath) {
        Path path = Paths.get(filePath);
        try {
            content = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
