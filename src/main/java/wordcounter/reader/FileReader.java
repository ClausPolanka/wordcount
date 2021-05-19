package wordcounter.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FileReader() {
        Path path = Paths.get("stopwords.txt");
        try {
            content = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
