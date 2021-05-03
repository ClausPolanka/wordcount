package wordcount.reader;

import java.io.*;
import java.util.*;

/**
 * InputReaderImpl default implementation for handling input over streams
 */
public class InputReaderImpl implements InputReader {

    private final InputStream inputStream;

    /**
     * Default constructor constructs InputReader with an input from System.in
     */
    public InputReaderImpl() {
        this(System.in);
    }

    /**
     * Custom constructor constructs InputReader with a given stream
     */
    public InputReaderImpl(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Reads a line from a constructed stream
     */
    @Override
    public List<String> readLines() throws IOException {
        List<String> readLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                readLines.add(line);
            }
        }
        return readLines;
    }

}
