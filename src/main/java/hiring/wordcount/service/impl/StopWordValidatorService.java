package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorException;
import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import hiring.wordcount.util.WordCountServiceProvider;

import java.security.InvalidParameterException;
import java.util.List;

public class StopWordValidatorService implements ValidatorService {
    private List<String> filterWords;
    private String stopWordsResourcePath;

    private void fillFilterWords() throws Exception {
        final InputReaderService fileInputService =
                WordCountServiceProvider.load(InputReaderService.class, "FileInputService");
        if (getStopWordsResourcePath() == null || getStopWordsResourcePath().isEmpty())
            throw new ValidatorException("The Stop word resource file name is not set");

        final String input = fileInputService.read(getStopWordsResourcePath());

        final List<String> stopWords =
                WordCountServiceProvider.load(ParserService.class, "WordParserService").getWordsAsList(input);

        if (stopWords != null) {
            filterWords = stopWords;
        }
    }

    @Override
    public String getServiceName() {
        return "StopWordValidatorService";
    }

    public String getStopWordsResourcePath() {
        return stopWordsResourcePath;
    }

    @Override
    public void setValidatorResource(String resource) {
        stopWordsResourcePath = resource;
    }

    @Override
    public boolean validate(String input) throws ValidatorException {
        if (input == null || input.isEmpty())
            throw new InvalidParameterException("Input cannot be null or empty");

        if (this.filterWords == null) {
            try {
                fillFilterWords();
            } catch (Exception e) {
                throw new ValidatorException(e);
            }
        }

        return !filterWords.contains(input);
    }
}
