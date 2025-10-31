package com.fsk;

public class Main82 {

    public static void main(String[] args) {
    }

    public static int smallestNumber2(int n) {
        if ((n & (n + 1)) == 0) return n;
        int power = 1;
        while (power <= n) {
            power <<= 1;
        }
        return power - 1;
    }

    public static int smallestNumber(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int bit = n % 2;
            n = n / 2;
            sb.append(bit);
        }
        char[] bitChars = sb.toString().toCharArray();
        for (int i = 0; i <= bitChars.length - 1; i++) {
            if(bitChars[i] == '0'){
                bitChars[i] = '1';
            }
        }
        int sum = 0;
        int pow = 0;
        for (int i = bitChars.length - 1; i >= 0; i--) {
            sum = (int) (sum + ((bitChars[i] - '0') * (Math.pow(2, pow))));
            pow++;
        }
        return sum;
    }

    public static int smallestNumber3(int n) {
        String a=Integer.toBinaryString(n);
        int len=a.length();
        int power= (int)Math.pow(2,len);
        return power-1;
    }
}
