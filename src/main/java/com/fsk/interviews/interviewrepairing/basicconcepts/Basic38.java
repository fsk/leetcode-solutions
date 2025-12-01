package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 38: instanceof operator trick
 * 
 * instanceof operator
 * Null check
 * Inheritance hierarchy
 * Çıktı ne olur?
 */
class Basic38A {
}

class Basic38B extends Basic38A {
}

class Basic38C extends Basic38B {
}

interface Basic38I {
}

class Basic38D implements Basic38I {
}

public class Basic38 {
    public static void main(String[] args) {
        Basic38A obj1 = new Basic38A();
        Basic38B obj2 = new Basic38B();
        Basic38C obj3 = new Basic38C();
        Basic38D obj4 = new Basic38D();
        
        // instanceof with inheritance
        System.out.println("obj2 instanceof A: " + (obj2 instanceof Basic38A)); // true
        System.out.println("obj3 instanceof A: " + (obj3 instanceof Basic38A)); // true
        System.out.println("obj3 instanceof B: " + (obj3 instanceof Basic38B)); // true
        System.out.println("obj1 instanceof B: " + (obj1 instanceof Basic38B)); // false
        
        // instanceof with interface
        System.out.println("obj4 instanceof I: " + (obj4 instanceof Basic38I)); // true
        
        // instanceof with null
        Basic38A nullObj = null;
        System.out.println("nullObj instanceof A: " + (nullObj instanceof Basic38A)); // false
        
        // instanceof with same type
        System.out.println("obj1 instanceof A: " + (obj1 instanceof Basic38A)); // true
        
        // instanceof with String
        Object str = "test";
        System.out.println("str instanceof String: " + (str instanceof String)); // true
    }
}

// ÇIKTI:
// obj2 instanceof A: true
// obj3 instanceof A: true
// obj3 instanceof B: true
// obj1 instanceof B: false
// obj4 instanceof I: true
// nullObj instanceof A: false
// obj1 instanceof A: true
// str instanceof String: true
// instanceof inheritance hierarchy'yi kontrol eder
// null instanceof her zaman false döner




