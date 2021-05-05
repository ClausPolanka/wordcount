package sk.sloboda.wordcount.model;

public class WordCount {

    private int count = 0;
    private int uniqueCount = 0;

    public WordCount() {
    }

    public WordCount(int count, int uniqueCount) {
        this.count = count;
        this.uniqueCount = uniqueCount;
    }

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
}
