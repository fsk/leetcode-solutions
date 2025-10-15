package com.fsk;


/**
 * LeetCode 190
 * Reverse Bits to number
 */

public class Main66 {

    public static void main(String[] args) {
        //System.out.println(reverseBit(2147483644));
        System.out.println(reverseBit3(17));
    }

    public static int reverseBit(int x) {
        StringBuilder binary = new StringBuilder();
        while (x > 0) {
            int remainder = x % 2;
            binary.insert(0, remainder);
            x = x / 2;
        }

        while (binary.length() < 32) {
            binary.insert(0, '0');
        }

        return Integer.parseUnsignedInt(binary.reverse().toString(), 2);
    }

    public static int reverseBit2(int x) {
        String binaryString = Integer.toBinaryString(x);
        StringBuilder binary = new StringBuilder(binaryString).reverse();
        return Integer.parseInt(binary.toString(), 2);
    }

    public static int reverseBit3(int x) {
        int[] bitArr = new int[32];
        int bin = toBinary(x);
        int len = digitCount(bin);
        int idx = 31;
        for (int j = 0; j < len; j++) {
            bitArr[idx--] = bin % 10;
            bin /= 10;
        }

        for (int i = 0; i < bitArr.length / 2; i++) {
            int temp = bitArr[i];
            bitArr[i] = bitArr[bitArr.length - 1 - i];
            bitArr[bitArr.length - 1 - i] = temp;
        }

        int reversedBinary = 0;
        for (int i = 0; i < bitArr.length; i++) {
            reversedBinary = reversedBinary * 10 + bitArr[i];
        }

        return reversedBinary;
    }


    public static int toBinary(int n) {
        if (n == 0) return 0;
        return (n % 2) + 10 * toBinary(n / 2);
    }

    public static int digitCount(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }


    public static int reverseBit4(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }

        return result;
    }


}
