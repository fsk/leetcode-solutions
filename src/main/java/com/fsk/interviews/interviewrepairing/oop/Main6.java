package com.fsk.interviews.interviewrepairing.oop;


class Main6AClazz {
    static void print() { System.out.println("Print A"); }
}

class Main6BClazz extends Main6AClazz {
    static void print() { System.out.println("Print B"); }
}

class Main6CClazz extends Main6BClazz {
    static void print() { System.out.println("Print C"); }
}

public class Main6 {

    public static void main(String[] args) {
        Main6AClazz instanceA = new Main6CClazz();
        instanceA.print();
    }
    
}
