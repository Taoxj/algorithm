package com.xjt.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 
 * @author kevin
 * @date 2021/4/17
 */
public class LongestConsecutive {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2] 输出：4
     *
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */

    /**
     * 首先，要找到 nums 中有哪些元素能够当做连续序列的左边界。
     *
     * 假设 a 为一个连续序列的左边界，则 a - 1 就不可能存在于数组中。 因为，若 a - 1 存在于 nums 数组中，则 a 不可能成为连续序列的左边界。
     *
     * 所以，若一个元素值 a 满足：a - 1 不在 nums 数组中，则该元素值 a 就可以当做连续序列的左边界。
     *
     * 要利用一个可以快速查找的数据结构来存储 nums 数组中的元素，并且遍历（因为 set 在存储时有去重的功能，所以运行时间要比 list 快的多）。
     *
     * 若 a - 1 存在于 list（set） 中，则 a 不可能是左边界，直接跳过；
     *
     * 若 a - 1 不存在于 list（set） 中，则 a 是左边界。则继续找 a + 1，a + 2 ... 是否存在于 list（set） 集合中，并记录长度。
     *
     * 每次记录最大的连续序列的长度，返回 maxLength 即可。
     *
     * 作者：Booooo_
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-ha-xi-biao-mei-wq4te/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int maxLength = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 0;
            while (set.contains(num++)) {
                len++;
            }
            maxLength = Math.max(len, maxLength);
        }
        return maxLength;
    }
}
