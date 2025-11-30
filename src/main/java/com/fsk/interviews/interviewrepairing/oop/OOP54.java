//package com.fsk.interviews.interviewrepairing.oop;
//
///**
// * SORU 54: Null ve instanceof operator
// *
// * Null instanceof kontrolü nasıl çalışır?
// * Çıktı ne olur?
// */
//class OOP54A {
//}
//
//class OOP54B extends OOP54A {
//}
//
//public class OOP54 {
//    public static void main(String[] args) {
//        OOP54A obj = null;
//
//        System.out.println("null instanceof OOP54A: " + (obj instanceof OOP54A));
//        System.out.println("null instanceof OOP54B: " + (obj instanceof OOP54B));
//        System.out.println("null instanceof Object: " + (obj instanceof Object));
//        System.out.println("null instanceof String: " + (obj instanceof String));
//
//        // Null her zaman false döner (null bir tip değildir)
//        if (obj instanceof OOP54A) {
//            System.out.println("This won't print");
//        } else {
//            System.out.println("Null is not an instance of any class");
//        }
//    }
//}
//
//// ÇIKTI:
//// null instanceof OOP54A: false
//// null instanceof OOP54B: false
//// null instanceof Object: false
//// null instanceof String: false
//// Null instanceof her zaman false döner
//
//
