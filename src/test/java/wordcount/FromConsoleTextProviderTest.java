package wordcount;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromConsoleTextProviderTest {

    @Test
    public void testFromConsole() {
        FromConsoleTextProvider consoleTextProvider = new FromConsoleTextProvider(
                new BufferedReader(new StringReader("adbc dce"))
        );

        String input = consoleTextProvider.readInputText();

        assertEquals("adbc dce", input);
    }

}