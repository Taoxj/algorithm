package com.xjt.algorithm;

/**
 * 长度最小的子数组
 * 
 * @author kevin
 * @date 2021/4/15
 */
public class MinSubArrayLen {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     *
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3] 输出：2
     *
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     */

    /**
     * 采用二分法，用两个指针先记录数组首尾位置，然后设定一个初始窗口大小leng，然后遍历数组，
     *
     * 查看在数组中 mid 个元素长度的和是否有满足的，如果没有满足的我们就扩大窗口的大小继续查找，
     *
     * 如果有满足的我们就记录下窗口的大小 leng，因为这个 leng 不一定是最小的，我们要缩小窗口的大小再继续找
     *
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        // 首指针
        int lo = 1;
        int hi = nums.length;

        // 窗口大小
        int minLen = 0;
        while (lo <= hi) {
            // 窗口大小，每次都是二分法来减少
            int leng = (lo + hi) >> 1;
            // 当前窗口大小能得到target
            if (windowExist(leng, nums, target)) {
                // 缩小窗口，这样计算下来就相当于少了一半的窗口了
                hi = leng - 1;
                minLen = leng;
            } else {
                // 没找到，就扩大窗口，这样就相当于扩大了原来窗口的一半大小
                lo = leng + 1;
            }
        }
        return minLen;
    }

    /**
     * size窗口的大小
     * 
     * @param size
     * @param nums
     * @param s
     * @return
     */
    private static boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这里是为了始终保持窗口大小，然后把最先加的值出队
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            // 如果大于目标结果，说明当前的窗口大小符合
            if (sum >= s) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3, 6, 1, 7};
        System.out.println(minSubArrayLen(7, nums));
    }
}
