package com.fsk.denemeler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main3 {
    

    public static void main(String[] args) {
        //System.out.println(args[1]);

        Queue<String> queue = new LinkedList<>();

        queue.add("O");
        queue.add("B");
        queue.add("S");
        queue.add("S");


        System.out.println(queue.poll());

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.remove());

        System.out.println(queue);


        System.out.println("===============================");
    }

}
