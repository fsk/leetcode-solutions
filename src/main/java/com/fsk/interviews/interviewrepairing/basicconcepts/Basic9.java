package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 9: Autoboxing ve varargs
 * 
 * Varargs ile autoboxing nasıl çalışır?
 * Çıktı ne olur?
 */
public class Basic9 {
    static void method(int... args) {
        System.out.println("method(int...): " + args.length);
        for (int arg : args) {
            System.out.println("  int: " + arg);
        }
    }
    
    // Integer... varargs int... ile aynı signature (type erasure)
    // Bu yüzden aynı anda kullanılamaz
    // static void method(Integer... args) { } // HATA! Ambiguous
    
    static void method2(Integer... args) {
        System.out.println("method2(Integer...): " + args.length);
    }
    
    public static void main(String[] args) {
        method(10, 20); // Hangi metod? method(int...)
        // method(new Integer(10), new Integer(20)); // HATA! Ambiguous - int... ve Integer... aynı signature (type erasure)
        method2(10, 20); // Autoboxing
        method2(Integer.valueOf(10), Integer.valueOf(20));
    }
}

// ÇIKTI:
// method(int...): 2
//   int: 10
//   int: 20
// method2(Integer...): 2
// method2(Integer...): 2
// Varargs ile autoboxing çalışır
// NOT: int... ve Integer... aynı signature'a sahiptir (type erasure)
// Bu yüzden aynı anda kullanılamaz - ambiguous error

