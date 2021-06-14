package com.xjt.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层序遍历(也就是Z型打印)
 * 
 * @author kevin
 * @date 2021/4/11
 */
public class ZigzagLevelOrder {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 实例：
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     * 3
     *
     * / \
     *
     * 9 20
     *
     * / \
     * 
     * 15 7
     *
     * 返回锯齿形层序遍历如下：
     *
     * [ [3],
     *
     * [20,9],
     *
     * [15,7] ]
     */

    /**
     * 使用LinkedList这个双向队列存储层次遍历的每个集合，使用一个boolean的标识来确定每一层遍历的顺序到底是从左往右还是从右往左即可。
     *
     * 从左往右直接在链表尾加入元素即可addLast()
     * 
     * 从右往左直接在链表头加入元素即可addFirst()
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        // 从左往右的标志
        boolean flag = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (flag) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            flag = !flag;
        }
        return res;
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
