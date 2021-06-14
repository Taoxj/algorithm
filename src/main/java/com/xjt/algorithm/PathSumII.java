package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 *
 * @author kevin
 * @date 2021/5/4
 */
public class PathSumII {

    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/path-sum-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 实例：
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     */

    /**
     * 思路及算法
     *
     * 我们可以采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。
     *
     * 当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
     *
     * 时间复杂度：O(N^2)，其中 N 是树的节点数。在最坏情况下，树的上半部分为链状，下半部分为完全二叉树，并且从根节点到每一个叶子节点的路径都符合题目要求。此时，路径的数目为 O(N)，并且每一条路径的节点个数也为
     * O(N)，因此要将这些路径全部添加进答案中，时间复杂度为 O(N^2) 。
     *
     * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于哈希表和队列空间的开销，哈希表需要存储除根节点外的每个节点的父节点，队列中的元素个数不会超过树的节点数。
     *
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        // 如果左右结点都为空的话，说明当前结点是叶子结点
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                // 删除当前结点，然后下一次就会从该结点的父节点继续搜索
                path.remove(path.size() - 1);
            }
        }

        // 如果左结点不为空，就以左结点为root向下递归
        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, targetSum - root.val, path);
            // 同样，结束后依然要删除最后一个结点
            path.remove(path.size() - 1);
        }

        // 右节点同理
        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, targetSum - root.val, path);
            path.remove(path.size() - 1);
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
