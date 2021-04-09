package model;

public class WordDetailsDTO {

    private int count;
    private int uniqueCount;
    private double averageLength;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }

    public void setUniqueCount(int uniqueCount) {
        this.uniqueCount = uniqueCount;
    }

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }
}
