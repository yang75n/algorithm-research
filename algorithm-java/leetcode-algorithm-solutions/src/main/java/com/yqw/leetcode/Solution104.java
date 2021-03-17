package com.yqw.leetcode;


class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
         /*
               1
              / \
             2   3
            / \
           4   5
                    */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        TreeNode node5 = new TreeNode(5);
        node2.right = node5;
        TreeNode node4 = new TreeNode(4);
        node2.left = node4;

        System.out.println(new Solution104().maxDepth(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}