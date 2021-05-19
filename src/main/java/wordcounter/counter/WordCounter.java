package wordcounter.counter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int countWords() {
        String[] candidates = text.trim().split(" ");
        List<String> result = Arrays.stream(candidates).filter(w -> w.matches("[a-zA-Z]+")).collect(Collectors.toList());
        return result.size();
    }
}
