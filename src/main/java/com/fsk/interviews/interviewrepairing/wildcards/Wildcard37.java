package com.fsk.interviews.interviewrepairing.wildcards;

/**
 * SORU 37: Wildcard ve generic class
 * 
 * Generic class içinde wildcard kullanımı
 * Çıktı ne olur?
 */
class Box<T> {
    private T value;
    
    public void set(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
    
    // Wildcard parameter
    public void copyFrom(Box<? extends T> source) {
        this.value = source.get(); // Read from source
    }
    
    // Wildcard parameter
    public void copyTo(Box<? super T> dest) {
        dest.set(this.value); // Write to dest
    }
}

public class Wildcard37 {
    public static void main(String[] args) {
        Box<Number> numberBox = new Box<>();
        numberBox.set(10);
        
        Box<Integer> intBox = new Box<>();
        intBox.set(20);
        
        // Copy from Integer to Number
        numberBox.copyFrom(intBox);
        System.out.println("Number box: " + numberBox.get());
        
        // Copy from Number to Object
        Box<Object> objectBox = new Box<>();
        numberBox.copyTo(objectBox);
        System.out.println("Object box: " + objectBox.get());
    }
}

// ÇIKTI:
// Number box: 20
// Object box: 20
// Generic class içinde wildcard kullanılabilir
// PECS principle uygulanır

