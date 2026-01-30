package com.fsk.interviews.interviewrepairing.oop;

class Java13A {
    Java13A() {
        this(10);
    }

    Java13A(int x) {
        System.out.println("x = " + x);
    }
}

class Java13B extends Java13A {
    Java13B() {
        super(20);
        System.out.println("Java13B");
    }
}


public class Java13 {
    public static void main(String[] args) {
        new Java13B();
    }
}
