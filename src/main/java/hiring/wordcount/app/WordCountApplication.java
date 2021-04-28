package hiring.wordcount.app;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import hiring.wordcount.util.WordCountServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordCountApplication {
    private static final String FILE_INPUT_SERVICE = "FileInputService";
    private static final String INPUT_READER_SERVICE = "StandardIOService";
    private static final String PARSER_SERVICE = "WordParserService";
    private static final String STOP_WORD_VALIDATOR_SERVICE = "StopWordValidatorService";
    private static final String VALIDATOR_SERVICE = "WordValidatorService";

    public static void main(String[] args) throws Exception {
        final InputReaderService inputReaderService =
                WordCountServiceProvider.load(InputReaderService.class, INPUT_READER_SERVICE);
        final ParserService parserService = WordCountServiceProvider.load(ParserService.class, PARSER_SERVICE);
        final ValidatorService validatorService =
                WordCountServiceProvider.load(ValidatorService.class, VALIDATOR_SERVICE);
        final ValidatorService stopWordService =
                WordCountServiceProvider.load(ValidatorService.class, STOP_WORD_VALIDATOR_SERVICE);
        final InputReaderService fileInputService =
                WordCountServiceProvider.load(InputReaderService.class, FILE_INPUT_SERVICE);

        stopWordService.setValidatorResource(
                Objects.requireNonNull(WordCountApplication.class.getClassLoader().getResource("stopwords.txt"))
                        .getFile());

        String line;
        if (args != null && args.length != 0 && args[0] != null && !args[0].isEmpty()) {
            line = fileInputService.read(args[0]);
        } else {
            line = inputReaderService.read(null);
        }

        final List<String> wordsAsList = parserService.getWordsAsList(line);
        List<String> validWords = new ArrayList<>();
        for (String word : wordsAsList) {
            if (validatorService.validate(word) && stopWordService.validate(word))
                validWords.add(word);
        }

        System.out.println("Number of words: " + validWords.size());

    }
}
