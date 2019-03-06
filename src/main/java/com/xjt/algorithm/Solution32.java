package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * [剑指offer] 面试题32：从上往下打印二叉树
 */
public class Solution32 {
    /**
     题目描述：
     从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */

    /**
     * 解题思路：借用一个队列
     * 使用两个队列一个存放节点，一个存放值。先将根节点加入到队列中，
     * 然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printTree(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null){
            return list;
        }
        // 创建一个双向的队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() != 0){
            // remove返回并删除队首元素
            root = queue.remove();
            list.add(root.val);
            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null){
                queue.add(root.right);
            }
        }
        return list;
    }
}
