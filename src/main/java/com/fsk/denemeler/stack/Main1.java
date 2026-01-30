package com.fsk.denemeler.stack;

import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {

        Stack<String> stack1 = new Stack<>();
        stack1.add("Ankara");
        stack1.add("Istanbul");
        stack1.add("Izmir");
        stack1.add("Bursa");

        System.out.println(stack1);

        String peek = stack1.peek();
        System.out.println(peek);

        stack1.add(2,"Canakkale");
        System.out.println(stack1);

    }
}
