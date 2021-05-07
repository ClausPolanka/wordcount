package wordcount;

public class WordCounterApplication {
    private ResponseBuilder responseBuilder = new ResponseBuilder();
    private final ConsoleInteractor consoleInteractor;
    private final StopwordsProvider stopwordsProvider;
    private WordCounterOptions defaultOptions = new WordCounterOptions();

    public WordCounterApplication(ConsoleInteractor consoleInteractor,
                                  StopwordsProvider stopwordsProvider) {
        this.consoleInteractor = consoleInteractor;
        this.stopwordsProvider = stopwordsProvider;
    }

    public void run(String[] args) {
        defaultOptions.setStopWords(stopwordsProvider.getStopWords());
        WordCounter wordCounter = new WordCounter(defaultOptions);

        String inputText = createTextProvider(args).readInputText();

        long count = wordCounter.count(inputText);

        consoleInteractor.write(responseBuilder.createOutputMessage(count));

    }

    private InputTextProvider createTextProvider(String[] args) {
        InputTextProvider textProvider;
        if (args.length > 0) {
            textProvider = new FromFileInputTextProvider(args[0]);
        } else {
            textProvider = new FromConsoleTextProvider(consoleInteractor);
        }
        return textProvider;
    }

}
