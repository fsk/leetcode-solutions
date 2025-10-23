package com.fsk.algorithms.liststructure.linkedlist;

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
        if (head != null) {
            count++;
            while (current.next != null) {
                count++;
                current = current.next;
            }
            return  count;
        }
        return 0;
    }

    public int delete(int value) {
        LinkedListNode current = head;
        if (head == null) {
            return -1;
        }else if (size() == 1) {
            int deletedValue = current.data;
            head = null;
            return deletedValue;
        }else {
            while (current.next.data == value) {
                current.next.data = current.next.next.data;
                current.next = null;
                return value;
            }
        }
        return 0;
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
