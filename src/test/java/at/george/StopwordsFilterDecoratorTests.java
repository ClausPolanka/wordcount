package at.george;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopwordsFilterDecoratorTests {

    private final Counter textSequenceCounterWithStopwordsFilter = new StopwordsFilterDecorator(new TextSequenceCounter());

    @Test
    public void testWithNoStopswords() {
        long count = textSequenceCounterWithStopwordsFilter.count("test test");

        assertEquals(2, count);
    }

    @Test
    public void testWithSomeStopswords() {
        long count = textSequenceCounterWithStopwordsFilter.count("a a test test");

        assertEquals(2, count);
    }

    @Test
    public void testWithAllStopswords() {
        long count = textSequenceCounterWithStopwordsFilter.count("the a on off");

        assertEquals(0, count);
    }

}
