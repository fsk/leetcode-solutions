package com.fsk.interviews.interviewrepairing.oop;

class Main1AClazz {
    public Main1AClazz() {
        System.out.println("Constructor A");
    }

    {
        System.out.println("Instance Block A");
    }

    static {
        System.out.println("Static Block A");
    }
}

class Main1BClazz extends Main1AClazz {
    public Main1BClazz() {
        System.out.println("Constructor B");
    }

    {
        System.out.println("Instance Block B");
    }

    static {
        System.out.println("Static Block B");
    }
}

class Main1CClazz extends Main1BClazz {

    {
        System.out.println("Instance Block C");
    }

    public Main1CClazz() {
        System.out.println("Constructor C");
    }

    static {
        System.out.println("Static Block C");
    }
}

public class Main1 {
    public static void main(String[] args) {
        new Main1CClazz();
    }
}
