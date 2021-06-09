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


    public InputInterface createInput(String[] args) {
        if(args != null) {
            List<String> argList = new ArrayList<>(Arrays.asList(args));
            argList.remove("-index");
            if(!argList.isEmpty()) {
                return new FileInput(args[0]);
            }
        }
        return new ConsoleInput(this.outputInterface);
    }

}
