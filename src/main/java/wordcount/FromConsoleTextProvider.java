package wordcount;

public class FromConsoleTextProvider implements InputTextProvider {
    private final ConsoleInteractor consoleInteractor;

    public FromConsoleTextProvider(ConsoleInteractor consoleInteractor) {
        this.consoleInteractor = consoleInteractor;
    }

    @Override
    public String readInputText() {
        return consoleInteractor.read();
    }
}
