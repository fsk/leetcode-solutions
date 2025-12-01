package com.fsk.leetcodesolutions;

import java.util.HashSet;
import java.util.Set;

public class Main93 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        public void addList(int val) {
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

        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode temp = dummy;
            while (temp.next != null) {
                if (set.contains(temp.next.val)) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }

            return dummy.next;
        }

    }
}
