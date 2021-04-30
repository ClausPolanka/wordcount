package console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
