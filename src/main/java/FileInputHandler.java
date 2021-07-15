import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileInputHandler implements InputHandler {

    private final String fileName;

    public FileInputHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getInputText() {
        File file = new File(fileName);

        try {
            return String.join("\n", Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("File not found!");
        }
    }

}
