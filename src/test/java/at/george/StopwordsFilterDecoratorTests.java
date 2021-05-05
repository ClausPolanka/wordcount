package at.george;

import at.george.counter.StopwordsFilterDecorator;
import at.george.counter.TextSequenceCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopwordsFilterDecoratorTests {

    private final Counter textSequenceCounterWithStopwordsFilter = new StopwordsFilterDecorator(new TextSequenceCounter(), new FixedStopwordsProvider());

    @Test
    public void testWithNoStopwords() {
        long count = textSequenceCounterWithStopwordsFilter.count("test test");

        assertEquals(2, count);
    }

    @Test
    public void testWithSomeStopwords() {
        long count = textSequenceCounterWithStopwordsFilter.count("a a A A I i test test on off");

        assertEquals(4, count);
    }

    @Test
    public void testWithAllStopwords() {
        long count = textSequenceCounterWithStopwordsFilter.count("THE a I i a ThE");

        assertEquals(0, count);
    }

}
