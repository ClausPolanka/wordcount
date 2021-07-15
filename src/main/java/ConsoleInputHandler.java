import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private final InputStream inputStream;

    public ConsoleInputHandler(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String getInputText() {
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Enter text:");
        return scanner.nextLine();
    }

}
