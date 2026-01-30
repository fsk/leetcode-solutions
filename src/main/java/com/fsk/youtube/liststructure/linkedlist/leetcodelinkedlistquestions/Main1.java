package com.fsk.youtube.liststructure.linkedlist.leetcodelinkedlistquestions;

public class Main1 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode();

        node1.addNode(1);
        node1.addNode(2);
        node1.addNode(3);
        node1.addNode(4);
        node1.addNode(1);

        System.out.println(node1.hasCycle(node1));

        //node1
    }
}
