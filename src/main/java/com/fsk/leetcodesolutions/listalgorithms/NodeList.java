package com.fsk.leetcodesolutions.listalgorithms;

public class NodeList {

    int data;
    NodeList next;

    NodeList() {}

    NodeList(int data) {
        this.data = data;
    }

    NodeList(int data, NodeList next) {
        this.data = data; this.next = next;
    }

    public void addNode(int data) {
        NodeList current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NodeList(data);
    }

    public void printList() {
        NodeList current = this;
        while (current != null) {
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // LEETCODE SOLUTION 21
    public NodeList orderedTwoListMerge(NodeList head1, NodeList head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data <= head2.data) {
            head1.next = orderedTwoListMerge(head1.next, head2);
            return head1;
        }else {
            head2.next = orderedTwoListMerge(head1, head2.next);
            return head2;
        }
    }

}
