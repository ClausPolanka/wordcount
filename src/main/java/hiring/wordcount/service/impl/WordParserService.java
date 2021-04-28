package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorNotFoundException;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class WordParserService implements ParserService {

    private static String WORD_VALIDATOR = "WordValidatorService";
    private ValidatorService validatorService;
    public WordParserService() throws ValidatorNotFoundException {
        ServiceLoader<ValidatorService> serviceLoader = ServiceLoader.load(ValidatorService.class);
        serviceLoader.reload();

        final Iterator<ValidatorService> validatorServiceIterator = serviceLoader.iterator();

        while (validatorServiceIterator.hasNext()) {
            final ValidatorService validatorService = validatorServiceIterator.next();
            if (validatorService.getServiceName().equalsIgnoreCase(WORD_VALIDATOR)) {
                this.validatorService = validatorService;
            }
        }

        if (validatorService == null) {
            throw new ValidatorNotFoundException(WORD_VALIDATOR);
        }
    }

    @Override
    public String getServiceName() {
        return "WordParserService";
    }

    @Override
    public List<String> getWordsAsList(String input) {
        String[] rawWords = input.split("\\s+");

        List<String> validWords = new ArrayList<>();

        Arrays.stream(rawWords).forEach(word -> {
            if (validatorService.validate(word)) {
                validWords.add(word);
            }
        });

        return validWords;
    }

}
