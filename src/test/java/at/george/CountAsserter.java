package at.george;

import at.george.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAsserter implements Writer {

    private final long expectedCount;

    public CountAsserter(long expectedCount) {
        this.expectedCount = expectedCount;
    }

    @Override
    public void write(long count) {
        assertEquals(this.expectedCount, count);
    }
}
