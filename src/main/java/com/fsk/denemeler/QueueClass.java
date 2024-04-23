package com.fsk.denemeler;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueClass {
    private LinkedList<Integer> items;

    public QueueClass() {
        items = new LinkedList<>();
    }

    // Kuyruğa eleman ekler
    public void enqueue(int item) {
        items.addLast(item);
    }

    // Kuyruktan eleman çıkarır ve döndürür
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.removeFirst();
    }

    // Kuyruğun başındaki elemanı döndürür
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.getFirst();
    }

    // Kuyruğun boş olup olmadığını kontrol eder
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Kuyruğun boyutunu döndürür
    public int size() {
        return items.size();
    }

    // Kuyruk içeriğini yazdırır
    public void printQueue() {
        System.out.println(items.toString());
    }
}

