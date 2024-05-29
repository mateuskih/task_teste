package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TASK1Test {

    @Test
    public void testIsPalindrome() {
        assertTrue(TASK1.isPalindrome("madam"));
        assertTrue(TASK1.isPalindrome("racecar"));
        assertTrue(TASK1.isPalindrome("A man a plan a canal Panama"));
        assertFalse(TASK1.isPalindrome("hello"));
        assertFalse(TASK1.isPalindrome("world"));
        assertFalse(TASK1.isPalindrome("not a palindrome"));
    }

    @Test
    public void testIsPalindromeWithEmptyString() {
        assertTrue(TASK1.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeWithSingleCharacter() {
        assertTrue(TASK1.isPalindrome("a"));
        assertTrue(TASK1.isPalindrome("A"));
        assertTrue(TASK1.isPalindrome("1"));
    }

    @Test
    public void testIsPalindromeWithWhitespace() {
        assertTrue(TASK1.isPalindrome(" "));
        assertTrue(TASK1.isPalindrome("  "));
        assertTrue(TASK1.isPalindrome("\t"));
        assertTrue(TASK1.isPalindrome("\n"));
    }
}
