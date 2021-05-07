package wordcount.iter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordCounterTest {

    @ArgumentsSource(TestDataProvider.class)
    @ParameterizedTest
    void givenSimpleText_thenWordCountIsCorrect(TestData data) {
        WordCounter counter = new WordCounter();

        long output = counter.count(data.inputString);

        Assertions.assertEquals(data.expectedCount, output);

    }

    public static class TestDataProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    arguments(new TestData("Mary had a little lamb", 5)),
                    arguments(new TestData("", 0)),
                    arguments(new TestData("Mary", 1)),
                    arguments(new TestData("Mary!", 0)),
                    arguments(new TestData("Mary_Mery", 0)),
                    arguments(new TestData("word       word", 2)),
                    arguments(new TestData("    word       word", 2)),
                    arguments(new TestData("word\tword", 0))
            );

        }
    }


    static class TestData {
        private String inputString;
        private long expectedCount;

        public TestData(String inputString, long expectedCount) {
            this.inputString = inputString;
            this.expectedCount = expectedCount;
        }
    }
}