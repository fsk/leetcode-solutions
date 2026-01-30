package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 27: Static nested class vs inner class
 * 
 * Static nested class ve inner class arasındaki fark nedir?
 * Hangi durumda hangisi kullanılır?
 * Çıktı ne olur?
 */
class OOP27Outer {
    private int x = 10;
    private static int y = 20;
    
    // Inner class (non-static)
    class Inner {
        void method() {
            System.out.println("Inner: x = " + x); // Outer instance'a erişim
            System.out.println("Inner: y = " + y);
        }
    }
    
    // Static nested class
    static class StaticNested {
        void method() {
            // System.out.println("StaticNested: x = " + x); // HATA! Instance field'a erişemez
            System.out.println("StaticNested: y = " + y); // Static field'a erişim
        }
    }
}

public class OOP27 {
    public static void main(String[] args) {
        OOP27Outer outer = new OOP27Outer();
        OOP27Outer.Inner inner = outer.new Inner(); // Outer instance gerekli
        inner.method();
        
        OOP27Outer.StaticNested nested = new OOP27Outer.StaticNested(); // Outer instance gerekmez
        nested.method();
    }
}

// ÇIKTI:
// Inner: x = 10
// Inner: y = 20
// StaticNested: y = 20
// Inner class outer instance'a ihtiyaç duyar, static nested class duymaz


