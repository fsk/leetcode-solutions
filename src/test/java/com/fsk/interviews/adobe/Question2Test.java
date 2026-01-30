package com.fsk.interviews.adobe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    @Test
    void numUniqueEmails() {

        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int actual = Question2.numUniqueEmails(emails);
        int expected = 2;
        assertEquals(expected, actual);
    }


    @Test
    void numUniqueEmails_Test2() {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        int actual = Question2.numUniqueEmails(emails);
        int expected = 3;
        assertEquals(expected, actual);
    }


    @Test
    void numUniqueEmails_Test3() {
        String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        int actual = Question2.numUniqueEmails(emails);
        int expected = 2;
        assertEquals(expected, actual);
    }
}