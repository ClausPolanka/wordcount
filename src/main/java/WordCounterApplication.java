import java.util.Locale;

public class WordCounterApplication {

    private final String[] args;

    public WordCounterApplication(String[] args) {
        this.args = args;
    }

    public String countWordsFromInput() {
        InputHandler handler = InputHandlerFactory.create(args);
        String text = handler.getInputText();
        StopWords stopWords = new StopWords();
        WordCounterService wordCounterService = new WordCounterService(stopWords.stopWordsAsList());
        wordCounterService.countWords(text);
        int wordCount = wordCounterService.getTotalWordCount();
        int uniqueWordCount = wordCounterService.getUniqueWordCount();
        double averageLength = wordCounterService.getAverageWordLength();

        return String.format(Locale.GERMAN,"Number of words: %d, unique: %d, average word length: %.2f", wordCount, uniqueWordCount, averageLength);
    }

}
