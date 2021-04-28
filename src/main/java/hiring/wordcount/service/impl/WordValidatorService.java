package hiring.wordcount.service.impl;

import hiring.wordcount.service.ValidatorService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordValidatorService implements ValidatorService {
    @Override
    public String getServiceName() {
        return "WordValidatorService";
    }

    @Override
    public void setValidatorResource(String resource) {
        // It won't be used
    }

    @Override
    public boolean validate(String input) {

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
