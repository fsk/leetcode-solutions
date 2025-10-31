package com.fsk;

public class Main84 {

    public static void main(String[] args) {


    }

    public static int minNumberOperations(int[] target) {
        int operations = target[0];

        for (int i = 1; i < target.length; i++) {
            int diff = target[i] - target[i - 1];
            if (diff > 0) {
                operations = operations + diff;
            }
        }

        return operations;
    }


}
