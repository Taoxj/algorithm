package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author kevin
 * @date 2021/4/4
 */
public class RightSideView {

    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 输入: [1,2,3,null,5,null,4]
     * 
     * 输出: [1, 3, 4]
     */

    /**
     * 思路：BFS
     *
     * 思路： 利用 BFS 进行层次遍历，记录下每层的最后一个元素。
     *
     * 时间复杂度： O(n)，每个节点都入队出队了 1 次。
     * 
     * 空间复杂度： O(n)，使用了额外的队列空间。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 拿到最后面的结点
                TreeNode node = queue.poll();
                // 左节点不为空
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 将当前层的最后一个结点放入结果
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    /**
     * 思路：BFS
     *
     * 思路： 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     *
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     *
     * 时间复杂度： O(N)，每个节点都访问了 1 次。
     *
     * 空间复杂度： O(N)，因为这不是一棵平衡二叉树，二叉树的深度最少是 logN, 最坏的情况下会退化成一条链表，深度就是 N，
     * 
     * 因此递归时使用的栈空间是 O(N) 的。
     *
     *
     * @param root
     * @return
     */

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideViewDFS(TreeNode root) {

        // 从根节点开始访问，根节点深度是0
        dfs(root, 0);
        return res;
    }

    /**
     * 深度搜索二叉树
     * 
     * @param root
     * @param depth
     */
    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        // 先访问 当前节点，再递归地访问 右子树 和 左子树
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == res.size()) {
            res.add(root.val);
        }

        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
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
