package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 42: Wildcard ve bounded type parameters
 * 
 * Wildcard (?) ve bounded type parameter arasındaki fark nedir?
 * Hangi durumda hangisi kullanılır?
 * Çıktı ne olur?
 */
import java.util.List;
import java.util.ArrayList;

class OOP42Test {
    // Unbounded wildcard
    void method1(List<?> list) {
        // list.add(new Object()); // HATA! Unknown type
        Object obj = list.get(0); // OK, Object olarak alınabilir
    }
    
    // Upper bounded wildcard
    void method2(List<? extends Number> list) {
        // list.add(new Integer(10)); // HATA! Unknown subtype
        Number num = list.get(0); // OK
    }
    
    // Lower bounded wildcard
    void method3(List<? super Integer> list) {
        list.add(new Integer(10)); // OK, Integer veya super type
        Object obj = list.get(0); // OK, Object olarak alınabilir
    }
}

public class OOP42 {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        OOP42Test test = new OOP42Test();
        test.method1(intList);
        test.method2(intList); // Integer extends Number
        test.method3(numberList); // Number super Integer
    }
}

// ÇIKTI:
// Wildcard read için esnek, write için kısıtlayıcı
// Upper bounded: read-only (extends)
// Lower bounded: write-only (super)


