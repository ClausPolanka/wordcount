package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromFileInputTextProviderTest {

    @Test
    void readInputText() {
        FromFileInputTextProvider inputTextProvider = new FromFileInputTextProvider("input.txt");

        String out = inputTextProvider.readInputText();

        String expected = "Mary had\nlamb.\nthe\nHumpty-Dumpty";
        assertEquals(expected, out);
    }
}