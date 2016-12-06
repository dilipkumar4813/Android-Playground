package com.example.myclasses;

/**
 * Created by Dilip on 12/4/2016.
 */

public class Car extends Vehicle {

    String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public void printManufacturer(){
        System.out.println(manufacturer);
    }
}
