package com.fsk;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * LeetCode -> 20. Valid Parentheses
 */
public class Main8 {

    public static void main(String[] args) {
        System.out.println(isValid("{()}[]"));
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
                case ')':
                    popChar = deque.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar =  deque.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = deque.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }

        }

        return deque.isEmpty();
    }
}
