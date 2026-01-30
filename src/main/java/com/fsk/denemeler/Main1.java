package com.fsk.denemeler;

import com.fsk.algorithms.graph.Main;

import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {

        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("Ankara", 6);
        Integer ankara = aMap.putIfAbsent("Istanbul", 7);
        System.out.println(ankara);

        for (Map.Entry<String, Integer> item : aMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

}
