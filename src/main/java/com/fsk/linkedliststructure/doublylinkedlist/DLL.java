package com.fsk.linkedliststructure.doublylinkedlist;

public class DLL {

    public Node head;
    public Node tail;

    public DLL() {
        head = null;
        tail = null;
    }

    public void add(int data , int index) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        Node current = head;
        int i = 0;

        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }


        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        }

        else {
            newNode.next = current.next;
            newNode.prev = current;

            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }


}
