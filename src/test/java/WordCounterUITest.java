import mocks.MockOutput;
import mocks.StringInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import root.infrastructure.FileInput;
import root.wordcounter.WordCounter;
import root.infrastructure.FileStopWordsProvider;
import root.wordcounter.WordCounterUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUITest {

    @TempDir
    Path tempDir;

    @Test
    public void okTestCorrectCounts() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Mary had a little lamb");
        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 4, unique: 4", output.getText());
    }

    @Test
    public void okTestFileInput() throws IOException {

        Path tempFile = Files.createFile(tempDir.resolve("test.tmp"));

        PrintWriter testWriter = new PrintWriter(new FileOutputStream(tempFile.toFile()));
        testWriter.write("Mary had" + System.lineSeparator() + "a little" + System.lineSeparator() + "lamb");
        testWriter.close();

        MockOutput output = new MockOutput();
        WordCounterUI ui = new WordCounterUI(new FileInput(tempFile.toString()), output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 4, unique: 4", output.getText());
    }

    @Test
    public void okTestCorrectCountsIteration4() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 7, unique: 6", output.getText());
    }

}
