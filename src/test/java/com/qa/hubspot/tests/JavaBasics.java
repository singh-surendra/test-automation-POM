package com.qa.hubspot.tests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaBasics {


    public int countVowelsInString(String word) {

        String str1 = word.replaceAll("\\s+", "");
        String str = str1.toLowerCase();

        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char subChar = str.charAt(i);
            if (subChar == 'a' || subChar == 'e' || subChar == 'i' || subChar == 'o' || subChar == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;

    }

    public int consonantCountInString(String word) {
        int consonantCount = 0;

        int vowel = countVowelsInString(word);
        String str1 = word.replaceAll("\\s+", "");
        String str = str1.toLowerCase();
        consonantCount = str.length() - vowel;
        return consonantCount;
    }

    @Test
    public void countVowelsConsonanatsInString() {
        String test = "Hello world";
        System.out.println("Consonants are " + consonantCountInString(test));
        System.out.println("Vowles are " + countVowelsInString(test));

    }

    public boolean checkPalindroms(String word) {

        String temp = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            temp = temp + word.charAt(i);
        }

        return temp.equalsIgnoreCase(word);

    }

    @Test
    public void checkPalindroms() {
        String test = "Madamsds";
        System.out.println(checkPalindroms(test));

    }


    public boolean findIfDuplicateCharInString(String str) {

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return str.length() == set.size();
    }

    @Test
    public void checkIfStringHasDuplicateChar() {
        String test = "Teee";
        System.out.println(findIfDuplicateCharInString(test));

    }

    public String findLargestWordInString(String str) {

        String words[] = str.split("\\s+");

        int max = 0;
        String largestWord = words[0];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            if (len > max) {
                max = len;
                largestWord = words[i];
            }
        }
        return largestWord;
    }

    @Test
    public void findLargestWordInString() {
        String test = "This is a longesstttt test";
        System.out.println(findLargestWordInString(test));

    }


    public String seperateEachCharFromString(String word) {

//        In this program, we need to separate each character from the string.
//        CHARACTERS
//        C H A R A C T E R S

        return word.replaceAll("", " ");

    }

    @Test
    public void seperateEachCharFromString() {

        String word = "TEST";
        System.out.println(word.replaceAll("", " "));
    }

    @Test
    public void swapStringsWithoutUsingTempVariable() {

        String word1 = "Good";
        String word2 = "Morning";
        System.out.println("Strings before swapping: " + word1 + " " + word2);
        word1 = word1 + word2;

        word2 = word1.substring(0, (word1.length() - word2.length()));
        word1 = word1.substring(word2.length());
        System.out.println("After Swaping: " + word1 + " " + word2);
    }


    @SneakyThrows
    public ArrayList<String> getAllPalindrom(String str) {

        ArrayList<String> palindrom = new ArrayList<>();

        String words[] = str.split("\\s+");

        for (int i = 0; i < words.length; i++) {

            if (checkPalindroms(words[i])) {
                palindrom.add(words[i]);
            }
        }

        return palindrom;

    }

    @Test
    public void getAllPalindrom() {
        String str = "Wow you own kayak";
        ArrayList<String> test = getAllPalindrom(str);
        Iterator<String> itr = test.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    @Test
    public void findSmallestPalindrom() {

        String str = "Wow you own kayak";
        ArrayList<String> test = getAllPalindrom(str);
        Iterator<String> itr = test.iterator();
        String small = test.get(0);
        int smallSize = 1;

        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).length() < smallSize) {
                smallSize = i;
            }

        }
        System.out.println("Smallest palindrom in the string is: " + test.get(smallSize));

    }

    @Test
    public void findBiggestPalindrom() {

        String str = "Wow you own kayak";
        ArrayList<String> test = getAllPalindrom(str);
        Iterator<String> itr = test.iterator();
        String small = test.get(0);
        int smallSize = 1;

        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).length() > smallSize) {
                smallSize = i;
            }

        }
        System.out.println("Biggest palindrom in the string is: " + test.get(smallSize));
    }





}
