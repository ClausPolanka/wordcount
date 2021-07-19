import java.io.ByteArrayInputStream;

public class InputHandlerFactory {

    public static InputHandler create(String[] args) {
        if (args!= null && args.length > 0) {
            return new FileInputHandler(args[0]);
        } else {
            return new ConsoleInputHandler(System.in);
        }
    }
}
