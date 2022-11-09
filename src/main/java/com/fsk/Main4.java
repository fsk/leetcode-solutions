package com.fsk;

public class Main4 {

    public static void main(String[] args) {
        System.out.println(square(8));
    }

    public static int square(int x) {
        return x < 0 ? -1 :  (int) Math.floor(Math.sqrt(x));
    }
}
