package com.xjt.algorithm;

/**
 * 二叉搜索树中第K小的元素
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class KthSmallestOfTree {

    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     * 输入：root = [3,1,4,null,2], k = 1 输出：1
     *
     */

    /**
     * 思路：用递归 + 中序遍历，中序遍历是左节点-根节点-右节点
     *
     * 通过构造 BST 的中序遍历序列，则第 k-1 个元素就是第 k 小的元素
     * 
     */

    private int res;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    /**
     * 递归中序遍历结点，然后每次都加1，因为是按顺序从小到大遍历，当count == k时，就能得到第k小的元素了
     *
     * 时间复杂度：O(n)，最坏情况是会遍历了整棵树
     *
     * 空间复杂度：O(1)
     * 
     * @param root
     * @return
     */

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;
        inorder(root.left, k);

        ++count;

        if (count == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

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
