package com.fsk.leetcodesolutions;

public class Main105 {

    public static void main(String[] args) {
        int i = arrangeCoins(5);
        System.out.println(i);
    }

    public static int arrangeCoins(int n) {
        int used = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (used + 1 > n) {
                    return i - 1;
                }
                used++;
                if (used == n) {
                    return (j == i) ? i : (i - 1);
                }
            }
        }

        return 0;
    }
}
