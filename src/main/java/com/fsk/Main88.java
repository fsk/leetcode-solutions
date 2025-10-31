package com.fsk;

import java.util.ArrayList;
import java.util.List;

public class Main88 {

    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }else if (i % 3 == 0) {
                list.add("Fizz");
            }else if (i % 5 == 0) {
                list.add("Buzz");
            }else  {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }


    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) str = str + "Fizz";
            if (i % 5 == 0) str = str + "Buzz";
            list.add(str.isEmpty() ? String.valueOf(i) : str);
        }
        return list;
    }
}
