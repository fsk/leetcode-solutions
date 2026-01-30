package com.fsk.interviews.interviewrepairing.oop;

class Main3 {
    public static void main(String[] args) {

        Main3Animal a = new Main3Dog();
        a.sound();
        a.eat();

    }
}

class Main3Animal {
    void sound() { System.out.println("Animal sound"); }

    void eat() { System.out.println("Animal eat"); }
}

class Main3Dog extends Main3Animal {
    void sound() { System.out.println("Dog sound"); }
}
