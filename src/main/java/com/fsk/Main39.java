package com.fsk;

/**
 * LeetXode -> 387. First Unique Character in a String
 */

public class Main39 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }




    public static int firstUniqChar(String s) {
        char[] a = s.toCharArray();
        for(int i=0; i<a.length;i++){
            if(s.indexOf(a[i])==s.lastIndexOf(a[i])){
                return i;
            }
        }
        return -1;
    }

}
