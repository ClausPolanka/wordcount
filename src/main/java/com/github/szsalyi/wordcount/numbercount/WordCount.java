package com.github.szsalyi.wordcount.numbercount;

import java.io.IOException;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public interface WordCount {
    Long count(String input) throws IOException;
}
