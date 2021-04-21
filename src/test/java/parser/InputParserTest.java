package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    public void whenSentenceIsNullOrEmptyThenNoWordsAreAvailable() {
        String[] strings = InputParser.extractWords(null);
        assertEquals(0, strings.length);

        strings = InputParser.extractWords("");
        assertEquals(0, strings.length);

        strings = InputParser.extractWords(" ");
        assertEquals(0, strings.length);
    }

    @Test
    public void whenSentenceIsValidThenNoWordsAreAvailable() {
        String[] strings = InputParser.extractWords("hello world");
        assertEquals(2, strings.length);
        assertEquals("hello", strings[0]);
        assertEquals("world", strings[1]);
    }

    @Test
    public void whenWordIsNullThenNoCleaningHappens() {
        assertEquals("", InputParser.cleanWord(null));
        assertEquals("", InputParser.cleanWord(""));
    }

    @Test
    public void whenWordEndsWithDotThenDotIsRemoved() {
        assertEquals("wall", InputParser.cleanWord("wall."));
    }
}