package com.fsk.leetcodesolutions;

public class Main101 {

    public static void main(String[] args) {

        char[] arr = {'H', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        for (char c : arr) {
            System.out.println(c);
        }

    }

    public static void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp1 = s[start];
            s[start] = s[end];
            s[end] = temp1;
            start++;
            end--;
        }

    }
}
