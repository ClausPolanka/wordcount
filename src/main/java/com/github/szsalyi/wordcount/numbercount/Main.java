package com.github.szsalyi.wordcount.numbercount;

import com.github.szsalyi.wordcount.io.UserIO;
import com.github.szsalyi.wordcount.io.UserIOImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserIO userIO = new UserIOImpl(bufferedReader);
        ContentSplit contentSplit = new ContentSplitImpl(" ");

        WordCheck wordCheck = new WordCheckImpl();
    }
}
