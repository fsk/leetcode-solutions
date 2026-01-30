package com.fsk.denemeler.linkedliststructure.circular;

class MyNode {
    int data;
    MyNode next;

    public MyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    MyNode head = null;
    MyNode tail = null;

    // Liste sonuna ekleme yap
    public void add(int index, int data) {
        MyNode newNode = new MyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Listenin dairesel yapısını koru
        } else {
            MyNode current = head;
            int count = 0;
            while (count < index - 1 && current.next != head) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode; // Eğer sona ekleme yapıyorsak, tail'i güncelle
            }
        }
    }


    // Belirli bir değeri sil
    public void delete(int key) {
        if (head == null) {
            return;
        }
        MyNode current = head;
        MyNode previous = null;
        while (true) {
            if (current.data == key) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                    if (head == tail) {
                        head = null;
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
            if (current == head) break; // Döngüyü kır, başa döndük
        }
    }

    // Listenin içeriğini yazdır
    public void printList() {
        if (head != null) {
            MyNode current = head;
            while (true) {
                System.out.print(current.data + " -> ");
                current = current.next;
                if (current == head) break; // Döngüyü kır, başa döndük
            }
            System.out.println("(head)");
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.printList(); // 1 -> 2 -> 3 -> (head)

        list.delete(2);
        list.printList(); // 1 -> 3 -> (head)
    }
}
