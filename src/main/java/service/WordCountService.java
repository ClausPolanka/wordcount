package service;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import util.StopWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountService {

    StopWords stopWords;

    public WordCountService(StopWords stopWords) {

        this.stopWords = stopWords;

    }

    public int getWordCount(@NotNull String str){

        return (int) getAllWords(str).count();

    }

    public int getUniqueWordCount(@NotNull String str){

        return (int) getAllWords(str).distinct().count();

    }

    public Map<String, Integer> getUniqueAndAllWordCount(@NotNull String str){

        final Map<String, Integer> countMap = new HashMap<>();
        Stream<String> words = getAllWords(str);

        //countMap.put("ALL", getWordCount())



    }

    private Stream<String> getAllWords(@NotNull String str) {

        final String wordRegex = "[a-zA-Z]+";
        final Pattern pattern = Pattern.compile(wordRegex);

        return Arrays.stream(str.split(StringUtils.SPACE))
                .filter(word -> (pattern.matcher(word)).matches())
                .filter(word -> !stopWords.contains(word));

    }
}
