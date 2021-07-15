
public class Foo {
    public int countWords(String input) {
        String[] strings = input.split("\\s");

        // check special chars within the word
        int nonWords = notWordsCount(strings);

        return strings.length - nonWords;
    }

    private int notWordsCount(String[] strings) {
        int nonWords = 0;

        for (String word: strings) {
            if (isNonWord(word)) {
                nonWords ++;
            }
        }

        return nonWords;
    }

    private boolean isNonWord(String word) {
        String[] nonWordParts = word.split("\\W");
        if (nonWordParts.length > 1) {
            return true;
        }
        return false;
    }
}
