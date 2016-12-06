package com.example.utils;

/**
 * Created by Dilip on 12/5/2016.
 */

public class Validation {

    public static boolean stringValidation(String str){
            if(str==""||str.equalsIgnoreCase(" ")){
                return false;
            }
        return true;
    }

    public static boolean numberValidation(String str){
        if(str.matches("[0-9]+")){
            return true;
        }
        return false;
    }
}
