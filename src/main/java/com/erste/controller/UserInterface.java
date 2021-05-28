package com.erste.controller;

public interface UserInterface {
    String getInput();

    default void show(long count, long uniqueCount) {
        System.out.println("Number of words: " + count + ", unique: " + uniqueCount);
    }
}
