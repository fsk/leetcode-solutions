package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 44: Cloneable interface ve shallow vs deep copy
 * 
 * Cloneable interface marker interface'dir.
 * clone() metodu nasıl çalışır?
 * Shallow vs deep copy nedir?
 * Çıktı ne olur?
 */
class OOP44Test implements Cloneable {
    int x;
    int[] array;
    
    OOP44Test(int x, int[] array) {
        this.x = x;
        this.array = array;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        OOP44Test cloned = (OOP44Test) super.clone(); // Shallow copy
        cloned.array = array.clone(); // Deep copy for array
        return cloned;
    }
}

public class OOP44 {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1, 2, 3};
        OOP44Test obj1 = new OOP44Test(10, arr);
        OOP44Test obj2 = (OOP44Test) obj1.clone();
        
        obj2.x = 20;
        obj2.array[0] = 100;
        
        System.out.println("obj1.x = " + obj1.x);
        System.out.println("obj2.x = " + obj2.x);
        System.out.println("obj1.array[0] = " + obj1.array[0]);
        System.out.println("obj2.array[0] = " + obj2.array[0]);
    }
}

// ÇIKTI:
// obj1.x = 10 (primitive, değişmedi)
// obj2.x = 20
// obj1.array[0] = 1 (deep copy, değişmedi)
// obj2.array[0] = 100
// Shallow copy: Reference kopyalanır, deep copy: Object kopyalanır




