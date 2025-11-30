package com.fsk.interviews.interviewrepairing.oop;

class Main7AClazz {
    void m(){ System.out.println("A"); }
}

class Main7BClazz extends Main7AClazz {
    void m(){ System.out.println("B"); }
}

class Main7CClazz extends Main7BClazz {
    void m(){ System.out.println("C"); }
}

public class Main7 {
    public static void main(String[] args) {
        Main7AClazz obj = new Main7CClazz();
        obj.m();
    }
}