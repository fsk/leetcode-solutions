package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 70: Polymorphism ve final method trick
 * 
 * Final metod override edilemez ama inherit edilir
 * Final metod polymorphism'i etkiler mi?
 * Çıktı ne olur?
 */
class OOP70A {
    final void finalMethod() {
        System.out.println("A finalMethod()");
    }
    
    void normalMethod() {
        System.out.println("A normalMethod()");
    }
}

class OOP70B extends OOP70A {
    // void finalMethod() { } // HATA! Final metod override edilemez
    
    @Override
    void normalMethod() {
        System.out.println("B normalMethod()");
    }
    
    void callFinal() {
        finalMethod(); // Inherit edilmiş final metod çağrılır
    }
}

public class OOP70 {
    public static void main(String[] args) {
        OOP70A obj1 = new OOP70A();
        OOP70A obj2 = new OOP70B();
        
        obj1.finalMethod();
        obj2.finalMethod(); // Final metod, polymorphism yok
        
        obj1.normalMethod();
        obj2.normalMethod(); // Normal metod, polymorphism var
        
        OOP70B obj3 = new OOP70B();
        obj3.callFinal();
    }
}

// ÇIKTI:
// A finalMethod()
// A finalMethod() (final metod, override edilemez, polymorphism yok)
// A normalMethod()
// B normalMethod() (normal metod, polymorphism var)
// A finalMethod()
// Final metodlar polymorphism'i etkilemez, her zaman aynı metod çağrılır


