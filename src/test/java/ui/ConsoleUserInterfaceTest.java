package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.WordsStats;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ConsoleUserInterfaceTest {

    private final PrintStream originalOut = System.out;
    private ConsoleUserInterface consoleUserInterface;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        consoleUserInterface = new ConsoleUserInterface(printStream);
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    public void testConsoleAskingForInput() {
        consoleUserInterface.askForInput();
        assertEquals("Enter text: ", outContent.toString());
    }

    @Test
    public void testConsolePrintingWordStats() {
        WordsStats wordsStats = new WordsStats(10, 5);
        consoleUserInterface.printStats(wordsStats);
        assertEquals("Number of words: 10, unique: 5", outContent.toString());
    }

    @Test
    public void testConsoleUserInputSource() {
        InputStream userInput = consoleUserInterface.getUserInput();
        assertSame(userInput, System.in);
    }
}