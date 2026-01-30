package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 5: Final variable initialization trick
 * 
 * Final instance variable'lar ne zaman initialize edilmelidir?
 * Final variable'ın değeri constructor'da değiştirilebilir mi?
 * Çıktı ne olur?
 */
class OOP5Test {
    final int x;
    final int y = getY();
    static final int z = getZ();
    
    {
        System.out.println("Instance initializer block");
        x = 10; // Instance initializer block'ta initialize edilebilir
    }
    
    OOP5Test() {
        // x = 20; // HATA! x zaten initialize edilmiş
        System.out.println("Constructor: x = " + x + ", y = " + y + ", z = " + z);
    }
    
    int getY() {
        System.out.println("getY() called");
        return 30;
    }
    
    static int getZ() {
        System.out.println("getZ() called");
        return 40;
    }
}

public class OOP5 {
    public static void main(String[] args) {
        new OOP5Test();
    }
}

// ÇIKTI:
// getZ() called (static final, class load sırasında)
// getY() called (instance final, instance oluşturulurken)
// Constructor: x = 10, y = 30, z = 40


