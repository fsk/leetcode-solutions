package com.fsk.interviews.interviewrepairing.oop;

class Main4AClazz {
    void print() { System.out.println("Print A"); }
}

class Main4BClazz extends Main4AClazz {
    void print() { System.out.println("Print B"); }
}

class Main4CClazz extends Main4BClazz {
    void print() { System.out.println("Print C"); }
}

public class Main4 {
    public static void main(String[] args) {
        Main4AClazz instanceA = new Main4CClazz();
        instanceA.print();
    }
}