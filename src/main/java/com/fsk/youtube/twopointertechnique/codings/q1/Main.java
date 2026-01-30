package com.fsk.youtube.twopointertechnique.codings.q1;

public class Main {
    public static void main(String[] args) {

        int[] arr = {3, 5, 8, 4, 13, 6, 1};
        int target = 12;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {

                    System.out.println(arr[i] + " " + arr[j]);

                }
            }

        }


    }
}
