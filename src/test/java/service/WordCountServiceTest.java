package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCountServiceTest {

    @Test
    public void testGetWordCount(){

        //LowerCase + Special Character Separator
        String str = "abc def .k";
        assertEquals(2, WordCountService.getWordCount(str));

        //Single Word
        str = "abc";
        assertEquals(1, WordCountService.getWordCount(str));

        //Two Words - Multiple Spaces
        str = " abc   def";
        assertEquals(2, WordCountService.getWordCount(str));

        //Blank String
        str = "";
        assertEquals(0, WordCountService.getWordCount(str));

        //Multiple Spaces + UpperCase
        str = "   ABC";
        assertEquals(1, WordCountService.getWordCount(str));

        //Special Characters Only
        str = "&*(";
        assertEquals(0, WordCountService.getWordCount(str));

        //Special Characters and UpperCase
        str = ".   ABC";
        assertEquals(1, WordCountService.getWordCount(str));

        //Word with digit
        str = " abc   d1ef";
        assertEquals(1, WordCountService.getWordCount(str));

    }

}
