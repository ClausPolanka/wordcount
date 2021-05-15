package com.akhvatov.words.source;

import java.util.stream.Stream;

/**
 * Source of words for application
 */
public interface Source {

    Stream<String> read();
}
