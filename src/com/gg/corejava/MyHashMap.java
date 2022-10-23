package com.gg.corejava;

import java.util.ArrayList;
import java.util.List;

//How will you implement your own hashmap in Java? How will you handle collision of keys?
 public class MyHashMap {

        //List list = new ArrayList<MyHashMapEntry>();
        List list= new ArrayList<String>();

        public void put(String key, String value){
            list.add(new MyHashMapEntry(key, value));
        }
        public void get(String key){

        }

        @Override
        public String toString() {
           // return list.stream().forEach((MyHashMapEntry entry)-> System.out.println("key ="+entry.key+",value="+entry.value));
           // return list.stream().forEach((String s)-> System.out.println(s));
            return  null;
        }

        private class MyHashMapEntry{
            String key;
            String value;

            public MyHashMapEntry(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }
    }




