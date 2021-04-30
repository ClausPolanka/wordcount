package console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleArgumentsTest {

    @Test
    public void whenConsoleArguments_thenReturnArguments() {
        ConsoleArguments consoleArguments = new ConsoleArguments("wordcount mytest.txt");

        assertEquals("mytest.txt", consoleArguments.extractExternalResourcePath());
    }
}
