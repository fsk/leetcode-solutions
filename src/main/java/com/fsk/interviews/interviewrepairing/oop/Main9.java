package com.fsk.interviews.interviewrepairing.oop;

class Main9A {
    String x = "10";
    String getX() { return x; }
}

class Main9B extends Main9A {
    String x = "20";
    String getX() { return x; }
}

public class Main9 {
    public static void main(String[] args) {
        Main9A obj = new Main9B();
        System.out.println(obj.x);
        System.out.println(obj.getX());
    }
}