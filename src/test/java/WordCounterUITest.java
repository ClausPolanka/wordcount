import mocks.MockOutput;
import mocks.StringInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import root.infrastructure.FileInput;
import root.wordcounter.WordCounter;
import root.wordcounter.WordCounterUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUITest {

    private final DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
    private final DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
    private final char decimalSeparator = symbols.getDecimalSeparator();

    @TempDir
    Path tempDir;

    @Test
    public void okTestCorrectCounts() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Mary had a little lamb");
        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 4, unique: 4; average word length: 4" + decimalSeparator + "25 characters", output.getText());
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

        assertEquals("Number of words: 4, unique: 4; average word length: 4" + decimalSeparator + "25 characters", output.getText());
    }

    @Test
    public void okTestCorrectCountsIteration4() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 7, unique: 6; average word length: 6" + decimalSeparator + "71 characters", output.getText());
    }

    @Test
    public void okTestCorrectCountsPrintIndex() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Mary had a little lamb");
        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(new HashSet<>(Arrays.asList("the", "a", "on", "off"))));

        ui.countWords();

        assertEquals("Number of words: 4, unique: 4; average word length: 4"
                        + decimalSeparator + "25 characters" +
                        System.lineSeparator() + "Index:" +
                        System.lineSeparator() + "lamb" +
                        System.lineSeparator() + "little" +
                        System.lineSeparator() + "Mary"
                , output.getText());
    }

}
