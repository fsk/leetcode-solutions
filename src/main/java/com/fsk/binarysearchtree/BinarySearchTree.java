package com.fsk.binarysearchtree;

public class BinarySearchTree {

    public int data;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
    }

    // INSERT
    public void insert(int data) {
        if (data <= this.data) {
            if (left == null) {
                left = new BinarySearchTree(data);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTree(data);
            } else {
                right.insert(data);
            }
        }
    }

    // INORDER: Left - Root - Right
    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.inOrder();
        }
    }

    // PREORDER: Root - Left - Right
    public void preOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    // POSTORDER: Left - Right - Root
    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.print(data + " ");
    }

    // Contains
    public boolean contains(int data) {
        if (data == this.data) {
            return true;
        }else if (data < this.data) {
            return left != null && left.contains(data);
        }else {
            return right != null && right.contains(data);
        }
    }
}
