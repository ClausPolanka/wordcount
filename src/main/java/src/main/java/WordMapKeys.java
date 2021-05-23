package src.main.java;

public enum WordMapKeys {
    TOTAL_WORDS("TotalWords"),
    UNIQUE_WORDS("UniqueWords"),
    TOTAL_WORDS_WITH_STOPPER("TotalWordsStopper"),
    TOTAL_AVG("TotalWordsAvg");

    private String keyName;

    WordMapKeys(String keyName)
    {
     this.keyName = keyName;
    }

    public String getKeyNameValue()
    {
        return keyName;
    }
}
