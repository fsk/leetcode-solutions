package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 26: Inner class ve outer class field access
 * 
 * Inner class outer class'ın private field'larına erişebilir.
 * Outer class inner class'ın field'larına nasıl erişir?
 * Çıktı ne olur?
 */
class OOP26Outer {
    private int x = 10;
    private static int y = 20;
    
    class Inner {
        private int z = 30;
        
        void innerMethod() {
            System.out.println("Inner: x = " + x); // Outer'ın private field'ına erişim
            System.out.println("Inner: y = " + y); // Outer'ın static field'ına erişim
            System.out.println("Inner: z = " + z);
        }
    }
    
    void outerMethod() {
        Inner inner = new Inner();
        // System.out.println("Outer: z = " + inner.z); // Private field'a erişim yok
        System.out.println("Outer: z = " + inner.z); // Public/protected olsaydı erişilebilirdi
        inner.innerMethod();
    }
}

public class OOP26 {
    public static void main(String[] args) {
        OOP26Outer outer = new OOP26Outer();
        outer.outerMethod();
        
        OOP26Outer.Inner inner = outer.new Inner();
        inner.innerMethod();
    }
}

// ÇIKTI:
// Outer: z = 30
// Inner: x = 10
// Inner: y = 20
// Inner: z = 30
// Inner: x = 10
// Inner: y = 20
// Inner: z = 30
// Inner class outer class'ın tüm field'larına erişebilir


