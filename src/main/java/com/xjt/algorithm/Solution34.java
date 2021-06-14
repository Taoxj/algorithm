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

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
            return res;
        }
        findPath(root, target);
        return res;
    }
    public void findPath(TreeNode root, int target) {
        //因为FindPath中和 下面程序中都进行了判null操作，root绝对不可能为 null
        path.add(root.val);
        //已经到达叶子节点，并且正好加出了target
        if (root.val == target && root.left == null && root.right == null) {
            //将该路径加入res结果集中
            res.add(new ArrayList(path));
        }
        //如果左子树非空，递归左子树
        if (root.left != null) {
            findPath(root.left, target - root.val);
        }
        //如果右子树非空，递归右子树
        if (root.right != null) {
            findPath(root.right, target - root.val);
        }
        //无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
        path.remove(path.size() - 1);
        return;
    }
}
