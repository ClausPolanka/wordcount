package hiring.wordcount.app;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import hiring.wordcount.util.WordCountServiceProvider;

import java.util.List;

public class WordCountApplication {
    private static String INPUT_READER_SERVICE = "StandardIOService";
    private static String PARSER_SERVICE = "WordParserService";
    private static String VALIDATOR_SERVICE = "WordValidatorService";

    public static void main(String[] args) {
        final InputReaderService inputReaderService =
                WordCountServiceProvider.load(InputReaderService.class, INPUT_READER_SERVICE);
        final ParserService parserService = WordCountServiceProvider.load(ParserService.class, PARSER_SERVICE);
        final ValidatorService validatorService =
                WordCountServiceProvider.load(ValidatorService.class, VALIDATOR_SERVICE);

        try {
            final String line = inputReaderService.read(null);
            parserService.setValidator(validatorService);
            final List<String> wordsAsList = parserService.getWordsAsList(line);

            System.out.println("Number of words: " + wordsAsList.size());
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }

    }
}
