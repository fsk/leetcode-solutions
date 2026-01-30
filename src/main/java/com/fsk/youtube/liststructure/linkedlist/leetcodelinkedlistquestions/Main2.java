package com.fsk.youtube.liststructure.linkedlist.leetcodelinkedlistquestions;

public class Main2 {


    public static void main(String[] args) {

        ListNode l1 = new ListNode();

        l1.addNode(1);
        l1.addNode(2);
        l1.addNode(3);
        l1.addNode(4);
        l1.addNode(5);

    }

    public static ListNode reverseList(ListNode headNode) {

        if (headNode == null) {
            return null;
        }else if (headNode.next == null) {
            return headNode;
        }

        ListNode currentNode = headNode;
        ListNode previousNode = null;
        ListNode nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;

    }


}
