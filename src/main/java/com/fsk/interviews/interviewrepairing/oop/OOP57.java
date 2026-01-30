package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 57: Null ve array polymorphism
 * 
 * Null array reference nasıl davranır?
 * Array element null olabilir mi?
 * Çıktı ne olur?
 */
class OOP57A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP57B extends OOP57A {
    @Override
    void method() {
        System.out.println("B method()");
    }
}

public class OOP57 {
    public static void main(String[] args) {
        OOP57A[] array = null;
        // System.out.println("array.length = " + array.length); // NullPointerException!
        
        OOP57A[] array2 = new OOP57A[5];
        System.out.println("array2.length = " + array2.length);
        System.out.println("array2[0] == null: " + (array2[0] == null));
        
        array2[0] = new OOP57A();
        array2[1] = new OOP57B();
        array2[2] = null; // Array element null olabilir
        
        for (OOP57A obj : array2) {
            if (obj != null) {
                obj.method();
            } else {
                System.out.println("null element");
            }
        }
    }
}

// ÇIKTI:
// array2.length = 5
// array2[0] == null: true
// A method()
// B method()
// null element
// null
// null
// Array element'leri null olabilir, null check gerekli


