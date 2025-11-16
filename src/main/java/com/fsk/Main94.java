package com.fsk;

public class Main94 {


    public static void main(String[] args) {

    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] arr  = new int[m][n];

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
                arr[row][col] = arr[row][col] + 1;
            }
        }

        for (int[] wall : walls) {
            int row = wall[0];
            int col = wall[1];

            if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
                arr[row][col] = arr[row][col] + 2;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {}
            }
        }
        return 0;
    }
}
