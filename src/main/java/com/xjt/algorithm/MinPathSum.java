package com.xjt.algorithm;

/**
 * 最小路径和
 * 
 * @author kevin
 * @date 2021/4/11
 */
public class MinPathSum {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 实例：
     *
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     *
     * 输出：7
     * 
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     */

    /**
     * 思路：动态规划
     *
     * 创建二维数组 dp，与原始网格的大小相同，dp[i][j] 表示从左上角出发到 (i,j) 位置的最小路径和。
     *
     * 显然，dp[0][0]=grid[0][0]。对于 dp 中的其余元素，通过以下状态转移方程计算元素值。
     *
     * 当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
     *
     * 当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
     *
     * 当 i>0 且 j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
     *
     * 最后得到 dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和
     * 
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
