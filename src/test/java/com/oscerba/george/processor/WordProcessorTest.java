package com.oscerba.george.processor;

import com.oscerba.george.pojo.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordProcessorTest {

    @Test
    public void testWordCount() {
        long countActual = new WordProcessor(Collections.singletonList("ahoj"), new ArrayList<>(), new HashSet<>()).getStatistics().getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordWithHyphenCount() {
        long countActual = new WordProcessor(Collections.singletonList("Humpty-Dumpty"), new ArrayList<>(), new HashSet<>()).getStatistics().getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordWithDotCount() {
        long countActual = new WordProcessor(Collections.singletonList("Dot."), new ArrayList<>(), new HashSet<>()).getStatistics().getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountWithInvalidCharacters() {
        List<String> words = new ArrayList<>();
        words.add("ahoj2");
        words.add("Ahoj?");

        long countActual = new WordProcessor(words, new ArrayList<>(), new HashSet<>()).getStatistics().getCount();

        Assertions.assertEquals(0, countActual);
    }

    @Test
    public void testWordLengthAvg() {
        List<String> words = new ArrayList<>();
        words.add("aaaaaaaaaa"); //10 chars
        words.add("aaaaa"); // 5 chars

        double countActual = new WordProcessor(words, new ArrayList<>(), new HashSet<>()).getStatistics().getLengthAvg();

        Assertions.assertEquals(7.50, countActual);
    }

    @Test
    public void testWordIndex() {
        List<String> words = new ArrayList<>();
        words.add("aaaaa");
        words.add("aaaaaaaaaa");

        List<String> wordsActual = new WordProcessor(words, new ArrayList<>(), new HashSet<>()).getStatistics().getIndex().stream().map(Word::getWord).collect(Collectors.toList());

        Assertions.assertEquals(words, wordsActual);
    }

    @Test
    public void testWordIndexDictionary() {
        Word word1 = new Word("aaaaa", true);
        Word word2 = new Word("aaaaaaaaaa", false);
        List<Word> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);

        HashSet<String> dictionary = new HashSet<>();
        dictionary.add(word1.getWord());
        List<Word> wordsActual = new WordProcessor(words.stream().map(Word::getWord).collect(Collectors.toList()), new ArrayList<>(), dictionary).getStatistics().getIndex();

        Assertions.assertEquals(words, wordsActual);
    }

    @Test
    public void testSameWordsIndexDictionary() {
        Word word1 = new Word("aaaaa", true);

        List<Word> wordsInput = new ArrayList<>();
        wordsInput.add(word1);
        wordsInput.add(word1);

        HashSet<String> dictionary = new HashSet<>();
        dictionary.add(word1.getWord());
        List<Word> wordsActual = new WordProcessor(wordsInput.stream().map(Word::getWord).collect(Collectors.toList()), new ArrayList<>(), dictionary).getStatistics().getIndex();

        Assertions.assertEquals(Collections.singletonList(word1), wordsActual);
    }

    @Test
    public void testWordNotInDictionary() {
        List<String> words = new ArrayList<>();
        words.add("aaaaa");
        words.add("aaaaaaaaaa");

        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("aaaaa");
        long wordsActual = new WordProcessor(words, new ArrayList<>(), dictionary).getStatistics().getWordNoInDictCount();

        Assertions.assertEquals(1, wordsActual);
    }

    @Test
    public void testWordCountUnique() {
        List<String> words = new ArrayList<>();
        words.add("ahoj");
        words.add("ahoj");

        long countActual = new WordProcessor(words, new ArrayList<>(), new HashSet<>()).getStatistics().getUniqueCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountIncludedInStopWords() {
        List<String> words = Collections.singletonList("on");
        List<String> stopWords = Collections.singletonList("on");

        long countActual = new WordProcessor(words, stopWords, new HashSet<>()).getStatistics().getCount();

        Assertions.assertEquals(0, countActual);
    }
}
