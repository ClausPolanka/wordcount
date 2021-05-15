package com.akhvatov.words;

import com.akhvatov.words.aggregator.Aggregator;
import com.akhvatov.words.filter.Filter;
import com.akhvatov.words.modifier.Modifier;
import com.akhvatov.words.source.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WordsProcessorTest {

    static final String INPUT = "test words";

    final Modifier       modifier       = mock(Modifier.class);
    final Filter         filter         = mock(Filter.class);
    final Aggregator     aggregator     = mock(Aggregator.class);
    final Source         source         = mock(Source.class);
    final WordsProcessor wordsProcessor = new WordsProcessor(
            Collections.singletonList(modifier), Collections.singletonList(filter), Collections.singletonList(aggregator)
    );

    @BeforeEach
    void setUp() {
        when(source.read()).thenReturn(Stream.of(INPUT));
        when(modifier.apply(anyString(), any())).thenReturn("modified");
        when(filter.test(anyString(), any())).thenReturn(true);
    }

    @Test
    void shouldProcessInputFilterAggregateAndReturnState() {
        // when
        final State countState = wordsProcessor.count(source);

        // then
        assertThat(countState).isNotNull();

        verify(modifier).apply("test", countState);
        verify(modifier).apply("words", countState);
        verify(filter, times(2)).test("modified", countState);
        verify(aggregator, times(2)).aggregate("modified", countState);
    }

    @Test
    void shouldNotAggregateFilteredOutWords() {
        // given
        when(filter.test(anyString(), any())).thenReturn(false);

        // when
        final State countState = wordsProcessor.count(source);

        // then
        assertThat(countState).isNotNull();

        verify(modifier).apply("test", countState);
        verify(modifier).apply("words", countState);
        verify(filter, times(2)).test("modified", countState);
        verifyNoInteractions(aggregator);
    }

    @Test
    void shouldApplyAllModifications() {
        // given
        final String word = "word";
        when(modifier.apply(anyString(), any())).thenReturn("modified1", "modified2");
        final WordsProcessor wordsProcessor = new WordsProcessor(
                Arrays.asList(modifier, modifier), Collections.singletonList(filter), Collections.singletonList(aggregator)
        );

        // when
        final State state = wordsProcessor.count(() -> Stream.of(word));

        // then
        verify(modifier).apply(word, state);
        verify(modifier).apply("modified1", state);
        verify(filter).test("modified2", state);
        verify(aggregator).aggregate("modified2", state);
    }
}
