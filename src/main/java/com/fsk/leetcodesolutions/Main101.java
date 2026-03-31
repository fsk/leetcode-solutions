package com.fsk.leetcodesolutions;

import java.util.Stack;

public class Main101 {

    public static void main(String[] args) {

        char[] arr = {'H', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        for (char c : arr) {
            System.out.println(c);
        }

        reverseString2("furkan");

    }

    public static void reverseString2(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
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
