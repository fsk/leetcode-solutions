package com.fsk.denemeler;

import com.fsk.algorithms.graph.Main;

import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {

        // boolean defaultta false
        boolean[] arr = new boolean[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("Ankara", 6);
        Integer ankara = aMap.putIfAbsent("Istanbul", 7);
        System.out.println(ankara);

        for (Map.Entry<String, Integer> item : aMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

}
