package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 36: Interface ve class aynı isim
 * 
 * Interface ve class aynı isimde olabilir mi?
 * Hangi durumda çakışma olur?
 * Çıktı ne olur?
 */
interface OOP36Interface {
    void method();
}

class OOP36Class {
    void method() {
        System.out.println("Class method()");
    }
}

// Aynı isimde interface ve class aynı package'da olamaz
// Farklı package'larda olabilirler

public class OOP36 {
    public static void main(String[] args) {
        OOP36Class obj = new OOP36Class();
        obj.method();
    }
}

// ÇIKTI:
// Class method()
// Aynı isimde interface ve class olabilir ama farklı package'larda olmalı
// Aynı package'da olamazlar

