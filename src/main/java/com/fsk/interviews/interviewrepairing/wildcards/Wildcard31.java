package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 31: PECS Principle - Producer Extends
 * 
 * Producer: Veri üreten (read işlemleri)
 * ? extends T kullanılır
 * Çıktı ne olur?
 */
public class Wildcard31 {
    // Producer - extends kullan
    public static double sum(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) { // Read işlemi
            sum += num.doubleValue();
        }
        return sum;
    }
    
    // Producer - extends kullan
    public static Number getMax(List<? extends Number> numbers) {
        if (numbers.isEmpty()) return null;
        Number max = numbers.get(0);
        for (Number num : numbers) {
            if (num.doubleValue() > max.doubleValue()) {
                max = num;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.5);
        
        System.out.println("Sum of ints: " + sum(ints));
        System.out.println("Sum of doubles: " + sum(doubles));
        System.out.println("Max: " + getMax(ints));
    }
}

// ÇIKTI:
// Sum of ints: 30.0
// Sum of doubles: 4.0
// Max: 20
// PECS: Producer Extends - Veri üreten metodlarda ? extends T kullan


