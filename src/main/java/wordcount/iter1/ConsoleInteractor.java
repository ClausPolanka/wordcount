package wordcount.iter1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;

/**
 * Reader and Writer instances are not managed in a sense, that this class doesn't take care of
 * closing the i/o streams.
 */
public class ConsoleInteractor {
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public ConsoleInteractor(Reader reader, Writer writer) {
        this.reader = new BufferedReader(reader);
        this.writer = new BufferedWriter(writer);
    }

    public void write(String text) {
        try {
            writer.write(text);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
