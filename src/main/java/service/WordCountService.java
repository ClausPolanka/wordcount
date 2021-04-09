package service;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import util.WordCountUtil;

import java.util.Arrays;
import java.util.List;

public class WordCountService {

    public int getWordCount(@NotNull String str){

        final String stopWordsFile = "stopwords.txt";

        final List<String> stopWords = WordCountUtil.getWordsFromFile(stopWordsFile);

        final String wordRegex = "[a-zA-Z]+";

        return (int) Arrays.asList(str.split(StringUtils.SPACE))
                .stream()
                .filter(word -> word.matches(wordRegex))
                .filter(word -> !stopWords.contains(word))
                .count();

    }
}
