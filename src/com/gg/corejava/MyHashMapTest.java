package com.gg.corejava;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void testMyHashMap(){

        MyHashMap map= new MyHashMap();
        map.put("hello","world");

        System.out.println(map.toString());
    }

}