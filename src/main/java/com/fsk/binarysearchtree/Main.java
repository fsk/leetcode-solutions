package com.fsk.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(8);

        tree.insert(5);
        tree.insert(10);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);
        tree.insert(6);
        tree.insert(15);


        System.out.println("IN-ORDER:");
        tree.inOrder();


        System.out.println("\n");
        System.out.println("PRE-ORDER:");
        tree.preOrder();

        System.out.println("\n");
        System.out.println("POST-ORDER:");
        tree.postOrder();


        System.out.println("\n");
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(17));


    }
}
