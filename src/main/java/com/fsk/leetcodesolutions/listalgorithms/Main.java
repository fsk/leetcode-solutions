package com.fsk.leetcodesolutions.listalgorithms;

public class Main {

    public static void main(String[] args) {

        NodeList nodeList1 = new NodeList(1);
        nodeList1.addNode(2);
        nodeList1.addNode(3);
        nodeList1.addNode(4);
        nodeList1.addNode(5);
        nodeList1.printList();

        NodeList nodeList2 = new NodeList(6);
        nodeList2.addNode(7);
        nodeList2.addNode(8);
        nodeList2.addNode(9);
        nodeList2.addNode(10);
        nodeList2.printList();

        NodeList nodeList3 = new NodeList(1);
        nodeList3.addNode(2);
        nodeList3.addNode(3);
        nodeList3.addNode(4);
        nodeList3.addNode(3);
        nodeList3.addNode(2);
        nodeList3.addNode(1);


        NodeList mergedNodeList = nodeList1.orderedTwoListMerge(nodeList1, nodeList2);
        mergedNodeList.printList();

        System.out.println(nodeList3.isPalindrome(nodeList3));

    }

}

