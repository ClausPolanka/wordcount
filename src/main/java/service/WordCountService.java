package service;

import model.WordDetailsDTO;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import util.StopWords;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountService {

    StopWords stopWords;

    public WordCountService(StopWords stopWords) {

        this.stopWords = stopWords;

    }

    public int getUniqueWordCount(List<String> words){

        return (int) words.stream().distinct().count();

    }

    public WordDetailsDTO getWordDetails(@NotNull String str){

        final WordDetailsDTO wordDetailsDTO = new WordDetailsDTO();
        final List<String> words = getAllWords(str);

        wordDetailsDTO.setCount(words.size());
        wordDetailsDTO.setUniqueCount(getUniqueWordCount(words));
        wordDetailsDTO.setAverageLength(getAverageLength(words));

        return wordDetailsDTO;

    }

    public double getAverageLength(List<String> words) {

        return words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

    }

    private List<String> getAllWords(@NotNull String str) {

        final String delimiters = StringUtils.SPACE;
        final String wordRegex = "[a-zA-Z-]+\\.*";
        final Pattern pattern = Pattern.compile(wordRegex);

        return Arrays.stream(str.split(delimiters))
                .filter(word -> (pattern.matcher(word)).matches())
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());

    }
}
