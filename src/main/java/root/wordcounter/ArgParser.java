package root.wordcounter;

import root.wordcounter.data.Args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgParser {

    public static Args parseArgs(String[] args) {
        String filename = null;
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        boolean index = argList.contains("-index");

        argList.remove("-index");
        if(!argList.isEmpty()) {
            filename = argList.get(0);
        }
        return new Args(filename, index);
    }

}
