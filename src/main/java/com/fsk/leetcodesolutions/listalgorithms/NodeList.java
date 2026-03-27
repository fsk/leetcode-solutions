package com.fsk.leetcodesolutions.listalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void deleteNode(NodeList node) {
        int data = node.data;
        NodeList current = this;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
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

    // LeetCode -> Palindrome Linked List
    public boolean isPalindrome(NodeList head) {
        if (head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        int startIndex = 0;
        int lastIndex = list.size() - 1;
        while (startIndex < lastIndex) {
            if (!Objects.equals(list.get(startIndex), list.get(lastIndex))) return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }

}
