package parser;

public class InputParser {

    public static String[] extractWords(final String sentence) {
        if (sentence == null || sentence.trim().length() == 0) {
            return new String[0];
        }
        return sentence.trim().split("[\\s\\-]+");
    }

    public static String cleanWord(String word) {
        if (word == null || word.trim().equals("")) {
            return "";
        }
        word = word.trim();
        if (word.endsWith(".")) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

}
