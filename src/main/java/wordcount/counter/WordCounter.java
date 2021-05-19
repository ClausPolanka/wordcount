package wordcount.counter;

public class WordCounter {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int countWords() {
        return text.trim().split(" ").length;
    }
}
