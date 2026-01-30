package com.fsk.interviews;

/**
 * LeetCode -> 1768. Merge Strings Alternately
 */
public class Interview2 {

    public static void main(String[] args) {

        System.out.println(isIn("abcd", "abe"));
        System.out.println(isIn("ankarada", "ankara"));
        System.out.println(isIn("ankarada", "an"));
        System.out.println(isIn("", ""));
        System.out.println(isIn("sadasdas", ""));


    }


    public static boolean isIn(String s1, String s2) {

        if (s1.equals(s2)) return true;
        if (s1.isEmpty() || s2.isEmpty()) return true;


        for (int i = 0; i < s1.length(); i++) {


            for (int j = i; j < s1.length(); j ++) {


                String substring = s1.substring(i, j);

                if (substring.equals(s2)) {
                    return true;
                }


            }
        }
        return false;

    }

}
