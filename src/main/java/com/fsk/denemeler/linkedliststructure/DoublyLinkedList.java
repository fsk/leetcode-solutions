package com.fsk.denemeler.linkedliststructure;

class Node2 {
    int data;
    Node2 prev;
    Node2 next;

    // Düğüm yapıcı metod
    public Node2(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node2 head, tail;

    // Çift yönlü bağlı liste yapıcı metodu
    public DoublyLinkedList() {
        head = tail = null;
    }

    // Listenin sonuna bir düğüm ekler
    public void add(int index, int data) {
        Node2 newNode = new Node2(data);

        // Liste boşsa veya başa ekleme yapılacaksa
        if (head == null || index == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            Node2 current = head;
            int count = 0;

            // İstenen index'e kadar ilerle
            while (current != null && count < index) {
                current = current.next;
                count++;
            }

            // Listenin sonuna ekleme yapılıyorsa
            if (current == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                // Araya ekleme yapılıyorsa
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
    }


    // Belirli bir değeri siler
    public void delete(int data) {
        if (head == null) return;

        Node2 current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) return; // Değer bulunamadı

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Head siliniyorsa head'i güncelle
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Tail siliniyorsa tail'i güncelle
        }
    }

    // Listeyi baştan sona yazdırır
    public void printForward() {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Listeyi sondan başa yazdırır
    public void printBackward() {
        Node2 current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

class Main2 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(0,1);
        dll.add(1, 2);
        dll.add(2, 3);

        System.out.println("Original list:");
        dll.printForward(); // 1 2 3

        dll.delete(2);

        System.out.println("After deleting 2:");
        dll.printForward(); // 1 3

        System.out.println("Print backward:");
        dll.printBackward(); // 3 1
    }
}

