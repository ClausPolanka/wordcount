package wordcounter.counter;

import org.junit.jupiter.api.Test;
import wordcounter.reader.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void shouldCountWords() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.setFileReader(new FileReader());
        wordCounter.setText("word");
        assertEquals(wordCounter.countWords(), 1);
        wordCounter.setText("word word");
        assertEquals(wordCounter.countWords(), 2);
        wordCounter.setText("word word word");
        assertEquals(wordCounter.countWords(), 3);
        wordCounter.setText("wo4rD");
        assertEquals(wordCounter.countWords(), 0);
        wordCounter.setText("wo$rd");
        assertEquals(wordCounter.countWords(), 0);
        wordCounter.setText("");
        assertEquals(wordCounter.countWords(), 0);
        wordCounter.setText("word, word. word? word");
        assertEquals(wordCounter.countWords(), 1);
        wordCounter.setText("           word           word                 word     ");
        assertEquals(wordCounter.countWords(), 3);
        wordCounter.setText("Mary had a little lamb");
        assertEquals(wordCounter.countWords(), 4);
        wordCounter.setText("Mary had a little lamb and a big");
        assertEquals(wordCounter.countWords(), 6);
        wordCounter.setText("The the on Off");
        assertEquals(wordCounter.countWords(), 2);
    }
}
