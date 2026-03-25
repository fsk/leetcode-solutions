package com.fsk.leetcodesolutions;

// 3263. Convert Doubly Linked List to Array I

import com.fsk.linkedliststructure.doublylinkedlist.DLL;
import com.fsk.linkedliststructure.doublylinkedlist.Node;

import java.util.ArrayList;
import java.util.List;

public class Main135 {
    public static void main(String[] args) {
        DLL list = new DLL();

        list.add(10,0);
        list.add(20,1);
        list.add(30,2);

        list.print();

        int[] arr = toArray(list.head);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] toArray2(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];
        int index = 0;

        while (head != null) {
            arr[index++] = head.val;
            head = head.next;
        }
        return arr;
    }
}
