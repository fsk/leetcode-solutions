package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 13: Upper bounded wildcard ve multiple bounds
 * 
 * ? extends T & U şeklinde multiple bound kullanılabilir mi?
 * Çıktı ne olur?
 */
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Duck flying"); }
    public void swim() { System.out.println("Duck swimming"); }
}

public class Wildcard13 {
    // Multiple bound - sadece type parameter'da kullanılabilir
    public static <T extends Flyable & Swimmable> void process(T animal) {
        animal.fly();
        animal.swim();
    }
    
    // Wildcard'ta multiple bound kullanılamaz
    // public static void process2(List<? extends Flyable & Swimmable> list) { } // HATA!
    
    public static void process2(List<? extends Flyable> list) {
        for (Flyable f : list) {
            f.fly();
        }
    }
    
    public static void main(String[] args) {
        Duck duck = new Duck();
        process(duck);
        
        List<Duck> ducks = new ArrayList<>();
        ducks.add(duck);
        process2(ducks);
    }
}

// ÇIKTI:
// Duck flying
// Duck swimming
// Duck flying
// Wildcard'ta multiple bound kullanılamaz, sadece type parameter'da kullanılabilir


