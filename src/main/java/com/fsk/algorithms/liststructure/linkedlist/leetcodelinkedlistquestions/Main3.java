package com.fsk.algorithms.liststructure.linkedlist.leetcodelinkedlistquestions;

public class Main3 {

    public static void main(String[] args) {

        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        list1.addNode(5);
        list1.addNode(8);
        list1.addNode(13);
        list1.addNode(21);

        list2.addNode(4);
        list2.addNode(7);
        list2.addNode(11);

        ListNode listNode = mergeTwoLists(list1, list2);

        listNode.printList();

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;

        }

        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;

    }
}
