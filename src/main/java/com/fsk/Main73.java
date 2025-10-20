package com.fsk;

import java.util.*;

/**
 * 1122. Relative Sort Array
 */

public class Main73 {

    //array2 is unique
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        List<Integer> listMain = new ArrayList<>();
        List<Integer> listOther = new ArrayList<>();


        for (int j : arr2) {
            for (int k : arr1) {
                if (k == j) {
                    listMain.add(k);
                }
            }
        }

        for (int k : arr1) {
            if (Arrays.stream(arr2).noneMatch(x -> x == k)) {
                listOther.add(k);
            }
        }
        Collections.sort(listOther);

        listMain.addAll(listOther);

        return  listMain.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int value : arr1) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        for (int k : arr2) {
            if (map.containsKey(k)) {
                int adet = map.get(k);
                for (int j = 0; j < adet; j++) {
                    resultList.add(k);
                }
                map.remove(k);
            }
        }

        List<Integer> leftovers = new ArrayList<>(map.keySet());
        Collections.sort(leftovers);

        for (int key : leftovers) {
            int count = map.get(key);
            for (int j = 0; j < count; j++) {
                resultList.add(key);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();


    }

    public static int[] relativeSortArray2MoreShort(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int value : arr1) {
            map.merge(value, 1, Integer::sum);
        }

        List<Integer> resultList = new ArrayList<>(arr1.length);

        for (int k : arr2) {
            if (map.containsKey(k)) {
                int count = map.get(k);
                for (int j = 0; j < count; j++) {
                    resultList.add(k);
                }
                map.remove(k);
            }
        }

        List<Integer> leftovers = new ArrayList<>(map.keySet());
        Collections.sort(leftovers);

        for (int key : leftovers) {
            int count = map.get(key);
            for (int j = 0; j < count; j++) {
                resultList.add(key);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
