package hiring.wordcount.util;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WordCountServiceProviderTest {

    @Test
    public void getInputReaderServiceImpl() {
        final String serviceName = "StandardIOService";
        final InputReaderService standardIOService =
                WordCountServiceProvider.load(InputReaderService.class, serviceName);

        assertNotNull(standardIOService);
        assertEquals(serviceName, standardIOService.getServiceName());
    }

    @Test
    public void getParserServiceImpl() {
        final String serviceName = "WordParserService";
        final ParserService parserService =
                WordCountServiceProvider.load(ParserService.class, serviceName);

        assertNotNull(parserService);
        assertEquals(serviceName, parserService.getServiceName());
    }

    @Test
    public void getValidatorServiceImpl() {
        final String serviceName = "WordValidatorService";
        final ValidatorService validatorService =
                WordCountServiceProvider.load(ValidatorService.class, serviceName);

        assertNotNull(validatorService);
        assertEquals(serviceName, validatorService.getServiceName());
    }

    @Test
    public void testGetInstance() {
        assertNotNull(WordCountServiceProvider.getInstance());
    }

}