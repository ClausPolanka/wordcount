package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordCounterTest {

    @ArgumentsSource(TestDataProvider.class)
    @ParameterizedTest
    void givenSimpleText_thenWordCountIsCorrect(TestData data) {
        WordCounter counter = new WordCounter();

        long output = counter.count(data.inputString, data.stopwords);

        Assertions.assertEquals(data.expectedCount, output);

    }

    public static class TestDataProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    arguments(new TestData("Mary had a little lamb", 5, emptySet())),
                    arguments(new TestData("", 0, emptySet())),
                    arguments(new TestData("Mary", 1, emptySet())),
                    arguments(new TestData("Mary!", 0, emptySet())),
                    arguments(new TestData("Mary_Mery", 0, emptySet())),
                    arguments(new TestData("word       word", 2, emptySet())),
                    arguments(new TestData("    word       word", 2, emptySet())),
                    arguments(new TestData("word\tword", 0, emptySet())),

                    arguments(new TestData("word the word a", 2, createStopwords("the a"))),
                    arguments(new TestData("  the a ", 0, createStopwords("the a"))),
                    arguments(new TestData(" ", 0, createStopwords("the a"))),
                    arguments(new TestData("theword", 1, createStopwords("the a"))),
                    arguments(new TestData("_the", 0, createStopwords("the a")))
            );

        }

        /**
         * Creates a set of string by splitting string by space
         */
        private Set<String> createStopwords(String testStr) {
            return Arrays.stream(testStr.split("\\s+"))
                    .collect(Collectors.toSet());
        }
    }


    static class TestData {
        private final String inputString;
        private final long expectedCount;
        private final Set<String> stopwords;

        public TestData(String inputString, long expectedCount, Set<String> stopwords) {
            this.inputString = inputString;
            this.expectedCount = expectedCount;
            this.stopwords = stopwords;
        }
    }
}