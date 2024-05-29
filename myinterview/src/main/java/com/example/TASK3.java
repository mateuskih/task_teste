package com.example;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TASK3 {

    public static void main(String[] args) {
        List<String> list = generateRandomStringList(10);
        printList(list);
        System.out.println("\nNumber of distinct items: " + countDistinctItems(list));
    }

    public static List<String> generateRandomStringList(int count) {
        List<String> list = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(generateRandomString(random.nextInt(10) + 1));
        }
        return list;
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(new Random().nextInt(characters.length())));
        }
        return sb.toString();
    }

    public static void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static int countDistinctItems(List<String> list) {
        Set<String> distinctItems = new HashSet<String>(list); 
        return distinctItems.size();
    }
}
