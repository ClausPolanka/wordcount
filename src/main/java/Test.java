import src.main.java.api.Foo;
import src.main.java.api.WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        WordCount foo = new Foo();
        System.out.println(String.format("word counted %d, unique words: %d, average size word is: %f",foo.countWords(input),foo.countUniqueWords(input), foo.getWordAvgLength(input)));
        System.out.println(String.format("word counted with stopper %d", foo.countWordsWithStopper(input)));
    }
}
