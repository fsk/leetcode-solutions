package com.fsk;

/**
 * LeetCode -> 2496. Maximum Value of a String in an Array
 */

public class Main53 {

    public static void main(String[] args) {

        System.out.println(maximumValue(new String[]{"alic3","BASEEWSDAWE","3","4","00000"}));

    }

    public static int maximumValue(String[] strs) {

        int result = 0;

        for (String item : strs) {
            result = Math.max(result, maxVal(item));
        }
        return result;
    }

    private static int maxVal(String item) {
        for (int i = 0; i < item.length(); i++) {
            if ((item.charAt(i) >= 'a' && item.charAt(i) <= 'z') || (item.charAt(i) >= 'A' && item.charAt(i) <= 'Z')) {
                return item.length();
            }
        }
        return Integer.parseInt(item);
    }
}
