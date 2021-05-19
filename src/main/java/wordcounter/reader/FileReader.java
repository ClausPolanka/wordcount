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

    public void setContent(List<String> content) {
        this.content = content;
    }

    public FileReader() {
        Path path = Paths.get("stopwords.txt");
        try {
            content = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
