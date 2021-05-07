package wordcount;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FromFileInputTextProvider implements InputTextProvider{
    private final String filePath;
    private static final String NEW_LINE_DELIMETER = "\n";

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
            return String.join(NEW_LINE_DELIMETER, Files.readAllLines(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
