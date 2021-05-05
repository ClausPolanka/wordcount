package sk.sloboda.wordcount.common;

import sk.sloboda.wordcount.model.WordCount;

public interface WordCounter {

    WordCount countWords(String input);
}
