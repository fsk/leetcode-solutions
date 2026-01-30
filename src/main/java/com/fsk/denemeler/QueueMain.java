package com.fsk.denemeler;

import java.util.NoSuchElementException;

public class QueueMain {
    public static void main(String[] args) {
        QueueClass queue = new QueueClass();

        System.out.println("Kuyruğa elemanlar ekleniyor: 5, 10, 15");
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        System.out.println("Kuyruk içeriği:");
        queue.printQueue();

        System.out.println("Kuyruktan bir eleman çıkarılıyor: " + queue.dequeue());

        System.out.println("Kuyruğun yeni durumu:");
        queue.printQueue();

        System.out.println("Kuyruğun başındaki eleman: " + queue.peek());

        System.out.println("Kuyruğa yeni elemanlar ekleniyor: 20, 25");
        queue.enqueue(20);
        queue.enqueue(25);

        System.out.println("Kuyruğun son durumu:");
        queue.printQueue();
    }
}
