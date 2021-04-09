package service;

public class WordCountService {

    public static int getWordCount(String str){

        return str.split("[a-z]").length;

    }
}
