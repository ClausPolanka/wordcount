package com.erste.controller;

public interface UserInterface {
    String getInput();
    default void show(long count) {
        System.out.println("Number of words: " + count);
    }
}
