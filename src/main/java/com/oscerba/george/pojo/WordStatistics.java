package com.oscerba.george.pojo;

public class WordStatistics {

    private final long count;
    private final long uniqueCount;

    public WordStatistics(long count, long uniqueCount) {
        this.count = count;
        this.uniqueCount = uniqueCount;
    }

    public long getCount() {
        return count;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }
}
