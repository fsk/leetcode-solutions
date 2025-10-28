package com.fsk;

public class Main78 {

    public static void main(String[] args) {


        ListNode list = new ListNode(12);
        list.addNode(7);
        list.addNode(4);
        list.addNode(5);
        list.addNode(3);

        reverseList2(list);


    }

    public static ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode next;

        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;

    }

    public static ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode rest = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return rest;

    }
}
