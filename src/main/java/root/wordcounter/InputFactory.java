package root.wordcounter;

import root.infrastructure.ConsoleInput;
import root.infrastructure.FileInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFactory {

    private final OutputInterface outputInterface;

    public InputFactory(OutputInterface outputInterface) {
        this.outputInterface = outputInterface;
    }


    public InputInterface createInput(String filename) {
        if(filename != null) {
            return new FileInput(filename);
        }
        return new ConsoleInput(this.outputInterface);
    }

}
