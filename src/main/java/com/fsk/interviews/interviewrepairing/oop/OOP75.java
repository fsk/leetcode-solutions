//package com.fsk.interviews.interviewrepairing.oop;
//
///**
// * SORU 75: Static method ve instance method aynı signature
// *
// * Static ve instance metod aynı signature'a sahip olabilir mi?
// * Overload mı override mı?
// * Çıktı ne olur?
// */
//class OOP75A {
//    static void method(String s) {
//        System.out.println("A static method(String)");
//    }
//
//    void method(int i) {
//        System.out.println("A instance method(int)");
//    }
//}
//
//class OOP75B extends OOP75A {
//    // static void method(String s) { } // Hide, override değil
//
//    void method(String s) { // Instance method, static'i hide etmez
//        System.out.println("B instance method(String)");
//    }
//
//    @Override
//    void method(int i) {
//        System.out.println("B instance method(int)");
//    }
//}
//
//public class OOP75 {
//    public static void main(String[] args) {
//        OOP75A.method("test"); // Static metod
//        OOP75B.method("test"); // Static metod (hide)
//
//        OOP75A obj1 = new OOP75A();
//        OOP75A obj2 = new OOP75B();
//
//        obj1.method("test"); // Static metod (derleyici uyarı)
//        obj2.method("test"); // Static metod (compile-time tip)
//        obj1.method(10);
//        obj2.method(10); // Instance metod (runtime tip)
//
//        OOP75B obj3 = new OOP75B();
//        obj3.method("test"); // Instance metod
//        obj3.method(10); // Instance metod
//    }
//}
//
//// ÇIKTI:
//// A static method(String)
//// A static method(String) (hide)
//// A static method(String)
//// A static method(String)
//// A instance method(int)
//// B instance method(int)
//// B instance method(String)
//// B instance method(int)
//// Static ve instance metod aynı signature'a sahip olabilir, farklı metodlardır
//
//


