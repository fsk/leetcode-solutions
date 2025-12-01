package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 11: Upper bounded wildcard ve inheritance
 * 
 * ? extends Number ile Number'ın tüm subclass'ları kabul edilir
 * Çıktı ne olur?
 */
class Animal {
    String name;
    Animal(String name) { this.name = name; }
    public String toString() { return name; }
}

class Dog extends Animal {
    Dog(String name) { super(name); }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
}

public class Wildcard11 {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
        }
    }
    
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Buddy"));
        dogs.add(new Dog("Max"));
        
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Whiskers"));
        cats.add(new Cat("Fluffy"));
        
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Generic"));
        
        printAnimals(dogs);
        printAnimals(cats);
        printAnimals(animals);
    }
}

// ÇIKTI:
// Animal: Buddy
// Animal: Max
// Animal: Whiskers
// Animal: Fluffy
// Animal: Generic
// Upper bounded wildcard tüm subclass'ları kabul eder




