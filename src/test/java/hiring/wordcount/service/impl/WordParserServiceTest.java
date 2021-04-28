package hiring.wordcount.service.impl;

import hiring.wordcount.exception.ValidatorNotFoundException;
import hiring.wordcount.service.ValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class WordParserServiceTest extends BaseServiceTest{
    private WordParserService service;

    @BeforeEach
    public void setUp(){
        service = new WordParserService();
    }

    @Test
    public void testName(){
        super.getServiceName(service);
    }

    @Test
    public void testGetWordAsListWithValidatorNotFoundException(){
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList("input"));
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList(""));
        assertThrows(ValidatorNotFoundException.class, () -> service.getWordsAsList(null));
    }

    @Test
    public void testGetWordAsListWithInvalidParameterException(){
        service.setValidator(new ValidatorService() {
            @Override
            public boolean validate(String input) {
                return false;
            }

            @Override
            public String getServiceName() {
                return null;
            }
        });
        assertThrows(InvalidParameterException.class, () -> service.getWordsAsList(null));
    }


}