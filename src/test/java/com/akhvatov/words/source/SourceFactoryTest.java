package com.akhvatov.words.source;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SourceFactoryTest {

    final SourceFactory factory = new SourceFactory();

    @Test
    void shouldReturnConsoleSource() {
        // when
        final Source source = factory.getSource(new String[0]);

        // then
        assertThat(source).isInstanceOf(ConsoleSource.class);
    }

    @Test
    void shouldReturnFileSource() {
        // when
        final Source source = factory.getSource(new String[] { "myfile.txt" });

        // then
        assertThat(source).isInstanceOf(FileSource.class);
    }
}
