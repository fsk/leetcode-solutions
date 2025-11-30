package com.fsk.interviews.interviewrepairing.oop;

class Main11AClazz {
    Main11AClazz() {
        show();
    }

    void show() {
        System.out.println("A");
    }
}

class Main11BClazz extends Main11AClazz {
    int x = 10;

    Main11BClazz() {
        super();
    }

    void show() {
        System.out.println(x);
    }
}

public class Main11 {
    public static void main(String[] args) {
        //Main11AClazz obj = new Main11BClazz();
        //obj.show();
        new Main11BClazz();
    }
}