package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 48: Wildcard ve functional interface
 * 
 * Functional interface ile wildcard
 * Consumer, Supplier, Function
 * Çıktı ne olur?
 */
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;

public class Wildcard48 {
    // Consumer<? super T>
    public static <T> void forEach(List<? extends T> list, Consumer<? super T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }
    
    // Supplier<? extends T>
    public static <T> void fill(List<? super T> list, Supplier<? extends T> supplier, int count) {
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
    }
    
    // Function<? super T, ? extends R>
    public static <T, R> List<R> map(List<? extends T> list, Function<? super T, ? extends R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        
        forEach(ints, System.out::println);
        
        List<Number> numbers = new ArrayList<>();
        fill(numbers, () -> 42, 3);
        System.out.println("Filled: " + numbers);
        
        List<String> strings = map(ints, Object::toString);
        System.out.println("Mapped: " + strings);
    }
}

// ÇIKTI:
// 10
// 20
// Filled: [42, 42, 42]
// Mapped: [10, 20]
// Functional interface'ler wildcard ile kullanılabilir
// PECS pattern uygulanır




