//package com.fsk.interviews.interviewrepairing.oop;
//
///**
// * SORU 65: Polymorphism ve exception handling
// *
// * Override edilen metod farklı exception fırlatabilir mi?
// * Exception hierarchy ve polymorphism
// * Çıktı ne olur?
// */
//import java.io.IOException;
//
//class OOP65A {
//    void method() throws IOException {
//        System.out.println("A method()");
//        throw new IOException("A exception");
//    }
//
//    void method2() throws Exception {
//        System.out.println("A method2()");
//    }
//}
//
//class OOP65B extends OOP65A {
//    @Override
//    void method() throws IOException { // Aynı veya daha spesifik
//        System.out.println("B method()");
//    }
//
//    // @Override
//    // void method2() throws IOException { } // OK, IOException Exception'ın subclass'ı
//
//    @Override
//    void method2() throws RuntimeException { // Unchecked exception, sorun yok
//        System.out.println("B method2()");
//    }
//}
//
//public class OOP65 {
//    public static void main(String[] args) {
//        OOP65A obj = new OOP65B();
//        try {
//            obj.method();
//        } catch (IOException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        obj.method2(); // Unchecked exception
//    }
//}
//
//// ÇIKTI:
//// B method()
//// B method2()
//// Override edilen metod aynı veya daha spesifik exception fırlatabilir
//// Unchecked exception her zaman fırlatılabilir
//
//


