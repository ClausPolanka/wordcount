package com.akhvatov.words;

import com.akhvatov.words.aggregator.Aggregator;
import com.akhvatov.words.aggregator.WordCountAggregator;
import com.akhvatov.words.filter.Filter;
import com.akhvatov.words.filter.StopWordsFilter;
import com.akhvatov.words.filter.WordFilter;
import com.akhvatov.words.modifier.Modifier;
import com.akhvatov.words.modifier.WordCleaner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WordsProcessorIntegrationTest {

    final Modifier   wordCleaner     = new WordCleaner();
    final Filter     wordFilter      = new WordFilter();
    final Filter     stopWordsFilter = new StopWordsFilter(Stream.of("the", "a", "on", "off"));
    final Aggregator countAggregator = new WordCountAggregator();

    @Test
    void wordCountI() {
        // given
        final WordsProcessor wordsProcessor = new WordsProcessor(
                Collections.singletonList(wordCleaner),
                Collections.singletonList(wordFilter),
                Collections.singletonList(countAggregator)
        );

        // when
        final State state = wordsProcessor.count(() -> Stream.of("Mary had a little lamb"));

        // then
        assertThat(state.getCount()).isEqualTo(5);
    }

    @Test
    void wordCountII() {
        // given
        final WordsProcessor wordsProcessor = new WordsProcessor(
                Collections.singletonList(wordCleaner),
                Arrays.asList(wordFilter, stopWordsFilter),
                Collections.singletonList(countAggregator)
        );

        // when
        final State state = wordsProcessor.count(() -> Stream.of("Mary had a little lamb"));

        // then
        assertThat(state.getCount()).isEqualTo(4);
    }
}
