import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import root.wordcounter.InputInterface;
import root.infrastructure.FileInput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputTest {

    @TempDir
    Path tempDir;

    @Test
    public void okReadFile() throws IOException {

        Path tempFile = Files.createFile(tempDir.resolve("test.tmp"));

        PrintWriter testWriter = new PrintWriter(new FileOutputStream(tempFile.toFile()));
        testWriter.write("Mary had" + System.lineSeparator() + "a little" + System.lineSeparator() + "lamb");
        testWriter.close();


        InputInterface input = new FileInput(tempFile.toString());

        String text = input.getInput();

        assertEquals("Mary had" + System.lineSeparator() + "a little" + System.lineSeparator() + "lamb",
                text);

    }

    @Test
    public void nokReadInvalidFile() {

        InputInterface input = new FileInput("invalidFile.txt");
        assertEquals("", input.getInput());


    }

}
