package com.fsk.interviews.interviewrepairing.oop;

class Main10P {
    static { System.out.println("P static"); }
    { System.out.println("P init"); }
    Main10P(){ System.out.println("P ctor"); }
}

class Main10Q extends Main10P {
    static { System.out.println("Q static"); }
    { System.out.println("Q init"); }
    Main10Q(){ System.out.println("Q ctor"); }
}

public class Main10 {
    public static void main(String[] args) {
        new Main10Q();
        new Main10Q();
    }
}
