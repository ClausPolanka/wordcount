package at.george;

import java.util.Arrays;

public class TextSequenceCounter implements Processor {

    @Override
    public long process(String line) {
        return Arrays.stream(line.split(" "))
                .map(String::trim)
                .filter(word -> word.matches("[a-zA-Z]+"))
                .count();
    }
}
