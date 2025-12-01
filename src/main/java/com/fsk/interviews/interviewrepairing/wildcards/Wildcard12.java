package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 12: Upper bounded wildcard ve method parameter
 * 
 * Method parameter'da upper bounded wildcard kullanımı
 * Çıktı ne olur?
 */
public class Wildcard12 {
    public static void processNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println("Sum: " + sum);
        
        // numbers.add(new Integer(10)); // HATA!
        // numbers.add(new Double(1.5)); // HATA!
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        processNumbers(ints);
        
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        doubles.add(2.2);
        processNumbers(doubles);
        
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20.5);
        processNumbers(numbers);
    }
}

// ÇIKTI:
// Sum: 6.0
// Sum: 3.3000000000000003
// Sum: 30.5
// Upper bounded wildcard method parameter'da kullanılabilir
// Read işlemleri yapılabilir, write işlemleri yapılamaz




