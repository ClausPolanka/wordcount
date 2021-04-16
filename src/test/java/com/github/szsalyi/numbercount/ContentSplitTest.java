package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.ContentSplit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContentSplitTest {
    private ContentSplit contentSplit;

    @BeforeEach
    private void init() {
        this.contentSplit = new ContentSplit();
    }

    @Test
    public void givenSingleWordInput_whenStringList_thenReturnSingleElementList() {
        String content = "word";
        List<String> expected = Collections.singletonList("word");

        List<String> splitContent = contentSplit.stringList(content);

        assertEquals(splitContent, expected);
    }

    @Test
    public void givenMultipleWordInputWithSpaces_whenStringList_thenReturnSplitList() {
        String content = "word word      word";
        List<String> expected = Arrays.asList("word", "word", "word");

        List<String> splitContent = contentSplit.stringList(content);

        assertEquals(splitContent, expected);
    }

    @Test
    public void givenMultipleWordInputWithNonAlphabeticCharacters_whenStringList_thenReturnSplitListWithEveryElement() {
        String content = "word word   ,   word";
        List<String> expected = Arrays.asList("word", "word", ",", "word");

        List<String> splitContent = contentSplit.stringList(content);

        assertEquals(splitContent, expected);
    }

    @Test
    public void givenEmptyInput_whenStringList_thenReturnEmptyList() {
        String content = "";
        List<String> emptyStringList = Collections.singletonList("");

        List<String> splitContent = contentSplit.stringList(content);

        assertEquals(splitContent, emptyStringList);
    }
}
