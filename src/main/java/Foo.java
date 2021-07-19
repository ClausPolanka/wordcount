import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Foo {

    public int countWords(String input) {
        String[] strings = input.split("\\s");
        return strings.length;
    }
}
