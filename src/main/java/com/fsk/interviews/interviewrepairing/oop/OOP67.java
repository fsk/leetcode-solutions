package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 67: Polymorphism ve inner class
 * 
 * Inner class'ta polymorphism nasıl çalışır?
 * Outer class field'larına erişim
 * Çıktı ne olur?
 */
class OOP67Outer {
    private String name = "Outer";
    
    class Inner {
        private String name = "Inner";
        
        void method() {
            System.out.println("Inner method(), name = " + name);
            System.out.println("Outer name = " + OOP67Outer.this.name);
        }
    }
    
    class Inner2 extends Inner {
        private String name = "Inner2";
        
        @Override
        void method() {
            System.out.println("Inner2 method(), name = " + name);
            System.out.println("Super name = " + super.name);
            System.out.println("Outer name = " + OOP67Outer.this.name);
        }
    }
}

public class OOP67 {
    public static void main(String[] args) {
        OOP67Outer outer = new OOP67Outer();
        OOP67Outer.Inner inner1 = outer.new Inner();
        OOP67Outer.Inner inner2 = outer.new Inner2();
        
        inner1.method();
        inner2.method(); // Polymorphism çalışır
    }
}

// ÇIKTI:
// Inner method(), name = Inner
// Outer name = Outer
// Inner2 method(), name = Inner2
// Super name = Inner
// Outer name = Outer
// Inner class'ta polymorphism çalışır, outer class field'larına erişim var




