package dictionary;

import filereader.FileReader;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class Dictionary {
    private static final List<String> dictionary;

    static {
        dictionary = FileReader.readLines("dictionary.txt");
    }

    private Dictionary() {
        //private access
    }

    public static List<String> searchInDictionary(List<String> words) {
        List<Integer> unknownWordsIndexes = words.stream()
                .map(words::indexOf)
                .filter(wordIndex -> !dictionary.contains(words.get(wordIndex)))
                .collect(toList());

        List<String> finalWords = new ArrayList<>(words);
        unknownWordsIndexes.forEach(index -> finalWords.set(index, finalWords.get(index) + "*"));

        return finalWords;
    }
}
