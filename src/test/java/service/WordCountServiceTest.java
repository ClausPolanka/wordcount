package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WordCountServiceTest {

    @Test
    public void testGetWordCount(){

        String str = "abc def";
        Assertions.assertEquals(2, WordCountService.getWordCount(str));

    }

}
