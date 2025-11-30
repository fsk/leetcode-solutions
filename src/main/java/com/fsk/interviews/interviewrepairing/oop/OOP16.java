package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 16: Method overriding ve access modifier
 * 
 * Override edilen metodun access modifier'ı değiştirilebilir mi?
 * Daha kısıtlayıcı olabilir mi?
 * Çıktı ne olur?
 */
class OOP16A {
    protected void protectedMethod() {
        System.out.println("A protectedMethod()");
    }
    
    public void publicMethod() {
        System.out.println("A publicMethod()");
    }
    
    void packageMethod() {
        System.out.println("A packageMethod()");
    }
}

class OOP16B extends OOP16A {
    @Override
    public void protectedMethod() { // Daha geniş olabilir (protected -> public)
        System.out.println("B protectedMethod()");
    }
    
    // @Override
    // protected void publicMethod() { } // HATA! Daha kısıtlayıcı olamaz
    
    @Override
    public void packageMethod() { // Daha geniş olabilir (package -> public)
        System.out.println("B packageMethod()");
    }
}

public class OOP16 {
    public static void main(String[] args) {
        OOP16B obj = new OOP16B();
        obj.protectedMethod();
        obj.publicMethod();
        obj.packageMethod();
    }
}

// ÇIKTI:
// B protectedMethod()
// A publicMethod()
// B packageMethod()
// Override edilen metod daha geniş access modifier'a sahip olabilir, daha kısıtlayıcı olamaz


