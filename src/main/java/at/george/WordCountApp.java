package at.george;

public class WordCountApp {

    public static void main(String[] args) {

        WordCountConfiguration configuration = new WordCountConfiguration(
                new ConsoleReader(),
                new StopwordsFilter(new TextSequenceCounter()),
                new ConsoleWriter()
        );

        new WordCountRunner().run(configuration);
    }
}
