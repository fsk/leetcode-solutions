package com.fsk;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * LeetCode -> 1491. Average Salary Excluding the Minimum and Maximum Salary
 */

public class Main55 {

    public static void main(String[] args) {

        System.out.println(average(new int[]{8000,9000,2000,3000,6000,1000}));

    }

    /**
     * 4MS - 6.23% Beats - 40.5 MB
     */
    public static double average(int[] salary) {

        Supplier<IntStream> salarayStream = () -> Arrays.stream(salary).boxed().mapToInt(Integer::intValue);
        double totalSum = salarayStream.get().sum();
        double maxSalary = salarayStream.get().max().orElse(0);
        double minSalary = salarayStream.get().min().orElse(0);

        totalSum = totalSum - (maxSalary + minSalary);

        int count = (int) (salarayStream.get().count() - 2);

        return totalSum / count;

    }

    /**
     * 0 MS - 100% Beats - 40.5 MB
     */
    public static double average2(int[] salary) {
        double res = 0;
        Arrays.sort(salary);
        for (int i = 1; i < salary.length - 1; i++) {
            res = res + salary[i];
        }
        return res / (salary.length - 2);
    }
}
