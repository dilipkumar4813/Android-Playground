package com.example.collections.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Dilip on 12/5/2016.
 */

public class HashSetTest {

    /*
     * Using hash table to store the data
     *
     *
     */

    HashSet<String> hashSet = new HashSet<>();

    public void addDemoData(){
        hashSet.add("Kumar");
        hashSet.add("Dilip");
        hashSet.add("Mario");
    }

    public void iterateHashSet(){
        System.out.println("Hash set items : ");

        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
