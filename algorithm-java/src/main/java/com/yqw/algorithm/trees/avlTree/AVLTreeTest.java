package com.yqw.algorithm.trees.avlTree;

public class AVLTreeTest {
    public static void main(String[] args) {
        Integer[] num = {5, 8, 2, 0, 1, -2, -9, 100};
        AVLTree<Integer> avl = new AVLTree<>();
        for (int n : num) {
            avl.insertElement(n);
        }
        avl.nrInOrderTraverse();
    }
}
