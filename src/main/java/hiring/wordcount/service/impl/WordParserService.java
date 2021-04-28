package hiring.wordcount.service.impl;

import hiring.wordcount.service.ParserService;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class WordParserService implements ParserService {
    @Override
    public String getServiceName() {
        return "WordParserService";
    }

    @Override
    public List<String> getWordsAsList(String input) {
        if (input == null)
            throw new InvalidParameterException("Input cannot be null");

        String[] rawWords = input.split("\\s+");
        List<String> words = new ArrayList<>();

        for (String rawWord : rawWords) {
            words.add(rawWord);
        }

        return words;
    }
}
