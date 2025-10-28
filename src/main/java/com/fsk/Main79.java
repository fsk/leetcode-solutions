package com.fsk;

public class Main79 {

    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.addNode(0);
        list.addNode(0);
        list.addNode(1);
        list.addNode(1);

        //System.out.println(getDecimalValue(list));
        System.out.println(getDecimalValue2(list));
    }

    public static int getDecimalValue(ListNode head) {

        int sum = 0;

        ListNode previous = null;
        ListNode next;

        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        current = previous;
        int count = 0;
        while (current != null) {
            sum = (int) (sum + current.val * Math.pow(2, count));
            count++;
            current = current.next;
        }

        return sum;

    }

    public static int getDecimalValue2(ListNode head) {
        int sum = 0;
        ListNode current = head;

        while (current != null) {
            sum = (sum << 1) | current.val;
            current = current.next;
        }

        return sum;
    }

}
