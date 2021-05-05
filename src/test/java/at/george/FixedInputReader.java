package at.george;

import at.george.Reader;

public class FixedInputReader implements Reader {

    private final String input;

    public FixedInputReader(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input must not be null");
        }

        this.input = input;
    }

    @Override
    public String read() {
        return input;
    }
}
