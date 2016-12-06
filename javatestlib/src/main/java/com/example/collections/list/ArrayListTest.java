package com.example.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dilip on 12/5/2016.
 */

public class ArrayListTest {

    ArrayList<String> arrayList = new ArrayList<>();

    public void addItems(){
        arrayList.add("test 1");
        arrayList.add("test 2");
        arrayList.add("test 3");
        arrayList.add("test 4");
    }

    public void deleteItem(String str){
        arrayList.remove(str);
    }

    public void printItems(){
        System.out.println("Items in the array list : ");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
        }
    }

    public void printArrayListSize(){
        System.out.println("Size of array list : "+arrayList.size());
    }

    public void clearArrayList(){
        arrayList.clear();
    }
}
