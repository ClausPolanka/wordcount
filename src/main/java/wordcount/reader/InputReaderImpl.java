package wordcount.reader;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * InputReaderImpl default implementation for handling input over streams
 */
public class InputReaderImpl implements InputReader {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

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
     * Reads all lines from a constructed stream
     */
    @Override
    public List<String> readLines() throws IOException {
        List<String> readLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, CHARSET))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                readLines.add(line);
            }
        }
        return readLines;
    }

}
