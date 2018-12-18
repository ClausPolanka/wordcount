import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private static final String stopWordsFilePath = "stopwords.txt";

    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = fetchInputStringFromPath(args[0]);
        } else {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter text: ");
            input = reader.nextLine();
        }


        if (isValidInput(input)) {
            System.out.println("Number of words: " + countValidWords(input, fetchLinesFromFile(stopWordsFilePath)));
        } else {
            System.out.println("Invalid input! Please only enter lower-case, upper-case or whitespace characters only");
        }
    }

    static boolean isValidInput(String input) {
        Pattern alphaAndWhitespaceOnlyPattern = Pattern.compile("^[A-Za-z ]*$");
        Matcher matcher = alphaAndWhitespaceOnlyPattern.matcher(input);
        return matcher.find();
    }

    static long countValidWords(String text) {
        return countValidWords(text, Collections.emptyList());
    }

    static long countValidWords(String text, Collection<String> stopWords) {
        if (text.isEmpty()) {
            return 0;
        }

        return Stream.of(text.split("\\s+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .count();
    }

    static String fetchInputStringFromPath(String path) {
        return fetchLinesFromFile(path).stream()
                .collect(Collectors.joining(" "));
    }

    static Collection<String> fetchLinesFromFile(String path) {
        try {
            URL url = WordCounter.class.getResource(path);
            return Files.lines(Paths.get(url.toURI())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("StopWords file could not be read at path " + path + "!", e);
        }
    }

}
