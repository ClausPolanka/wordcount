package console;

import java.util.Arrays;

public class ConsoleArguments {

    public static final String DICTIONARY_ARGS = "-dictionary";

    public static final String TXT_FORMAT = ".txt";

    private String inputArgs;

    public ConsoleArguments(String inputArgs) {
        this.inputArgs = inputArgs;
    }

    public String extractExternalResourcePath() {
        return Arrays.stream(inputArgs.split(" "))
                .filter(arg -> arg.contains(TXT_FORMAT) && !arg.contains(DICTIONARY_ARGS))
                .findFirst()
                .orElse("");
    }

    public Boolean isShowIndexPresent() {
        return inputArgs.contains("-index");
    }

    public String extractDictionaryPath() {
        return Arrays.stream(inputArgs.split(" "))
                .filter(arg -> arg.contains(DICTIONARY_ARGS))
                .flatMap(arg -> Arrays.stream(arg.split("=")))
                .filter(arg -> arg.contains(TXT_FORMAT))
                .findFirst()
                .orElse("");
    }
}
