package com.company;

public class Main {

    public static void main(String[] args) {
        String[] word = {"car","ada","racecar","cool"};
        System.out.println(firstPalindrome(word));
    }

    public static String firstPalindrome(String[] words) {
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            StringBuilder str = new StringBuilder(currWord);
            str.reverse();
            if (currWord.equals(str.toString())){
                result = currWord;
                break;
            }
        }
        return result;
    }

}
