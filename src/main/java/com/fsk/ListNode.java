package com.fsk;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public void addNode(int data) {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    public ListNode deleteNode(ListNode head, int data) {

        while (head != null && head.val == data) {
            head = head.next;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val == data) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return head;
    }

    public void  print() {
        ListNode current = this;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

}

