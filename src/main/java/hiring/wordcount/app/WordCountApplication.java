package hiring.wordcount.app;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import hiring.wordcount.util.WordCountServiceProvider;

import java.util.ArrayList;
import java.util.List;

public class WordCountApplication {
    private static String INPUT_READER_SERVICE = "StandardIOService";
    private static String PARSER_SERVICE = "WordParserService";
    private static String VALIDATOR_SERVICE = "WordValidatorService";
    private static String STOP_WORD_VALIDATOR_SERVICE = "StopWordValidatorService";

    public static void main(String[] args) {
        final InputReaderService inputReaderService =
                WordCountServiceProvider.load(InputReaderService.class, INPUT_READER_SERVICE);
        final ParserService parserService = WordCountServiceProvider.load(ParserService.class, PARSER_SERVICE);
        final ValidatorService validatorService =
                WordCountServiceProvider.load(ValidatorService.class, VALIDATOR_SERVICE);
        final ValidatorService stopWordService =
                WordCountServiceProvider.load(ValidatorService.class, STOP_WORD_VALIDATOR_SERVICE);


        try {
            final String line = inputReaderService.read(null);
            final List<String> wordsAsList = parserService.getWordsAsList(line);
            List<String> validWords = new ArrayList<>();
            for (String word : wordsAsList) {
                if (validatorService.validate(word) && stopWordService.validate(word))
                    validWords.add(word);
            }

            System.out.println("Number of words: " + validWords.size());
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }

    }
}
