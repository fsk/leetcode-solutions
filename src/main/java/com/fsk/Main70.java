package com.fsk;

public class Main70 {

    public static void main(String[] args) {

    }


    public static int hammingWeight(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder =  n % 2;
            sb.append(remainder);
            n = n / 2;
        }

        int count = 0;
        for (int i = 0; i <= sb.length() - 1; i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }

        }
        return count;
    }


    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
