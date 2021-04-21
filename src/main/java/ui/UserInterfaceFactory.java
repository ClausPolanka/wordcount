package ui;

public class UserInterfaceFactory {

    public static UserInterface createUserInterface(String[] cliArgs) {
        if (cliArgs == null || cliArgs.length == 0) {
            return new ConsoleUserInterface(System.out);
        } else {
            return new InputFileUserInterface(System.out, cliArgs[0]);
        }
    }

}
