package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 17: Casting ve instanceof trick
 * 
 * instanceof ve casting kombinasyonu
 * Pattern matching
 * Çıktı ne olur?
 */
class Basic17A {
    void method() {
        System.out.println("A method()");
    }
}

class Basic17B extends Basic17A {
    @Override
    void method() {
        System.out.println("B method()");
    }
    
    void specific() {
        System.out.println("B specific()");
    }
}

class Basic17C extends Basic17A {
    @Override
    void method() {
        System.out.println("C method()");
    }
}

public class Basic17 {
    public static void main(String[] args) {
        Basic17A obj1 = new Basic17A();
        Basic17A obj2 = new Basic17B();
        Basic17A obj3 = new Basic17C();
        
        // instanceof chain
        if (obj1 instanceof Basic17B) {
            ((Basic17B) obj1).specific();
        } else if (obj1 instanceof Basic17C) {
            ((Basic17C) obj1).method();
        } else {
            obj1.method();
        }
        
        // instanceof with null
        Basic17A nullObj = null;
        System.out.println("null instanceof A: " + (nullObj instanceof Basic17A));
        System.out.println("null instanceof B: " + (nullObj instanceof Basic17B));
        
        // Pattern matching style
        if (obj2 instanceof Basic17B) {
            Basic17B b = (Basic17B) obj2;
            b.specific();
        }
    }
}

// ÇIKTI:
// A method()
// null instanceof A: false
// null instanceof B: false
// B specific()
// instanceof null için her zaman false döner
// instanceof kontrolü casting'den önce yapılmalı


