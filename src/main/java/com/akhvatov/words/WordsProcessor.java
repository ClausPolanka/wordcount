package com.akhvatov.words;

import com.akhvatov.words.aggregator.Aggregator;
import com.akhvatov.words.filter.Filter;
import com.akhvatov.words.modifier.Modifier;
import com.akhvatov.words.source.Source;

import java.util.Arrays;
import java.util.List;

/**
 * Reads the input, splits it around SPACE, applies modifications for each word, filters them and if words is valid will apply
 * processors for each of them
 */
public class WordsProcessor {

    private static final String SEPARATOR = " ";

    private final List<Modifier>   modifiers;
    private final List<Filter>     filters;
    private final List<Aggregator> aggregators;

    public WordsProcessor(
            List<Modifier> modifiers,
            List<Filter> filters,
            List<Aggregator> aggregators
    ) {
        this.modifiers = modifiers;
        this.filters = filters;
        this.aggregators = aggregators;
    }

    public State count(Source source) {
        final State state = new State();

        source.read()
                .flatMap(input -> Arrays.stream(input.split(SEPARATOR)))
                .map(word -> applyModification(word, state))
                .filter(word -> applyFilters(word, state))
                .forEach(word -> aggregateWords(word, state));

        return state;
    }

    private void aggregateWords(String word, State state) {
        aggregators.forEach(processor -> processor.aggregate(word, state));
    }

    private boolean applyFilters(String word, State state) {
        return filters.stream().allMatch(filter -> filter.test(word, state));
    }

    private String applyModification(String word, State state) {
        for (Modifier modifier : modifiers) {
            word = modifier.apply(word, state);
        }
        return word;
    }
}
