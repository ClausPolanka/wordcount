package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.WordsStats;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileUserInterfaceTest {

    private final PrintStream originalOut = System.out;
    private InputFileUserInterface inputFileUserInterface;
    private PrintStream printStream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        printStream = new PrintStream(outContent);
        System.setOut(printStream);
        inputFileUserInterface = new InputFileUserInterface(printStream, "stopwords.txt");
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    public void whenCreatingInputFileUserInterfaceWithFileNotFoundThenFallbackToSystemIn() {
        inputFileUserInterface = new InputFileUserInterface(printStream, "blah.txt");
        InputStream userInput = inputFileUserInterface.getUserInput();
        assertEquals(System.in, userInput);
    }


    @Test
    public void testInputFileAskingForInput() {
        inputFileUserInterface.askForInput();
        assertEquals("", outContent.toString());
    }

    @Test
    public void testInputFilePrintingWordStats() {
        WordsStats wordsStats = new WordsStats(10, 5);
        inputFileUserInterface.printStats(wordsStats);
        assertEquals("Number of words: 10, unique: 5", outContent.toString());
    }
}