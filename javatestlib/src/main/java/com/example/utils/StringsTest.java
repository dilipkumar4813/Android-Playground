package com.example.utils;

/**
 * Created by Dilip on 12/5/2016.
 */

public class StringsTest {

    /*
     * String functions available in java
     * concat, toLowerCase, toUpperCase
     * length, charAt, replace, subString
     * replaceAll, matches, equalsIgnoreCase
     * equals, startsWith, endsWith
     *
     * String buffer
     * capacity, length, ensureCapacity
     * reverse, delete, deleteCharAt
     * insert, append
     */

    public void stringFunctions(String str) {
        System.out.println("To lower case: " + str.toLowerCase());
        System.out.println("To upper case: " + str.toUpperCase());
        System.out.println("Get single character : " + str.charAt(1));

        if (str.equalsIgnoreCase("dilip")) {
            System.out.println("Ignore case works");
        }

        if (str.equals("dilip")) {
            System.out.println("Case match complete");
        }

        System.out.println("Length of the String : " + str.length());

        System.out.println("Sub string : " + str.substring(0, 2));

        System.out.println("Replacing items on the string : " + str.replace("i", "I"));

        int a = 10;
        System.out.println("Integer conversion to string : " + String.valueOf(a));

        str = str.concat("        kumar");
        str = str.trim();
        System.out.println("Trim function in string : " + str);

        //Case sensitive
        if (str.startsWith("d")) {
            System.out.println("Start with letter d");
        }

        //Case sensitive
        if (str.endsWith("r")) {
            System.out.println("Ends with letter r");
        }

        System.out.println("String index of : " + str.indexOf("i"));

        System.out.println("String last index of : " + str.lastIndexOf("a"));

        if (str.contains("kumar")) {
            System.out.println("String contains kumar");
        }

        StringBuffer sb = new StringBuffer("Dilip");
        System.out.println("String buffer : " + sb);
        System.out.println("String buffer length : " + sb.length());
        System.out.println("String buffer capacity : " + sb.capacity());
        System.out.println("String buffer append : " + sb.append(" kumar"));
        System.out.println("String buffer reverse : " + sb.reverse());
        System.out.println("String buffer insert function " + sb.insert(2, " knows "));
        System.out.println("String buffer delete function" + sb.delete(1, 3));
        System.out.println("String buffer delete char function : " + sb.deleteCharAt(0));

        //To set the maximum capacity when the size is pre known
        sb.ensureCapacity(50);
        System.out.println("");
    }
}
