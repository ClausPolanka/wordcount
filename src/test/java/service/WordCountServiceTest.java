package service;

import org.junit.jupiter.api.Test;
import util.FileBasedStopWords;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCountServiceTest {

    @Test
    public void testGetWordCount(){

        FileBasedStopWords stopWords = new FileBasedStopWords();
        WordCountService wordCountService = new WordCountService(stopWords);

        //LowerCase + Special Character Separator
        String str = "abc def .k";
        assertEquals(2, wordCountService.getWordCount(str));

        //Single Word
        str = "abc";
        assertEquals(1, wordCountService.getWordCount(str));

        //Two Words - Multiple Spaces
        str = " abc   def";
        assertEquals(2, wordCountService.getWordCount(str));

        //Blank String
        str = "";
        assertEquals(0, wordCountService.getWordCount(str));

        //Multiple Spaces + UpperCase
        str = "   ABC";
        assertEquals(1, wordCountService.getWordCount(str));

        //Special Characters Only
        str = "&*(";
        assertEquals(0, wordCountService.getWordCount(str));

        //Special Characters and UpperCase
        str = ".   ABC";
        assertEquals(1, wordCountService.getWordCount(str));

        //Word with digit
        str = " abc   d1ef";
        assertEquals(1, wordCountService.getWordCount(str));

        //Onw word + One StopWord - a
        str = "abc a";
        assertEquals(1, wordCountService.getWordCount(str));

        //Two Words - StopWord - but different case
        str = "abc THE";
        assertEquals(2, wordCountService.getWordCount(str));

        //All are stopwords
        str = "a the";
        assertEquals(0, wordCountService.getWordCount(str));

    }

}
