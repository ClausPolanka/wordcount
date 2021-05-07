package wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;

public class FromConsoleTextProvider implements InputTextProvider {
    private final BufferedReader reader;

    public FromConsoleTextProvider(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String readInputText() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
