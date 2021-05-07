package wordcount;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FromFileInputTextProvider implements InputTextProvider{
    private final String filePath;

    public FromFileInputTextProvider(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     * @return with LF concatenated list
     */
    public String readInputText(){
        Path path = Paths.get(filePath);
        try {
            return String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
