//package com.fsk.interviews.interviewrepairing.oop;
//
///**
// * SORU 86: Polymorphism ve exception extreme case
// *
// * Exception hierarchy ve polymorphism
// * Checked vs unchecked exception override
// * Çıktı ne olur?
// */
//import java.io.IOException;
//
//class OOP86A {
//    void method() throws IOException {
//        System.out.println("A method()");
//    }
//
//    void method2() throws Exception {
//        System.out.println("A method2()");
//    }
//
//    void method3() {
//        System.out.println("A method3()");
//    }
//}
//
//class OOP86B extends OOP86A {
//    @Override
//    void method() throws IOException { // OK
//        System.out.println("B method()");
//    }
//
//    // @Override
//    // void method2() throws IOException { } // OK, IOException Exception'ın subclass'ı
//
//    @Override
//    void method2() throws RuntimeException { // OK, unchecked
//        System.out.println("B method2()");
//    }
//
//    @Override
//    void method3() throws RuntimeException { // OK, unchecked eklenebilir
//        System.out.println("B method3()");
//    }
//}
//
//public class OOP86 {
//    public static void main(String[] args) {
//        OOP86A obj = new OOP86B();
//        try {
//            obj.method();
//        } catch (IOException e) {
//            // Handle
//        }
//
//        obj.method2(); // Unchecked exception
//        obj.method3(); // Unchecked exception
//    }
//}
//
//// ÇIKTI:
//// B method()
//// B method2()
//// B method3()
//// Override edilen metod aynı veya daha spesifik checked exception fırlatabilir
//// Unchecked exception her zaman eklenebilir
//
//


