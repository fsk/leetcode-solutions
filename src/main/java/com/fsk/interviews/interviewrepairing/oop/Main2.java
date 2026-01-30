package com.fsk.interviews.interviewrepairing.oop;

class Main2AClazz {
    static { System.out.println("static A"); }
    { System.out.println("instance A"); }

    Main2AClazz() {
        System.out.println("constructor A");
    }
}

class Main2BClazz extends Main2AClazz {
    static { System.out.println("static B"); }
    { System.out.println("instance B"); }

    Main2BClazz() {
        System.out.println("constructor B");
    }
}

public class Main2 {
    public static void main(String[] args) {
        new Main2BClazz();
    }
}
