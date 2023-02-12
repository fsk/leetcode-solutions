package com.fsk;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode -> 989. Add to Array-Form of Integer
 */

public class Main24 {

    public static void main(String[] args) {

        int[] num = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        int k = 516;

        System.out.println(addToArrayForm(num, k));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {

            List<String> listNum = Arrays.stream(num).mapToObj(item -> item + "").toList();
            String result = String.join(",", listNum).replace(",", "");

            BigInteger numString = new BigInteger(result);
            BigInteger bigIntegerK = BigInteger.valueOf(k);


            return Arrays.stream(String.valueOf(numString.add(bigIntegerK))
                            .split("\\B"))
                    .map(Integer::valueOf).toList();

    }

}
