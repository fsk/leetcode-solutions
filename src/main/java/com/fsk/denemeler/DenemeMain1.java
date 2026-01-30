package com.fsk.denemeler;

import java.util.HashMap;
import java.util.Map;

public class DenemeMain1 {

    public static void main(String[] args) {

        String aksaray = "aksaray";
        System.out.println(aksaray.replace("a", ""));


        Map<Integer, String> map = new HashMap<>();
        map.put(1, aksaray);
        map.put(2, "ankara");
        map.put(3, "istanbul");
        map.put(4, "bursa");


        Map<Integer, String> map2 = new HashMap<>();
        map2.put(4, "bursa");
        map2.put(2, "ankara");
        map2.put(1, aksaray);
        map2.put(3, "istanbul");

        System.out.println(map.equals(map2));

    }
}
