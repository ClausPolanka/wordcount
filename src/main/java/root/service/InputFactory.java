package root.service;

import root.service.impl.ConsoleWordInput;
import root.service.impl.FileWordInput;
import root.service.impl.InvalidUserInputException;

public class InputFactory {

    private final OutputInterface outputInterface;

    public InputFactory(OutputInterface outputInterface) {
        this.outputInterface = outputInterface;
    }


    public WordInputInterface createInput(String[] args) {
        if(args != null && args.length > 0) {
            try {
                return new FileWordInput(args[0]);
            } catch (InvalidUserInputException e) {
                this.outputInterface.print(e.getMessage()+ "\n");
            }
        }
        return new ConsoleWordInput(this.outputInterface);
    }

}
