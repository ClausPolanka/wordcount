package wordcount;

public class WordCounterApplication {
    private ResponseBuilder responseBuilder = new ResponseBuilder();
    private WordCounter wordCounter = new WordCounter();
    private final ConsoleInteractor consoleInteractor;
    private final StopwordsProvider stopwordsProvider;

    public WordCounterApplication(ConsoleInteractor consoleInteractor, StopwordsProvider stopwordsProvider) {
        this.consoleInteractor = consoleInteractor;
        this.stopwordsProvider = stopwordsProvider;
    }

    public void run() {
        String inputLine = consoleInteractor.read();

        long count = wordCounter.count(inputLine, stopwordsProvider.getStopWords());

        consoleInteractor.write(responseBuilder.createOutputMessage(count));

    }

}
