package hiring.wordcount.app;

import hiring.wordcount.service.InputReaderService;
import hiring.wordcount.service.ParserService;
import hiring.wordcount.service.ValidatorService;
import hiring.wordcount.util.WordCountServiceProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Program {
    private static final String FILE_INPUT_SERVICE = "FileInputService";
    private static final String INPUT_READER_SERVICE = "StandardIOService";
    private static final String PARSER_SERVICE = "WordParserService";
    private static final String STOP_WORD_VALIDATOR_SERVICE = "StopWordValidatorService";
    private static final String VALIDATOR_SERVICE = "WordValidatorService";
    private final String[] args;
    private final InputReaderService fileInputService;
    private final InputReaderService inputReaderService;
    private final ParserService parserService;
    private final ValidatorService stopWordService;
    private final ValidatorService validatorService;
    private Set<String> uniqueWords = new HashSet<>();

    public Program(String[] args) {
        this.args = args;

        inputReaderService =
                WordCountServiceProvider.load(InputReaderService.class, INPUT_READER_SERVICE);
        parserService = WordCountServiceProvider.load(ParserService.class, PARSER_SERVICE);
        validatorService =
                WordCountServiceProvider.load(ValidatorService.class, VALIDATOR_SERVICE);
        stopWordService =
                WordCountServiceProvider.load(ValidatorService.class, STOP_WORD_VALIDATOR_SERVICE);
        fileInputService =
                WordCountServiceProvider.load(InputReaderService.class, FILE_INPUT_SERVICE);

        initializeComponents();
    }

    private boolean argsCheck() {
        return args != null && args.length != 0 && args[0] != null && !args[0].isEmpty();
    }

    private void initializeComponents() {
        stopWordService.setValidatorResource(
                Objects.requireNonNull(WordCountApplication.class.getClassLoader().getResource("stopwords.txt"))
                        .getFile());
    }

    public void start() throws Exception {
        String line;
        if (argsCheck()) {
            line = fileInputService.read(args[0]);
        } else {
            line = inputReaderService.read(null);
        }

        final List<String> wordsAsList = parserService.getWordsAsList(line);
        List<String> validWords = new ArrayList<>();
        for (String word : wordsAsList) {
            if (validatorService.validate(word) && stopWordService.validate(word)) {
                validWords.add(word);
                uniqueWords.add(word);
            }
        }

        System.out.println("Number of words: " + validWords.size() + ", unique: " + uniqueWords.size());
    }
}
