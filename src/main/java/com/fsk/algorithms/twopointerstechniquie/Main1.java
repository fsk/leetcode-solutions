package com.fsk.algorithms.twopointerstechniquie;

import java.util.Arrays;

/**
 * Two Pointers siralanmis dizilerde 2 ' li pair bulmaya yarayan
 * algoritmadir. Default algoritmada degerleri indis olarak dondurur.
 */

public class Main1 {

    public static void main(String[] args) {

        int arr[] = { 2, 3, 5, 8, 9, 10, 11 };

        int val = 17;

        System.out.println(isPairSum2(arr, val));

    }

    /**
     * n = arr dizisinin lengthi
     * Yontem 1
     */
    public static int isPairSum(int arr[], int n, int x) {
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (i == j)
                    continue;

                if (arr[i] + arr[j] == x) {
                    return 1;
                }

                if (arr[i] + arr[j] > x)
                    break;
            }
        }
        return 0;
    }

    /**
     * n = arr dizisinin lengthi
     * Yontem 2
     */
    public static int isPairSum2(int arr[], int val) {
        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] == val)
                return 1;

            else if (arr[i] + arr[j] < val) {
                i++;
            }else j--;
        }

        return 0;
    }


}
