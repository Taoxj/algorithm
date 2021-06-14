package com.xjt.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * 
 * @author kevin
 * @date 2021/4/18
 */
public class OrangesRotting {

    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格； 值 1 代表新鲜橘子； 值 2 代表腐烂的橘子。
     *
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotting-oranges 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入：[[2,1,1],[0,1,1],[1,0,1]] 输出：-1
     * 
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     */

    /**
     * 思路：BFS（广度优先）
     *
     * 这道题的主要思路是：
     *
     * 用一个队列保存保存腐烂的橘子，一开始，我们找出所有腐烂的橘子，将它们放入队列，作为第 0 层的结点。
     *
     * 然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
     *
     * 由于可能存在无法被污染的橘子，我们需要记录新鲜橘子的数量。在 BFS 中，每遍历到一个橘子（污染了一个橘子），就将新鲜橘子的数量减一。如果 BFS 结束后这个数量仍未减为零，说明存在无法被污染的橘子。
     *
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        // 行数
        int m = grid.length;
        // 列数
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 用count表示新鲜橘子的数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        int round = 0; // round 表示腐烂的轮数，或者分钟数
        // 如果没有新鲜橘子或者是没法加腐烂橘子，循环就结束
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                // 以下从当前腐烂橘子的四个方位来查看，需要注意的是不能数组越界
                // 先看看左边橘子有没有新鲜的，有的话就变腐烂，顺便减少新鲜数量以及加到队列
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    count--;
                    grid[r - 1][c] = 2;
                    queue.add(new int[] {r - 1, c});
                }
                // 查看右边的橘子
                if (r + 1 < m && grid[r + 1][c] == 1) {
                    count--;
                    grid[r + 1][c] = 2;
                    queue.add(new int[] {r + 1, c});
                }
                // 查看上边的橘子
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    count--;
                    grid[r][c - 1] = 2;
                    queue.add(new int[] {r, c - 1});
                }
                // 查看下边的橘子
                if (c + 1 < n && grid[r][c + 1] == 1) {
                    count--;
                    grid[r][c + 1] = 2;
                    queue.add(new int[] {r, c + 1});
                }
            }
        }
        // 还是有新鲜橘子，就返回-1，否则返回循环轮数
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
