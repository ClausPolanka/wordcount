package wordcount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    @DisplayName(" when readInput then input from reader is read")
    @Test
    public void readInput() throws IOException {

        try(BufferedReader strReader = new BufferedReader(new StringReader("Mary_Mery"));
            BufferedWriter strWriter = new BufferedWriter(new StringWriter(1))) {
            ConsoleInteractor interactor = new ConsoleInteractor(strReader, strWriter);

            String readStr = interactor.read();

            assertEquals("Mary_Mery", readStr);
        }

    }

    @DisplayName(" when writeOutput then output is  written to writer")
    @Test
    public void writeOutput() throws IOException {

        StringWriter stringWriter = new StringWriter();
        try(BufferedReader reader = new BufferedReader(new StringReader("asd"));
            BufferedWriter writer = new BufferedWriter(stringWriter)) {

            ConsoleInteractor interactor = new ConsoleInteractor(
                    reader, writer);

            interactor.write("output is : 5");

            writer.flush();

            assertEquals("output is : 5", stringWriter.toString());
        }
    }
}