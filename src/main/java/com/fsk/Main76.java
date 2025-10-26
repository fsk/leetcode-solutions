package com.fsk;

public class Main76 {

    public static void main(String[] args) {



    }

    public static boolean hasSameDigits(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            String substring = s.substring(i, i + 2);

            char c1 = substring.toCharArray()[0];
            char c2 = substring.toCharArray()[1];

            int numericValue1 = Character.getNumericValue(c1);
            int numericValue2 = Character.getNumericValue(c2);

            sb.append(((numericValue1 + numericValue2) % 10));

            s = sb + s.substring(i + 3, s.length() - 1);

        }
        return false;
    }
}
