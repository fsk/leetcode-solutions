package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 79: Inheritance ve field initialization order
 * 
 * Field initialization sırası
 * Static vs instance vs constructor
 * Çıktı ne olur?
 */
class OOP79A {
    static int staticA = getStatic("A");
    int instanceA = getInstance("A");
    
    static {
        System.out.println("A static block");
    }
    
    {
        System.out.println("A instance block");
    }
    
    OOP79A() {
        System.out.println("A constructor");
    }
    
    static int getStatic(String name) {
        System.out.println("Static " + name);
        return 1;
    }
    
    int getInstance(String name) {
        System.out.println("Instance " + name);
        return 1;
    }
}

class OOP79B extends OOP79A {
    static int staticB = getStatic("B");
    int instanceB = getInstance("B");
    
    static {
        System.out.println("B static block");
    }
    
    {
        System.out.println("B instance block");
    }
    
    OOP79B() {
        System.out.println("B constructor");
    }
    
    static int getStatic(String name) {
        System.out.println("Static " + name);
        return 2;
    }
    
    int getInstance(String name) {
        System.out.println("Instance " + name);
        return 2;
    }
}

public class OOP79 {
    public static void main(String[] args) {
        new OOP79B();
    }
}

// ÇIKTI:
// Static A
// A static block
// Static B
// B static block
// Instance A
// A instance block
// A constructor
// Instance B
// B instance block
// B constructor
// Önce static (parent->child), sonra instance (parent->child), sonra constructor (parent->child)




