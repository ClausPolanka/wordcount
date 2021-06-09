package root.wordcounter.data;

public class Args {

    private final String filename;
    private final boolean index;

    public Args(String filename, boolean index) {
        this.filename = filename;
        this.index = index;
    }

    public String getFilename() {
        return filename;
    }

    public boolean printIndex() {
        return index;
    }

}
