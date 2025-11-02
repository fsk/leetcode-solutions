package com.fsk;

public class Main89 {

    static class ListNode {

      int val;
      ListNode next;

      ListNode() {}

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
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

      public int size() {
          ListNode current = this;
          int size = 0;
          while (current != null) {
              current = current.next;
              size++;
          }
          return size;
      }

        public ListNode middleNode(ListNode head) {

          ListNode temp = head;

          int size = 0;
          while (temp != null) {
              temp = temp.next;
              size++;
          }

          int middle = size / 2;

          ListNode current = head;
          for (int i = 0; i < middle; i++) {
              current = current.next;
          }

          return current;

        }

        public ListNode middleNode2(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;

        }


  }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.addList(2);
        node1.addList(3);
        node1.addList(4);
        node1.addList(5);

        System.out.println(node1.size());
        System.out.println(node1.middleNode(node1));

    }


}
