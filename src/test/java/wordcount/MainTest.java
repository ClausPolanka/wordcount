package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testReadFile() {
        final String inputText = "Mary had\n" +
                "a little\n" +
                "lamb\n";
        assertEquals(inputText, new Main(null).readInput("src/test/resources/mytext.txt"));
    }
}
