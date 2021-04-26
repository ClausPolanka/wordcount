package chrapusta.tomasz;

public class ParamsValidator {

    static void validateParams(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please provide one argument!");
        }

        if (args[0] == null) {
            throw new IllegalArgumentException("Provided string is null! Please provide valid string");
        }
    }
}
