package com.fsk;

import java.util.ArrayList;

public class Main8 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        ArrayList<String> str = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            str.add(s.substring(i,i+1));
        }

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        int c6 = 0;

        for (int i = 0; i <str.size() ; i++) {
            if (str.get(i).contains("(")) {
                c1++;
            }

            if (str.get(i).contains(")")) {
                c2++;
            }

            if (str.get(i).contains("{")) {
                c3++;
            }

            if (str.get(i).contains("}")) {
                c4++;
            }

            if (str.get(i).contains("[")) {
                c5++;
            }

            if (str.get(i).contains("[")) {
                c6++;
            }
        }

        if (c1 == c2 && c3 == c4 && c5 == c6) {
            return true;
        }else return false;
    }
}
