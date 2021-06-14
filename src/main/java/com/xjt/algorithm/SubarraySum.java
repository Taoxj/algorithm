package com.xjt.algorithm;

import java.util.HashMap;

/**
 * 和为K的子数组
 * 
 * @author kevin
 * @date 2021/4/17
 */
public class SubarraySum {

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */

    /**
     * 思路：前缀和 + 哈希表
     *
     * 我们定义 pre[i] 为 [0..i] 里所有数的和，则 pre[i] 可以由 pre[i−1] 递推而来，即：pre[i]=pre[i−1]+nums[i]
     *
     * 那么「[j..i] 这个子数组和为 k 」这个条件我们可以转化为 pre[i]−pre[j−1]==k
     *
     * 简单移项可得符合条件的下标 j 需要满足 pre[j−1]==pre[i]−k
     *
     * 所以我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k 的 pre[j] 即可。
     *
     * 我们建立哈希表 mp，以和为键，出现次数为对应的值，记录 pre[i] 出现的次数，从左往右边更新 mp 边计算答案，
     *
     * 那么以 i 结尾的答案 mp[pre[i]−k] 即可在 O(1) 时间内得到。最后的答案即为所有下标结尾的和为 k 的子数组个数之和。
     *
     * 需要注意的是，从左往右边更新边计算的时候已经保证了mp[pre[i]−k] 里记录的 pre[j] 的下标范围是 0≤j≤i
     *
     * 同时，由于pre[i] 的计算只与前一项的答案有关，因此我们可以不用建立 pre 数组，直接用 pre 变量来记录 pre[i−1] 的答案即可
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        // 前缀和为0，说明什么数都不加，这种情况只会有1次
        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            // pre保存加上当前nums[i]值后的累加值
            pre += nums[i];
            // mp.get(pre - k)为前缀和为pre[i]−k的个数
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            // 前缀和pre更新，mp里面存在就累加次数
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
