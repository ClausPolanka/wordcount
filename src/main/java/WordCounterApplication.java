public class WordCounterApplication {

    private final String[] args;

    public WordCounterApplication(String[] args) {
        this.args = args;
    }

    public String countWordsFromInput() {
        InputHandler handler = InputHandlerFactory.create(args);
        String text = handler.getInputText();
        StopWords stopWords = new StopWords();
        WordCounterService f = new WordCounterService(stopWords.stopWordsAsList());
        f.countWords(text);
        int wordCount = f.getTotalWordCount();
        int uniqueWordCount = f.getUniqueWordCount();

        return "Number of words: " + wordCount + ", unique: " + uniqueWordCount;
    }

}
