package com.xjt.algorithm;

import java.util.ArrayList;

/**
 * [剑指offer] 面试题34：二叉树中和为某一值的路径
 */
public class Solution34 {
    /**
     题目描述：
     输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */

    /**
     * 解题思路：
     * 因为是从根节点出发，可以用前序遍历
     * 当用前序遍历访问到某一个节点时，把该节点添加到路径中，并且用目标值减去该节点的值。
     * 如果该节点为叶节点并且减去该点后为0，则当前路径符合要求。如果不是叶子节点，访问其子节点。
     * 当前结点访问结束后，递归函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点，
     * 以确保返回父结点时路径刚好是从根结点到父结点的路径。
     * 这种保存路径的数据结构可以用栈
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> getAllPath(TreeNode root, int target) {
        if (root == null) {
            return pathList;
        }
        target -= root.val;
        list.add(root.val);
        // 说明是叶子节点
        if (root.val == 0 && root.left == null && root.right == null) {
            pathList.add(new ArrayList<Integer>(list));
        } else {
            getAllPath(root.left, target);
            getAllPath(root.right, target);
        }
        // 删除当前节点，这样递归回父节点才不会包含当前节点
        list.remove(list.size() - 1);
        return pathList;
    }
}
