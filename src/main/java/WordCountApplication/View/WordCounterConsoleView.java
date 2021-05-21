package WordCountApplication.View;

public class WordCounterConsoleView implements WordCountApplication.Controller.Interfaces.View {

    @Override
    public void updateView(String message) {
        System.out.println(message);
    }
}
