package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.ContentSplit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
