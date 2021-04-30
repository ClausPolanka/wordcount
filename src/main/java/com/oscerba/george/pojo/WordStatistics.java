package com.oscerba.george.pojo;

public class WordStatistics {

    private final long count;
    private final long uniqueCount;
    private final double lengthAvg;

    public WordStatistics(long count, long uniqueCount, double lengthAvg) {
        this.count = count;
        this.uniqueCount = uniqueCount;
        this.lengthAvg = lengthAvg;
    }

    public long getCount() {
        return count;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }

    public double getLengthAvg() {
        return lengthAvg;
    }
}
