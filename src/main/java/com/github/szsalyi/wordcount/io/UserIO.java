package com.github.szsalyi.wordcount.io;

import java.io.IOException;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public interface UserIO {
    String userInput() throws IOException;
}
