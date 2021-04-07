package com.wordcount;


import com.wordcount.counter.Counter;

import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCountApplication {

    public static void main(String args[]){
        Counter counter = new Counter();

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Please enter your input: ");
        String input = scanner.nextLine();

        long numberOfWords = counter.countWords(input);
        System.out.println("Number of words: " + numberOfWords);
    }


}
