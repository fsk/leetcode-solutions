package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 1: Integer caching ve == comparison
 * 
 * Integer cache -128 ile 127 arası değerler
 * == vs equals() farkı
 * Çıktı ne olur?
 */
public class Basic1 {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        
        System.out.println("a == b (100): " + (a == b));
        System.out.println("c == d (200): " + (c == d));
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("c.equals(d): " + c.equals(d));
        
        Integer e = new Integer(100);
        Integer f = new Integer(100);
        System.out.println("e == f (new): " + (e == f));
        System.out.println("a == e: " + (a == e));
    }
}

// ÇIKTI:
// a == b (100): true (cache'den)
// c == d (200): false (cache dışı)
// a.equals(b): true
// c.equals(d): true
// e == f (new): false (yeni nesne)
// a == e: false (cache vs new)
// Integer -128 ile 127 arası cache'lenir, == referans karşılaştırması yapar


