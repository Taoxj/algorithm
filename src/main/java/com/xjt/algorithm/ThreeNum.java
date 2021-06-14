package com.xjt.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 
 * @author kevin
 * @date 2021/4/8
 */
public class ThreeNum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     *
     * 请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 实例：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     *
     * 输出：[[-1,-1,2],[-1,0,1]]
     */

    /**
     * 算法流程：
     *
     * 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     *
     * 对数组进行排序。
     *
     * 遍历排序后数组：
     *
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     *
     * 对于重复元素：跳过，避免出现重复解
     *
     * 令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
     *
     * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
     *
     * 若和大于 0，说明 nums[R] 太大，R 左移
     *
     * 若和小于 0，说明 nums[L] 太小，L 右移
     *
     * 复杂度分析 :
     *
     * 时间复杂度：O(n 2 )，数组排序 O(NlogN)，遍历数组 O(n)，双指针遍历 O(n)，总体 O(Nlog N)+O(n)∗O(n)，O(n 2 )
     *
     * 空间复杂度：O(1)
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return lists;
        }

        // 排序
        Arrays.sort(nums);

        // 双指针
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return lists;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l < r && nums[l + 1] == nums[l])
                        ++l;
                    while (l < r && nums[r - 1] == nums[r])
                        --r;
                    ++l;
                    --r;
                }
                if (tmp > 0)
                    r--;
                if (tmp < 0)
                    l++;
            }
        }
        return lists;
    }
}
