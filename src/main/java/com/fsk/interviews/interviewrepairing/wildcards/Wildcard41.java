package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 41: Wildcard ve recursive generic
 * 
 * Recursive generic type ile wildcard
 * Çıktı ne olur?
 */
interface Comparable<T extends Comparable<T>> {
    int compareTo(T other);
}

class Person implements Comparable<Person> {
    String name;
    Person(String name) { this.name = name; }
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    public String toString() { return name; }
}

public class Wildcard41 {
    // Upper bounded wildcard with recursive generic
    public static <T extends Comparable<T>> T max(List<? extends T> list) {
        if (list.isEmpty()) return null;
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));
        people.add(new Person("Charlie"));
        
        Person maxPerson = max(people);
        System.out.println("Max: " + maxPerson);
    }
}

// ÇIKTI:
// Max: Charlie
// Recursive generic type ile wildcard kullanılabilir
// Upper bounded wildcard recursive bound ile çalışır




