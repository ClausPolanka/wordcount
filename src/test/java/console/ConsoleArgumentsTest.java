package console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleArgumentsTest {

    @Test
    public void whenConsoleArguments_thenReturnArguments() {
        ConsoleArguments consoleArguments = new ConsoleArguments("wordcount mytest.txt");

        assertEquals("mytest.txt", consoleArguments.extractExternalResourcePath());
    }

    @Test
    public void whenConsoleArgumentsWithIndex_thenReturnArguments() {
        ConsoleArguments consoleArguments = new ConsoleArguments("wordcount -index mytest.txt");

        assertTrue(consoleArguments.isShowIndexPresent());
        assertEquals("mytest.txt", consoleArguments.extractExternalResourcePath());
    }

    @Test
    public void whenConsoleArgumentsWithDictionary_thenReturnArguments() {
        ConsoleArguments consoleArguments = new ConsoleArguments("wordcount -index -dictionary=dict.txt mytest.txt");

        assertTrue(consoleArguments.isShowIndexPresent());
        assertEquals("dict.txt", consoleArguments.extractDictionaryPath());
        assertEquals("mytest.txt", consoleArguments.extractExternalResourcePath());
    }


    @Test
    public void whenInvalidConsoleArguments_thenReturnNoArguments() {
        ConsoleArguments consoleArguments = new ConsoleArguments("wordcount  index -dictionary=dict.pdf mytest.pdf");

        assertFalse(consoleArguments.isShowIndexPresent());
        assertTrue(consoleArguments.extractDictionaryPath().isEmpty());
        assertTrue(consoleArguments.extractExternalResourcePath().isEmpty());
    }
}
