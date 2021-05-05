package at.george;

import java.util.regex.Pattern;

public class WordCountConstants {

    public final static String SPLIT_SYMBOL = " ";
    public final static String DOT = ".";
    public final static String DASH = "-";

    public final static Pattern MATCH_LETTERS_REGEX = Pattern.compile("[a-zA-Z]+");
    public final static String STOPWORDS_FILE = "stopwords.txt";

    private WordCountConstants() {
    }
}
