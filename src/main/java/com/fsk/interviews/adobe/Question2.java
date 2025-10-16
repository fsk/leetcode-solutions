package com.fsk.interviews.adobe;

import java.util.HashSet;
import java.util.Set;

public class Question2 {

    public static void main(String[] args) {

    }


    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
             String[] emailArr = email.split("@");
            emailArr[0] = emailArr[0].replace(".", "");
            String newEmail;
            if (emailArr[0].contains("+")) {
                emailArr[0] = emailArr[0].substring(0, emailArr[0].indexOf("+"));
            }
            newEmail = emailArr[0] + "@" + emailArr[1];
            set.add(newEmail);
        }

        return set.size();
    }
}
