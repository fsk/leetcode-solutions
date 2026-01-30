package com.fsk.interviews.interviewrepairing.oop;

class Main12X {
    void method(Object o) { System.out.println("Object"); }
    void method(String s) { System.out.println("String"); }
    void method(Integer i) { System.out.println("Integer"); }
    void method(Double d) { System.out.println("Double"); }
    void method(Float f) { System.out.println("Float"); }
    void method(Long l) { System.out.println("Long"); }
    void method(Short s) { System.out.println("Short"); }
    void method(Byte b) { System.out.println("Byte"); }
    void method(Character c) { System.out.println("Character"); }
    void method(Boolean b) { System.out.println("Boolean"); }


    void method2(Object o) { System.out.println("Object"); }
    void method2(Integer s) { System.out.println("Integer"); }
}


public class Main12 {
    public static void main(String[] args) {
        Main12X x = new Main12X();
        x.method2(null);
    }
}
