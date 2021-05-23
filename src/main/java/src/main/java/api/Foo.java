package src.main.java.api;

import org.apache.commons.lang3.StringUtils;
import src.main.java.api.WordCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Foo implements WordCount {

    private Map<String, Integer> stopWords;

    public Foo() {
        stopWords = createStopWordsMap("src/resources/stopwords.txt");
    }

    public Foo(String filePath)
    {
        stopWords = createStopWordsMap(filePath);
    }

    private Map<String,Integer> createStopWordsMap(String filePath) {
        BufferedReader reader = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            String line;
            int counter = 0;
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                map.put(line, counter++);
            }
        } catch (IOException e) {
            System.out.println("Properties file not initialized. Reason " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    @Override
    public int countWords(String text)
    {
        return getWordArray(text).length;
    }

    @Override
    public int countWordsWithStopper(String text)
    {
        String[] words = getWordArray(text);
        int size = 0;
        for (String s : words)
        {
            if (stopWords.containsKey(s))
            {
               //skip
            } else
            {
                size++;
            }
        }
        return size;
    }

    @Override
    public int countUniqueWords(String text) {
        Map<String, Integer> uniqueWords = createWordsAndLengthMap(text);
        return uniqueWords.size();
    }

    @Override
    public double getWordAvgLength(String text) {
        Double avg = 0.0;
        List<Double> wordsLength = createWordLength(text);
        for (Double val : wordsLength)
        {
            avg+=val;
        }
        if (!wordsLength.isEmpty())
            avg = avg/wordsLength.size();
        return avg;
    }

    private String[] getWordArray(String text)
    {
        if (StringUtils.isBlank(text))
        {
            return new String[0];
        } else
        {
            return text.split("[ ,\\?,\\.,\\!,\\,]+");
        }
    }

    private Map<String, Integer> createWordsAndLengthMap(String text)
    {
        return Arrays.asList(getWordArray(text)).stream()
            .collect(Collectors.toMap(e -> e.toLowerCase(), e-> e.length(), (existingValue, newValue) -> existingValue));
    }

    private List<Double> createWordLength(String text)
    {
        return Arrays.asList(getWordArray(text)).stream().map(e->Double.valueOf(e.length()))
                .collect(Collectors.toList());
    }
}
