package com.fsk.problems1;

import java.util.Arrays;

public class Interview {

    public static void main(String[] args) {

        int arr[] = {1,4,3,5,6};

        Arrays.stream(arr).boxed().mapToInt(item -> item).max().getAsInt();
    }
}
