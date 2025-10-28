package com.fsk;

public class Main77 {


    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        list.addNode(0);
        list.addNode(0);
        list.addNode(1);
        list.addNode(1);

        list.print();

        System.out.println(getDecimalValue(list));


    }

    public static int getDecimalValue(ListNode head) {
        ListNode current = head;
        int sum = 0;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;

        }
        return count;

    }
}
