package chrapusta.tomasz;

import chrapusta.tomasz.repository.CommandLine;
import chrapusta.tomasz.repository.WordRepository;

public class WordCounterApplication {

    private final WordRepository wordRepository;

    public WordCounterApplication(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public void execute() {
        String[] inputString = wordRepository.getInput();
        String separator = "@!@";
        WordCounter wordCounter = new WordCounter(separator);
        long countWords = wordCounter.countWords(inputString[0]);
        wordRepository.writeCount(countWords);
    }

    public static void main(String[] args) {
        ParamsValidator.validateParams(args);
        WordRepository repository = new CommandLine();
        repository.setValidatedInput(args);

        WordCounterApplication app = new WordCounterApplication(repository);

        app.execute();
    }
}
