package com.fsk.binarysearchtree.bstleetcodesolutions;

import com.fsk.binarysearchtree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

// LeetCode 700
public class Main1 {

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(7);
        root.insert(4);
        root.insert(3);
        root.insert(5);
        root.insert(9);
        root.insert(8);
        root.insert(12);

        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);


    }

    // LeetCode 700
    public BinarySearchTree searchBST(BinarySearchTree root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;
        else if (root.data > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }


    // LeetCode 270
    public int closestValue(BinarySearchTree root, double target) {

        if (root == null) return -1;

        int closestValue = root.data;

        if (target < root.data && root.left != null) {
            int leftClosestValue = closestValue(root.left, target);
            if (Math.abs(leftClosestValue - target) < Math.abs(closestValue - target)) {
                closestValue = leftClosestValue;
            }
        }else if (target > root.data && root.right != null) {
            int rightClosest = closestValue(root.right, target);
            if (Math.abs(target - rightClosest) < Math.abs(target - closestValue)) {
                closestValue = rightClosest;
            }
        }
        return closestValue;
    }


    // LeetCode 501
    public static int[] findMode(BinarySearchTree root) {
        return null;
    }

    // LeetCode 94
    // Inorder => Left - Root - Right
    public static List<Integer> inorderTraversal(BinarySearchTree root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(BinarySearchTree root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }

    // LeetCode 144
    // Preorder => Root - Left - Right
    public List<Integer> preorderTraversal(BinarySearchTree root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(BinarySearchTree root, List<Integer> result) {
        if (root == null) return;
        result.add(root.data);
        preorder(root.left, result);
        preorder(root.right, result);
    }


}