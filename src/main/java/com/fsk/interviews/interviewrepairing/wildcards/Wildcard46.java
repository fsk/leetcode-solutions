package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 46: Wildcard ve exception handling
 * 
 * Wildcard ile exception handling
 * Generic exception
 * Çıktı ne olur?
 */
public class Wildcard46 {
    public static <T extends Exception> void processException(
            List<? extends T> exceptions) {
        for (T ex : exceptions) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        List<RuntimeException> runtimeExceptions = new ArrayList<>();
        runtimeExceptions.add(new RuntimeException("Error 1"));
        runtimeExceptions.add(new IllegalArgumentException("Error 2"));
        
        processException(runtimeExceptions);
        
        List<Exception> exceptions = new ArrayList<>();
        exceptions.add(new Exception("Error 3"));
        processException(exceptions);
    }
}

// ÇIKTI:
// Exception: Error 1
// Exception: Error 2
// Exception: Error 3
// Wildcard exception handling ile kullanılabilir
// Upper bounded wildcard exception hierarchy'de çalışır




