package com.fsk.stack;

public class StackMain {

    public static void main(String[] args) {

        CustomStack<Integer>stack = new CustomStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

}
