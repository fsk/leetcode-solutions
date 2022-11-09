package com.fsk;

public class Main3 {

    public static void main(String[] args) {
        ListNode instnce = new ListNode();
        instnce.val = 10;
        instnce.next = new ListNode(10);
    }
}


  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }

