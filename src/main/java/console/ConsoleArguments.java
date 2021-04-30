package console;

import java.util.Arrays;

public class ConsoleArguments {
    private String inputArgs;

    public ConsoleArguments(String inputArgs) {
        this.inputArgs = inputArgs;
    }

    public String extractExternalResourcePath() {
        return Arrays.stream(inputArgs.split(" "))
                .filter(arg -> arg.contains(".txt") && !arg.contains("-dictionary"))
                .findFirst()
                .orElse("");
    }
}
