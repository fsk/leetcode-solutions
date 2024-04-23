package com.fsk.denemeler.tree;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Ağaca bir değer ekleyen metod
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Yardımcı ekleme metodu
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Ağacı düzeyine göre dolaşan metod
    void inorder() {
        inorderRec(root);
    }

    // Yardımcı dolaşma metodu
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    void delete(int value) {
        root = deleteRec(root, value);
    }

    // Yardımcı silme metodu
    Node deleteRec(Node root, int value) {
        if (root == null) return null;

        // Silinecek değeri bul
        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);
        else {
            // Düğüm yapraksız veya tek çocuklu
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // İki çocuklu düğüm: Sağ alt ağacın en küçük değeri ile yer değiştir
            root.value = minValue(root.right);

            // Sağ alt ağacın en küçük değerini sil
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Bir alt ağacın en küçük değerini bulan metod
    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(12);
        bst.insert(6);
        bst.insert(13);
        bst.insert(14);
        bst.insert(11);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);

        bst.delete(10);

        System.out.println();
        bst.inorder();
    }
}
