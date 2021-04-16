package com.github.szsalyi.wordcount.numbercount;

import com.github.szsalyi.wordcount.io.UserIO;

import java.io.IOException;
import java.util.List;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordCountImpl implements WordCount {

    private UserIO userIO;
    private ContentSplit contentSplit;
    private WordCheck wordCheck;

    public WordCountImpl(UserIO userIO, ContentSplit contentSplit, WordCheck wordCheck) {
        this.userIO = userIO;
        this.contentSplit = contentSplit;
        this.wordCheck = wordCheck;
    }

    @Override
    public Long count(String input) {
        long wordCount = 0L;
        String userInput;
        List<String> delimiteredInput;

        try {
            userInput = userIO.userInput();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        delimiteredInput = contentSplit.stringList(input);

        for (String word: delimiteredInput) {
            if(wordCheck.isValid(word)) wordCount++;
        }

        return wordCount;
    }
}
