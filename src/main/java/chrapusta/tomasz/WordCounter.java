package chrapusta.tomasz;

import java.util.Arrays;

public class WordCounter {
    public static void main(String[] args) {
        String input2 = "word word            wo3d";
        String input = "word word wo$d";

        String separator = "@!@";

        String separated = input.replaceAll("\\s+",separator);

        System.out.println(separated);

        long countWords = Arrays.stream(separated.split(separator))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .count();

        System.out.println(countWords);
    }
}
