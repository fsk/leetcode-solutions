package com.fsk.algorithms.liststructure.linkedlist.leetcodelinkedlistquestions;

import java.util.HashSet;
import java.util.Set;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
     }

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public void addNode(int val) {

        ListNode current = this;

        if (this.val == 0 && this.next == null) {
            this.val = val;
            return;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    public void printList() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print("->");
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}