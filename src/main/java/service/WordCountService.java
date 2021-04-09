package service;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import util.StopWords;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCountService {

    StopWords stopWords;

    public WordCountService(StopWords stopWords) {

        this.stopWords = stopWords;

    }

    public int getWordCount(@NotNull String str){

        final String wordRegex = "[a-zA-Z]+";
        final Pattern pattern = Pattern.compile(wordRegex);

        return (int) Arrays.asList(str.split(StringUtils.SPACE))
                .stream()
                .filter(word -> (pattern.matcher(word)).matches())
                .filter(word -> !stopWords.contains(word))
                .count();

    }
}
