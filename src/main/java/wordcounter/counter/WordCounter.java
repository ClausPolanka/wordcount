package wordcounter.counter;

import wordcounter.reader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {
    private String text;
    private FileReader fileReader;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public int countWords() {
        List<String> content = fileReader.getContent();
        String[] candidates = text.trim().split(" ");
        List<String> result = Arrays.stream(candidates)
                .filter(w -> w.matches("[a-zA-Z]+") && !content.contains(w))
                .collect(Collectors.toList());
        return result.size();
    }
}
