package com.fsk.leetcodesolutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * LeetCode -> 20. Valid Parentheses
 */
public class Main8 {

    public static void main(String[] args) {
        //System.out.println(isValid("{()}[]"));
        System.out.println(isValid2("{{()}}[(([{}]))]"));
    }

    public static boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                deque.push(x);
                continue;
            }

            if (deque.isEmpty()) return false;

            char popChar;
            switch (x) {
                case ')' -> {
                    popChar = deque.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                }
                case '}' -> {
                    popChar = deque.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                }
                case ']' -> {
                    popChar = deque.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                }
            }

        }

        return deque.isEmpty();
    }


    public static boolean isValid2(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
