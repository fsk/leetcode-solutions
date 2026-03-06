package com.fsk.leetcodesolutions;

public class Main114 {

    public static void main(String[] args) {
        //System.out.println(isValid("234Adas"));
        //System.out.println(isValid("b3"));
        System.out.println(isValid2("şşşaa"));
    }

    public static boolean isValid(String word) {
        return word.matches("^(?=.*[aeiouAEIOU])(?=.*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])[A-Za-z0-9]{3,}$");
    }

    public static boolean isValid2(String word) {
        if (word.length() < 3 || !word.matches("[a-zA-Z0-9]+")) return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}
