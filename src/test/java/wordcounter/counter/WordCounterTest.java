package wordcounter.counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void shouldCountWords() {
        WordCounter wordCounter = new WordCounter();
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
    }
}
