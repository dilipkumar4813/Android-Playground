package com.example.collections.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Dilip on 12/5/2016.
 */

public class TreeSetTest {

    /*
     * TreeSet is a collection class
     * It extends from AbstractSet
     * TreeSet is used when you want to add data and sort while adding the data
     * Using tree map for storing the data internally
     */

    TreeSet<String> treeSet = new TreeSet<>();

    public void addDemoData() {
        treeSet.add("Kumar");
        treeSet.add("Dilip");
        treeSet.add("Mario");
    }

    public void addItem(String newItem) {
        treeSet.add(newItem);
    }

    public void removeItem(String str) {
        treeSet.remove(str);
    }

    public void treeSetSize() {
        System.out.println("Size of the treeset : " + treeSet.size());
    }

    public void clearAllItemsInTreeSet() {
        treeSet.clear();
    }

    public void traverseTreeSet() {
        System.out.println("Data in the tree set");

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            String printData = iterator.next();
            System.out.println(printData);
        }
    }
}
