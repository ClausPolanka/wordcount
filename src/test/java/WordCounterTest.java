import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCounterTest {

    @ParameterizedTest
    @CsvSource(value = {"Mary had a little lamb;5", "tEst:test", "Java:java"}, delimiter = ';')
    public void okCorrectCounts(String input, int expected) {

    }

}
