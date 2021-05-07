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
        WordCounterOptions options = new WordCounterOptions();
        options.setStopWords(data.stopwords);
        WordCounter counter = new WordCounter(
                options
        );

        WordCounterOutput output = counter.calculateOutput(data.inputString);

        Assertions.assertEquals(data.expectedCount, output.getWordCount());
        Assertions.assertEquals(data.expectedUniqueCount, output.getUniqueCount());
        Assertions.assertEquals(data.expectedAvarageLength, output.getWordAverage());

    }

    public static class TestDataProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    arguments(
                            new TestData()
                                    .setInputString("Mary had a little lamb")
                                    .setExpectedWordCount(5)
                                    .setStopwords(emptySet())
                                    .setExpectedUniqueCount(5)
                                    .setExpectedAvarageLength(3.6)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(emptySet())
                                    .setExpectedAvarageLength(0.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("Mary")
                                    .setExpectedWordCount(1)
                                    .setExpectedUniqueCount(1)
                                    .setStopwords(emptySet())
                                    .setExpectedAvarageLength(4.0)
                    ),
                    arguments(
                            new TestData()
                                    .setStopwords(emptySet())
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setExpectedAvarageLength(0)
                                    .setInputString("Mary!")

                    ),

                    arguments(
                            new TestData()
                                    .setInputString("Mary_Mery")
                                    .setStopwords(emptySet())
                                    .setExpectedWordCount(0)
                                    .setExpectedUniqueCount(0)
                                    .setExpectedAvarageLength(0.0)
                    ),
                    arguments(
                            new TestData()
                                    .setInputString("word       word")
                                    .setExpectedUniqueCount(1)
                                    .setExpectedWordCount(2)
                                    .setStopwords(emptySet())
                                    .setExpectedAvarageLength(4.0)
                    ),
                    arguments(
                            new TestData()
                                    .setInputString("    word       word")
                                    .setExpectedUniqueCount(1)
                                    .setExpectedWordCount(2)
                                    .setStopwords(emptySet())
                                    .setExpectedAvarageLength(4.0)
                    ),
                    arguments(

                            new TestData()
                                    .setInputString("word\tword")
                                    .setExpectedUniqueCount(1)
                                    .setExpectedWordCount(2)
                                    .setStopwords(emptySet())
                                    .setExpectedAvarageLength(4.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("word the word a")
                                    .setExpectedUniqueCount(1)
                                    .setExpectedWordCount(2)
                                    .setStopwords(createStopwords("the a"))
                                    .setExpectedAvarageLength(4.0)

                    ),
                    arguments(

                            new TestData()
                                    .setInputString("  the a ")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a"))
                                    .setExpectedAvarageLength(0.0)

                    ),
                    arguments(
                            new TestData()
                                    .setInputString(" ")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a"))
                                    .setExpectedAvarageLength(0.0)

                    ),
                    arguments(
                            new TestData()
                                    .setInputString("theword")
                                    .setExpectedUniqueCount(1)
                                    .setExpectedWordCount(1)
                                    .setStopwords(createStopwords("the a"))
                                    .setExpectedAvarageLength(7.0)

                    ),
                    arguments(
                            new TestData()
                                    .setInputString("_the")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a"))
                                    .setExpectedAvarageLength(0.0)
                    ),
                    arguments(
                            new TestData()
                                    .setInputString("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")
                                    .setExpectedUniqueCount(6)
                                    .setExpectedWordCount(7)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(6.43)
                    ),
                    arguments(
                            new TestData()
                                    // notice "fall.." will be skipped
                                    .setInputString("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall..")
                                    .setExpectedUniqueCount(5)
                                    .setExpectedWordCount(6)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(6.83)
                    ),
                    arguments(
                            new TestData()
                                    .setInputString("Humpty--Dumpty")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(0.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("-")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(0.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("--")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(0.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("-Dumpty")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(0.0)
                    ),

                    arguments(
                            new TestData()
                                    .setInputString("Dumpty-")
                                    .setExpectedUniqueCount(0)
                                    .setExpectedWordCount(0)
                                    .setStopwords(createStopwords("the a on"))
                                    .setExpectedAvarageLength(0.0)
                    )

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
        private String inputString;
        private long expectedCount;
        private long expectedUniqueCount;
        private double expectedAvarageLength;
        private Set<String> stopwords;

        public String getInputString() {
            return inputString;
        }

        public TestData setInputString(String inputString) {
            this.inputString = inputString;
            return this;
        }

        public long getExpectedCount() {
            return expectedCount;
        }

        public TestData setExpectedWordCount(long expectedCount) {
            this.expectedCount = expectedCount;
            return this;
        }

        public long getExpectedUniqueCount() {
            return expectedUniqueCount;
        }

        public TestData setExpectedUniqueCount(long expectedUniqueCount) {
            this.expectedUniqueCount = expectedUniqueCount;
            return this;
        }

        public Set<String> getStopwords() {
            return stopwords;
        }

        public TestData setStopwords(Set<String> stopwords) {
            this.stopwords = stopwords;
            return this;
        }

        public double getExpectedAvarageLength() {
            return expectedAvarageLength;
        }

        public TestData setExpectedAvarageLength(double expectedAvarageLength) {
            this.expectedAvarageLength = expectedAvarageLength;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TestData{");
            sb.append("inputString='").append(inputString).append('\'');
            sb.append(", expectedCount=").append(expectedCount);
            sb.append(", expectedUniqueCount=").append(expectedUniqueCount);
            sb.append(", expecteAvarageLength=").append(expectedAvarageLength);
            sb.append(", stopwords=").append(stopwords);
            sb.append('}');
            return sb.toString();
        }
    }
}