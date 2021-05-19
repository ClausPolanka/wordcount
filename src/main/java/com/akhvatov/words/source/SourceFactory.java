package com.akhvatov.words.source;

/**
 * Get source by application parameters
 */
public class SourceFactory {

    public Source getSource(String[] args) {
        if (args.length == 0) {
            return new ConsoleSource();
        }
        return new FileSource(args[0]);
    }
}
