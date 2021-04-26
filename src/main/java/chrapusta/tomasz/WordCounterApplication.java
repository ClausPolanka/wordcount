package chrapusta.tomasz;

import chrapusta.tomasz.repository.CommandLine;
import chrapusta.tomasz.repository.FileStructure;
import chrapusta.tomasz.repository.StopWordsRepository;
import chrapusta.tomasz.repository.WordRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public class WordCounterApplication {

    private final WordRepository wordRepository;
    private final StopWordsRepository stopWordsRepository;

    public WordCounterApplication(final WordRepository wordRepository,
                                  final StopWordsRepository stopWordsRepository) {
        this.wordRepository = wordRepository;
        this.stopWordsRepository = stopWordsRepository;
    }

    public void execute() throws IOException, URISyntaxException {
        String[] inputString = wordRepository.getInput();
        String separator = "@!@";
        Set<String> stopWords = stopWordsRepository.getStopWords();
        WordCounter wordCounter = new WordCounter(separator, stopWords);
        long countWords = wordCounter.countWords(inputString[0]);
        wordRepository.writeCount(countWords);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ParamsValidator.validateParams(args);
        WordRepository wordRepository = new CommandLine();
        wordRepository.setValidatedInput(args);

        StopWordsRepository stopWordsRepository = new FileStructure();
        WordCounterApplication app = new WordCounterApplication(wordRepository, stopWordsRepository);

        app.execute();
    }
}
