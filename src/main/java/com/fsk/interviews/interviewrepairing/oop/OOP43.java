package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 43: Reflection ve private field access
 * 
 * Reflection ile private field'lara erişilebilir mi?
 * Final field değiştirilebilir mi?
 * Çıktı ne olur?
 */
import java.lang.reflect.Field;

class OOP43Test {
    private int x = 10;
    private final int y = 20;
    private static final int z = 30;
}

public class OOP43 {
    public static void main(String[] args) throws Exception {
        OOP43Test obj = new OOP43Test();
        
        Field fieldX = OOP43Test.class.getDeclaredField("x");
        fieldX.setAccessible(true);
        fieldX.setInt(obj, 100);
        System.out.println("x = " + fieldX.getInt(obj));
        
        Field fieldY = OOP43Test.class.getDeclaredField("y");
        fieldY.setAccessible(true);
        fieldY.setInt(obj, 200);
        System.out.println("y = " + fieldY.getInt(obj));
        
        Field fieldZ = OOP43Test.class.getDeclaredField("z");
        fieldZ.setAccessible(true);
        fieldZ.setInt(null, 300);
        System.out.println("z = " + fieldZ.getInt(null));
    }
}

// ÇIKTI:
// x = 100
// y = 200 (final instance field değiştirilebilir ama tehlikeli)
// z = 300 (final static field değiştirilebilir ama tehlikeli)
// Reflection ile private ve final field'lara erişilebilir ama önerilmez




