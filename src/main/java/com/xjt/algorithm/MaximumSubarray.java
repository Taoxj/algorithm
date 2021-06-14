package com.xjt.algorithm;

/**
 * 最大子序和
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class MaximumSubarray {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4] 输出：6
     *
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */

    /**
     * 动态规划：
     * 
     * 假设 nums 数组的长度是 n，下标从 0 到 n-1。
     *
     * 我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
     *
     * 因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i) 呢？
     *
     * 我们可以考虑 nums[i] 单独成为一段还是加入 f(i−1) 对应的那一段，这取决于 \nums[i] 和 f(i-1) + nums[i] 的大小，
     *
     * 我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     *
     * f(i)=max{f(i−1)+nums[i],nums[i]}
     *
     * 两个值：pre-子数组的和，maxAns-子数组的和在变化过程中产生的最大值，子数组和每变化一次，maxAns都要记录一下最大值，只要大了就更新
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            // 当前结果 + 之前计算的结果，看看哪个大
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
