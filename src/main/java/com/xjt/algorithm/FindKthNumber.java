package com.xjt.algorithm;

/**
 * 字典序的第K小数字
 * 
 * @author kevin
 * @date 2021/4/2
 */
public class FindKthNumber {

    /**
     * 题目描述：
     *
     * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
     *
     * 注意：1 ≤ k ≤ n ≤ 109。
     *
     * 示例：
     *
     * 输入: n: 13 k: 2
     *
     * 输出: 10
     *
     * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
     *
     * 思路：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/
     */

    /**
     * 可以用上面的数字做推演
     * 
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        // 第一字典序小的(就是1)
        int cur = 1;
        // 前缀从1开始
        int prefix = 1;
        while (cur < k) {
            int temp = count(n, prefix);
            // k在这个前缀的个数里
            if (cur + temp > k) {
                // 往下层遍历
                prefix *= 10;
                // 一直遍历到第K个推出循环
                cur++;
            } else {
                prefix++;
                cur += temp;
            }
        }
        // 退出循环时 cur==k 正好找到
        return prefix;
    }

    private int count(int n, int prefix) {
        // 不断向下层遍历可能一个乘10就溢出了, 所以用long
        long cur = prefix;
        // 下一个前缀峰头
        long next = cur + 1;
        int count = 0;
        while (cur <= n) {
            // 下一峰头减去此峰头
            count += Math.min(n + 1, next) - cur;
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            // 往下层走
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
