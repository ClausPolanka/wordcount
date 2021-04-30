package wordcount.reader;

import java.io.InputStream;
import java.util.Scanner;

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
    public String readLine() {
        return new Scanner(inputStream).nextLine();
    }

}
