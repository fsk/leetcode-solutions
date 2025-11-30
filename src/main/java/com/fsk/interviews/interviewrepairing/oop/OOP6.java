package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 6: Private method overriding trick
 * 
 * Private metodlar override edilebilir mi?
 * Çıktı ne olur?
 */
class OOP6A {
    private void privateMethod() {
        System.out.println("A privateMethod");
    }
    
    public void publicMethod() {
        privateMethod(); // Hangi metod çağrılır?
    }
}

class OOP6B extends OOP6A {
    private void privateMethod() {
        System.out.println("B privateMethod");
    }
    
    public void publicMethod() {
        privateMethod(); // Hangi metod çağrılır?
    }
}

public class OOP6 {
    public static void main(String[] args) {
        OOP6A obj1 = new OOP6A();
        OOP6A obj2 = new OOP6B();
        OOP6B obj3 = new OOP6B();
        
        obj1.publicMethod();
        obj2.publicMethod(); // Trick!
        obj3.publicMethod();
    }
}

// ÇIKTI:
// A privateMethod
// A privateMethod (private metod override edilmez, her sınıf kendi metodunu çağırır)
// B privateMethod
// Private metodlar override edilmez, her sınıf kendi private metodunu görür


