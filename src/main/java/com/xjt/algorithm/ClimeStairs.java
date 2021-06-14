package com.xjt.algorithm;

/**
 * 爬楼梯
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class ClimeStairs {

    /**
     * 思路：
     * 
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 示例：
     * 
     * 输入： 3 输出： 3
     *
     * 解释： 有三种方法可以爬到楼顶。
     * 
     * 1. 1 阶 + 1 阶 + 1 阶
     *
     * 2. 1 阶 + 2 阶
     *
     * 3. 2 阶 + 1 阶
     */

    /**
     * 动态规划：f(x)=f(x−1)+f(x−2)
     * 
     * @param n
     * @return
     */
    public int climbStairsSolu(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }
}
