package com.fsk.denemeler.linkedliststructure;

class MyNode {
    int data; // Düğümün içereceği veri
    MyNode next; // Bir sonraki düğüme işaretçi

    // Düğüm sınıfının yapıcı metodunu tanımla
    public MyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    MyNode head; // Bağlı listenin başını tutacak

    // Bağlı listeye yeni bir düğüm ekleyen metod
    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data); // Listenin başına ekleme yap
            return;
        }

        MyNode newNode = new MyNode(data);
        MyNode current = head;
        int count = 0;

        // İstenen index'e kadar veya listenin sonuna kadar ilerle
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        // Eğer current null değilse, doğru konumdayızdır
        if (current != null) {
            newNode.next = current.next; // Yeni düğümün next'i, current'ın next'ini göstersin
            current.next = newNode; // Current'ın next'i olarak yeni düğümü ayarla
        } else {
            // Eğer current null ise, bu index'in listenin uzunluğunu aştığını gösterir
            // Bu durumda, ekleme işlemi yapılmaz veya hata mesajı verilebilir
            System.out.println("Index out of bounds");
        }
    }

    // Listenin başına ekleme yapmak için bir metod
    public void addFirst(int data) {
        MyNode newNode = new MyNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Bağlı listeyi konsola yazdıran metod
    public void printList() {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Bağlı listeden bir düğüm silen metod
    public void delete(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        MyNode current = head;
        MyNode previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) return;

        previous.next = current.next;
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 33);
        list.printList(); // Liste içeriğini yazdır: 1 -> 2 -> 3 -> null

        list.delete(2); // Listeden '2' değerini sil
        list.printList(); // Güncellenmiş liste içeriğini yazdır: 1 -> 3 -> null
    }
}

