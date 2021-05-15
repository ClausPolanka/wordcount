package com.akhvatov.words.source;

import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleSource implements Source {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Stream<String> read() {
        System.out.print("Enter text: ");
        return Stream.of(scanner.nextLine());
    }
}
