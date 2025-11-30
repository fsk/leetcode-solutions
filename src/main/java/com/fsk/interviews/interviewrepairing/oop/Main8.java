package com.fsk.interviews.interviewrepairing.oop;

class Main8X {
    void show() { System.out.println("X"); }
}

class Main8Y extends Main8X {
    void show() { 
        super.show();
        System.out.println("Y");
    }
}

public class Main8 {
    public static void main(String[] args) {
        new Main8Y().show();
    }
}