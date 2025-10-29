package com.fsk;

public class Main80 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);

        listNode.addNode(1);
        listNode.addNode(1);
        listNode.addNode(1);
        listNode.addNode(1);
        listNode.addNode(1);

        listNode.print();

        System.out.println("============");

        ListNode listNode1 = listNode.deleteNode(listNode, 1);

        listNode1.print();




    }
}
