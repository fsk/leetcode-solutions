package com.fsk.leetcodesolutions;

public class Main122 {

    public static void main(String[] args) {

        System.out.println(reversePrefix("abcdefd", 'd'));

    }

    public static String reversePrefix(String word, char ch) {
        if (word.indexOf(ch) == -1) return word;
        int index = word.indexOf(ch);
        String prefix = word.substring(0, index + 1);
        String reverse = new StringBuilder(prefix).reverse().toString();
        return reverse + word.substring(index);
    }

    public static String reversePrefix2(String word, char ch) {
        if (word.indexOf(ch) == -1) return word;
        char[] chars = word.toCharArray();
        int left = 0;
        int right = word.indexOf(ch);
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
