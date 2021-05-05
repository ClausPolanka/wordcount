package at.george.io;

import at.george.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static at.george.WordCountConstants.SPLIT_SYMBOL;

public class FileReader implements Reader {

    private final String filename;
    private final Reader fallbackReader;

    /**
     * Reads an input string from a file with a name which is received as an application argument
     *
     * @return The content from the file
     */
    public FileReader(String[] args, Reader fallbackReader) {
        this.filename = extractFilenameIfExists(args);
        this.fallbackReader = fallbackReader;
    }

    @Override
    public String read() {
        if (filename.isEmpty()) return fallbackReader.read();

        try {
            List<String> userInputLines = Files.readAllLines(Paths.get(filename));

            return String.join(SPLIT_SYMBOL, userInputLines);
        } catch (IOException e) {
            return fallbackReader.read();
        }
    }

    private String extractFilenameIfExists(String[] args) {
        return args.length == 0 ? "" : args[0];
    }
}
