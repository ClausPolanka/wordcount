package chrapusta.tomasz;

import chrapusta.tomasz.repository.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public class WordCounterApplication {

    private final WordRepository wordRepository;
    private final FileStructureRepository fileStructureRepository;
    private final WordCounterProvider wordCounterProvider;

    public WordCounterApplication(final WordRepository wordRepository,
                                  final FileStructureRepository fileStructureRepository,
                                  final WordCounterProvider wordCounterProvider) {
        this.wordRepository = wordRepository;
        this.fileStructureRepository = fileStructureRepository;
        this.wordCounterProvider = wordCounterProvider;
    }

    public void execute(String[] args) throws IOException, URISyntaxException {
        String word = wordCounterProvider.provideWord(args);
        String separator = "@!@";
        Set<String> stopWords = fileStructureRepository.readAllLines("/stopwords.txt");
        WordCounter wordCounter = new WordCounter(separator, stopWords);
        long countWords = wordCounter.countWords(word);
        wordRepository.writeCount(countWords);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        WordRepository wordRepository = new CommandLineRepository();
        FileStructureRepository fileStructureRepository = new FileStructureRepositoryImpl();
        WordCounterProvider wordCounterProvider = new WordCounterProvider(wordRepository, fileStructureRepository);
        WordCounterApplication app = new WordCounterApplication(wordRepository, fileStructureRepository, wordCounterProvider);

        app.execute(args);
    }
}
