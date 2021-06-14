package com.xjt.algorithm;

/**
 * 最近公共祖先
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class LowestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 示例：
     *
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     *
     * 输出：3
     * 
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     *
     */

    /**
     * 思路：
     *
     * (递归) O(n)O(n)
     *
     * 当我们用递归去做这个题时不要被题目误导，应该要明确一点 这个函数的功能有三个：给定两个节点 p 和 q
     *
     * 如果 p 和 q 都存在，则返回它们的公共祖先； 如果只存在一个，则返回存在的一个； 如果 p 和 q 都不存在，则返回NULL 本题说给定的两个节点都存在，那自然还是能用上面的函数来解决
     *
     * 具体思路：
     *
     * （1） 如果当前结点 root 等于 NULL，则直接返回 NULL
     *
     * （2） 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
     *
     * （3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
     *
     * （4） 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left
     *
     * （5） 如果left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
     * 
     * （6） 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）
     *
     * 时间复杂度是 O(n)：每个结点最多遍历一次或用主定理，空间复杂度是 O(n)：需要系统栈空间
     *
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.left, p, q);

        if (leftNode == null) {
            return rightNode;
        }

        if (rightNode == null) {
            return leftNode;
        }

        return root;
    }
}
