package View;

public class WordCounterConsoleView implements Controller.Interfaces.View {

    @Override
    public void updateView(String message) {
        System.out.println(message);
    }
}
