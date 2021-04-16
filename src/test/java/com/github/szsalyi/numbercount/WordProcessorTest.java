package com.github.szsalyi.numbercount;

import com.github.szsalyi.io.TestUserInterface;
import com.github.szsalyi.wordcount.numbercount.UserInterface;
import com.github.szsalyi.wordcount.numbercount.WordProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordProcessorTest {

   @Test
    public void givenValidSingleString_whenCount_givenResultOne() {
        UserInterface userInterfaceTest = new TestUserInterface("word");
        WordProcessor wordProcessor = new WordProcessor(userInterfaceTest);

        long actual = wordProcessor.count();

        Assertions.assertEquals(actual, 1L);
    }

    @Test
    public void givenValidMultipleWords_whenCount_givenProperResult() {
        UserInterface userInterfaceTest = new TestUserInterface("word word         word");
        WordProcessor wordProcessor = new WordProcessor(userInterfaceTest);

        long actual = wordProcessor.count();

        Assertions.assertEquals(actual, 3L);
    }

    @Test
    public void givenEmptyInput_whenCount_givenZero() {
        UserInterface userInterfaceTest = new TestUserInterface("");
        WordProcessor wordProcessor = new WordProcessor(userInterfaceTest);

        long actual = wordProcessor.count();

        Assertions.assertEquals(actual, 0L);
    }

    @Test
    public void givenValidMultipleWordsWithInvalidWord_whenCount_givenValidWordCount() {
        UserInterface userInterfaceTest = new TestUserInterface("word word,         word");
        WordProcessor wordProcessor = new WordProcessor(userInterfaceTest);

        long actual = wordProcessor.count();

        Assertions.assertEquals(actual, 2L);
    }
}
