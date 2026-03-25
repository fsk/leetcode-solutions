package com.fsk.linkedliststructure.doublylinkedlist;

/**
 * Doubly Linked List
 */

public class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}
