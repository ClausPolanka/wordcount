package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testReadFile() {
        final String inputText = "Mary had\n" +
                "a little\n" +
                "lamb\n";
        assertEquals(new Main().readInput("src/test/resources/mytext.txt"), inputText);
    }
}
