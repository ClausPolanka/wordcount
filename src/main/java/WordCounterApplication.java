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
        int wordCount = f.countWords(text);

        return "Number of words: " + wordCount;
    }

}
