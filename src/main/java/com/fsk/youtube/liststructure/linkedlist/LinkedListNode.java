package com.fsk.youtube.liststructure.linkedlist;

public class LinkedListNode {

    public int data;
    public LinkedListNode next;
    public LinkedListNode head;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode() {
        this.head = null;
    }

    public void add(int value) {

        LinkedListNode node = new LinkedListNode(value);

        if (head == null) {
            head = node;
        }else {
            LinkedListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

    }

    public int size() {
        int count = 0;
        LinkedListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int delete(int value) {
        if (head == null) {
            return -1;
        }

        // Eğer silinecek değer head'de ise
        if (head.data == value) {
            int deletedValue = head.data;
            head = head.next;
            return deletedValue;
        }

        LinkedListNode current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                int deletedValue = current.next.data;
                current.next = current.next.next;
                return deletedValue;
            }
            current = current.next;
        }

        return -1; // Değer bulunamadı
    }

    public void print() {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.add(1);
        linkedListNode.add(2);
        linkedListNode.add(3);
        linkedListNode.add(4);

        linkedListNode.print();

        System.out.println();

        System.out.println(linkedListNode.size());
    }

}
