package com.github.szsalyi.wordcount.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class UserIOImpl implements UserIO {

    private InputStreamReader inputStream;
    private BufferedReader bufferedReader;

    public UserIOImpl(InputStreamReader inputStream) {
        this.inputStream = inputStream;
        this.bufferedReader = new BufferedReader(inputStream);
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
