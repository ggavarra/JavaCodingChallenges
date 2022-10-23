package com.gg.gs.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There is a String array String[]
 * words = {"hello", "world", "HELLO", "WORLD"};
 * How will you print output like hello-2, world-2 i.e. word followed by its count ignoring the case of the words in the input Array?
 */
public class WordCount {
    public static void main(String[] args) {
        //linear search
        List<String> rawWords=List.of("hello", "world", "HELLO", "WORLD");
        List<String> lowerCaseWords=rawWords.stream().map(x->x.toLowerCase()).collect(Collectors.toList());
        lowerCaseWords.stream().distinct().forEach(x-> System.out.println(x+"-"+Collections.frequency(lowerCaseWords,x)));

    }
}
