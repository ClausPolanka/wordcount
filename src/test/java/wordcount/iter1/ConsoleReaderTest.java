package wordcount.iter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    @DisplayName(" when readInput then input from reader is read")
    @Test
    public void readInput() {
        Reader strReader = new StringReader("Mary_Mery");
        Writer strWriter = new StringWriter(1);

        ConsoleInteractor interactor = new ConsoleInteractor(strReader, strWriter);

        String readStr = interactor.read();

        assertEquals("Mary_Mery", readStr);
    }

    @DisplayName(" when writeOutput then output is  written to writer")
    @Test
    public void writeOutput() throws IOException {

        try(StringReader strReader = new StringReader("Mary_Mery");
            StringWriter strWriter = new StringWriter(1)) {

            ConsoleInteractor interactor = new ConsoleInteractor(strReader, strWriter);

            interactor.write("5");

            strWriter.flush();

            assertEquals("5", strWriter.getBuffer().toString());
        }
    }
}