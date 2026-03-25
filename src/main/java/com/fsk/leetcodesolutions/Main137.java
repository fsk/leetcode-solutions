package com.fsk.leetcodesolutions;

// LeetCode => 1108. Defanging an IP Address

public class Main137 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
