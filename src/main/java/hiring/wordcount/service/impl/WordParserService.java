package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorNotFoundException;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordParserService implements ParserService {
    private ValidatorService validatorService;

    @Override
    public String getServiceName() {
        return "WordParserService";
    }

    @Override
    public void setValidator(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public ValidatorService getValidatorService() {
        return this.validatorService;
    }

    @Override
    public List<String> getWordsAsList(String input) throws ValidatorNotFoundException {
        if (getValidatorService() == null)
            throw new ValidatorNotFoundException("No Validator Service has been set");
        if (input == null)
            throw new InvalidParameterException("Input cannot be null");

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
