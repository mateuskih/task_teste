package com.example;
import java.util.Scanner;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        String input = scanner.nextLine();
        
        if(isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }
    
    public static boolean isPalindrome(String str) {
        String formattedStr = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = formattedStr.length() - 1;
        
        while(left < right) {
            if(formattedStr.charAt(left) != formattedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
