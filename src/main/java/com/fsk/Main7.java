package com.fsk;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main7 {

    public static void main(String[] args) {
        System.out.println(isHappy(36));

    }


    public static boolean isHappy(int n) {
        ArrayList<Integer> nums = new ArrayList();
        String number = String.valueOf(n);
        for (int i = 0; i <number.length() ; i++) {
            nums.add(Integer.parseInt(number.substring(i, i+1)));
        }
        //nums.stream().mapToInt(Integer::parseInt).map(item -> (int) Math.pow(item, 2)).sum();
        int squreTotal = nums.stream().mapToInt(item -> (int) Math.pow(item, 2)).sum();
        if (squreTotal == 1 || squreTotal == 7 || squreTotal == 100) {
            return true;
        }else if(String.valueOf(squreTotal).length() == 1) {
            return false;
        }else return isHappy(squreTotal);
    }

}
