package com.wordcount;


import com.wordcount.counter.Counter;

public class WordCountApplication {

    public static void main(String args[]){
        Counter counter = new Counter();
        System.out.println("Your first argument is: "+args[0]);
    }


}
