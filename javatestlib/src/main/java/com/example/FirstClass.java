package com.example;

import com.example.collections.list.ArrayListTest;
import com.example.collections.set.HashSetTest;
import com.example.collections.set.TreeSetTest;
import com.example.myclasses.Car;
import com.example.myclasses.Vehicle;
import com.example.utils.StringsTest;
import com.example.utils.Validation;

public class FirstClass {

    public static void main(String[] args) {
        Car obj = new Car();
        obj.setManufacturer("Mahindra");
        obj.printManufacturer();

        Vehicle obj2 = new Car();
        obj2.printSomething();

        if(Validation.numberValidation("123a")){
            System.out.println("Provided a number");
        }

        //Array list implementation class
        ArrayListTest testArray = new ArrayListTest();
        testArray.addItems();
        testArray.printItems();
        testArray.deleteItem("test 3");
        testArray.printItems();
        testArray.printArrayListSize();
        testArray.clearArrayList();
        testArray.printArrayListSize();

        //Tree set implementation class
        TreeSetTest testTree = new TreeSetTest();
        testTree.addDemoData();
        testTree.traverseTreeSet();

        //Hash set implementation class
        HashSetTest hashTest = new HashSetTest();
        hashTest.addDemoData();
        hashTest.iterateHashSet();

        //String functions class
        StringsTest strTest = new StringsTest();
        strTest.stringFunctions("Dilip");
    }
}
