package src.main.java.service;

import src.main.java.WordMapKeys;
import src.main.java.api.Foo;
import src.main.java.api.WordCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FooService {
    private WordCount wordCount;

    public FooService(String fileName)
    {
        wordCount = new Foo(fileName);
    }


    public Map<String, Double> countWords(String text, String file, boolean useStopWords, boolean uniqueWords)
    {
        Map<String,Double> wordsMap = new HashMap<>();
        if (file == null)
        {
            wordsMap.put(WordMapKeys.TOTAL_WORDS.getKeyNameValue(),Double.valueOf(wordCount.countWords(text)));
            if (useStopWords)
                wordsMap.put(WordMapKeys.TOTAL_WORDS_WITH_STOPPER.getKeyNameValue(), Double.valueOf(wordCount.countWordsWithStopper(text)));
            if (uniqueWords)
                wordsMap.put(WordMapKeys.UNIQUE_WORDS.getKeyNameValue(), Double.valueOf(wordCount.countUniqueWords(text)));
            wordsMap.put(WordMapKeys.TOTAL_AVG.getKeyNameValue(), wordCount.getWordAvgLength(text));
        } else
        {
            String line;
            BufferedReader reader = null;
            StringBuilder builder = new StringBuilder();
            try {
                reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                wordsMap.put(WordMapKeys.TOTAL_WORDS.getKeyNameValue(),Double.valueOf(wordCount.countWords(builder.toString())));
                if (useStopWords)
                    wordsMap.put(WordMapKeys.TOTAL_WORDS_WITH_STOPPER.getKeyNameValue(), Double.valueOf(wordCount.countWordsWithStopper(builder.toString())));
                if (uniqueWords)
                    wordsMap.put(WordMapKeys.UNIQUE_WORDS.getKeyNameValue(), Double.valueOf(wordCount.countUniqueWords(builder.toString())));
                wordsMap.put(WordMapKeys.TOTAL_AVG.getKeyNameValue(), wordCount.getWordAvgLength(builder.toString()));
            }
        }
        return wordsMap;
    }
}
