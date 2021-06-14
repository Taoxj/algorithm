package com.xjt.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class WidthOfBinaryTree {

    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
     *
     * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     *
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *
     * 输入: [1,3,2,5,3,9]，按照三层二叉树分层
     *
     * 输出: 4 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
     */

    /**
     * 这个问题中的主要想法是给每个节点一个 position 值，如果我们走向左子树，那么 position -> position * 2，
     *
     * 如果我们走向右子树，那么 position -> positon * 2 + 1。当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1。
     *
     * 方法 1：宽度优先搜索 [Accepted]
     *
     * 宽度优先搜索顺序遍历每个节点的过程中，我们记录节点的 position 信息，
     *
     * 对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。
     *
     */
    public int widthOfBinaryTree(TreeNode root) {

        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        // left代表当前层最左边的结点位置
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            // 把左右结点都加入，同时深度加上1
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2 + 1));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 2));
            }
            // 如果当前深度不等于拿到结点的深度，说明这一层还没有一个结点加到队列中，说明当前结点就是这一层的最左侧结点，加上去
            if (curDepth != a.depth) {
                curDepth = a.depth;
                left = a.pos;
            }
            // 假设这一层只有一个结点，那么a.pos - left + 1的值为1，比前面的宽度值小，排除掉
            // 假设叶子结点层最多，那么这一层a.pos - left + 1的值就是最大的
            ans = Math.max(ans, a.pos - left + 1);
        }
        return ans;

    }

    /**
     * 改造每个节点的信息，包含当前深度，位置
     */
    class AnnotatedNode {
        TreeNode node;
        int depth, pos;

        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
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
