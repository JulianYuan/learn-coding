package com.learrn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 2.
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class BST2GreaterTree {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = init(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});

        bstToGst(root);
        printTree(root);
        //System.out.println(root);
    }

    public static TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode init(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);

        List<TreeNode> temp1 = new ArrayList<>();
        List<TreeNode> temp2 = new ArrayList<>();
        temp1.add(root);
        Integer n;
        for (int i = 1, count = 1; count < nums.length; i++) {
            int i1 = 1 << i;
            for (int j = 0; j < i1; ) {
                TreeNode node = temp1.get(j / 2);
                n = nums[count++];
                if (n != null) {
                    node.left = new TreeNode(n);
                }
                n = nums[count++];
                if (n != null) {
                    node.right = new TreeNode(n);
                }
                j += 2;
                temp2.add(node.left);
                temp2.add(node.right);
            }
            temp1 = temp2;
            temp2 = new ArrayList<>();
        }

        return root;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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
