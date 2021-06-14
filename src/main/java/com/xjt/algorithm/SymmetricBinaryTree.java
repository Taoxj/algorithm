package com.xjt.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class SymmetricBinaryTree {

    /**
     * 题目：给定一个二叉树，检查它是否是镜像对称的
     */

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

    /**
     * 思路：我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，pp 指针和 qq 指针一开始都指向这棵树的根，随后 pp 右移时，qq 左移，pp 左移时，qq 右移。每次检查当前 pp 和 qq
     * 节点的值是否相等，如果相等再判断左右子树是否对称。
     *
     * @param root
     * @return
     */
    public boolean isSymmetricInRecursive(TreeNode root) {
        return checkInRecursive(root, root);
    }

    public boolean checkInRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 这里和上面的判断一定要注意先后顺序
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && checkInRecursive(p.left, q.right) && checkInRecursive(p.right, q.left);
    }

    /**
     * 思路：迭代
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），然后将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * @param root
     * @return
     */
    public boolean isSymmetricInIteration(TreeNode root) {
        return checkInIteration(root, root);
    }

    public boolean checkInIteration(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
