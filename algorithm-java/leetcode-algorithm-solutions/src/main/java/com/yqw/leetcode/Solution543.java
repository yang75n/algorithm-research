package com.yqw.leetcode;

/**
 * 543. 二叉树的直径
 */
class Solution543 {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
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

        System.out.println(new Solution543().diameterOfBinaryTree(root));
    }

    private static class TreeNode {
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
