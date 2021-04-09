package service;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class WordCountService {

    public int getWordCount(@NotNull String str){

        final String wordRegex = "[a-zA-Z]+";

        return (int) Arrays.asList(str.split(StringUtils.SPACE))
                .stream()
                .filter(word -> word.matches(wordRegex))
                .count();

    }
}
