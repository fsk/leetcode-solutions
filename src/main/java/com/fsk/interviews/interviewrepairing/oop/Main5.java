package com.fsk.interviews.interviewrepairing.oop;

class Main5AClazz {
    int x = 10;
    void print() { System.out.println("A"); }
}

class Main5BClazz extends Main5AClazz {
    int x = 20;
    void print() { System.out.println("B " + x + " " + super.x); }
}

public class Main5 {
    public static void main(String[] args) {
        Main5AClazz obj = new Main5BClazz();
        obj.print();
    }
}