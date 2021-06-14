package com.xjt.algorithm;

/**
 * 二叉树直径
 * 
 * @author kevin
 * @date 2021/4/11
 */
public class DiameterOfBinaryTree {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     *
     * 这条路径可能穿过也可能不穿过根结点。
     *
     * 实例：
     *
     * 给定二叉树
     *
     * 1
     *
     * / \
     *
     * 2 3
     *
     * / \
     * 
     * 4 5
     *
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     */

    /**
     * 递归思路：
     *
     * 知道对于该节点的左儿子向下遍历经过最多的节点数 L （即以左儿子为根的子树的深度）
     *
     * 和其右儿子向下遍历经过最多的节点数 R （即以右儿子为根的子树的深度），
     *
     * 那么以该节点为起点的路径经过节点数的最大值即为 L+R+1 。
     *
     * 为什么减1，因为这两个都包含该节点，只要一个就好
     */

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 1;
        depth(root);
        return ans;
    }

    /**
     * 递归每一层
     * 
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        // 访问到空节点，返回0
        if (node == null) {
            return 0;
        }
        // 左儿子为根的子树的深度
        int l = depth(node.left);
        // 右儿子为根的子树的深度
        int r = depth(node.right);
        // 计算长度即L+R+1 并更新ans
        ans = Math.max(ans, l + r + 1);
        // 返回该节点为根的子树的深度
        return Math.max(l, r) + 1;
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
