package root.wordcounter;

import root.infrastructure.ConsoleInput;
import root.infrastructure.FileInput;

public class InputFactory {

    private final OutputInterface outputInterface;

    public InputFactory(OutputInterface outputInterface) {
        this.outputInterface = outputInterface;
    }


    public InputInterface createInput(String[] args) {
        if(args != null && args.length > 0) {
            return new FileInput(args[0]);
        }
        return new ConsoleInput(this.outputInterface);
    }

}
