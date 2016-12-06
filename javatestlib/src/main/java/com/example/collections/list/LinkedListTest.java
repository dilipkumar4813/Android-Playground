package com.example.collections.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Dilip on 12/5/2016.
 */

public class LinkedListTest {

    /*
     * Child of collection is list, child of list is linkedlist
     *
     *
     */

    LinkedList<String> linkedList = new LinkedList<>();

    public void addItemsToLinkedList() {
        linkedList.add("test 1");
        linkedList.add("test 2");
        linkedList.add("test 3");
        linkedList.add("test 4");
    }

    public void addToTheTopOfTheList(String firstString) {
        linkedList.addFirst(firstString);
    }

    public void addToLastOfTheList(String lastString) {
        linkedList.addLast(lastString);
    }

    public void deleteItemFromLinkedList(String removeItem) {
        linkedList.remove(removeItem);
    }

    public void iterateLinkedList() {
        System.out.println("Items in Linked list : ");

        Iterator<String> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            String printData = iterator.next();
            System.out.println(printData);
        }
    }

    public void clearLinkedList() {
        linkedList.clear();
    }

    public void sizeOfLinkedList() {
        System.out.println("Size of the linked list : " + linkedList.size());
    }
}
