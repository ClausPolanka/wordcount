package com.github.szsalyi.wordcount.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class UserIOImpl implements UserIO {

    private BufferedReader bufferedReader;

    public UserIOImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String userInput() throws IOException {
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
