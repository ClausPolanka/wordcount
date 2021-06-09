package root.infrastructure;

import root.wordcounter.InputInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements InputInterface {

    private final String file;

    public FileInput(String file) {

       this.file = file;

    }

    @Override
    public String getInput() {
        StringBuilder text = new StringBuilder();
        try {
            List<String> lines = new ArrayList<>(Files.readAllLines(new File(file).toPath()));
            return String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            System.out.println("File not found");
            return "";
        }
    }
}
