package com.xjt.algorithm;

/**
 * 按奇偶排序数组 II
 * 
 * @author kevin
 * @date 2021/4/4
 */
public class SortArrayByParityII {

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 输入：[4,2,5,7]
     *
     * 输出：[4,5,2,7]
     * 
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     */

    /**
     * 为数组的偶数下标部分和奇数下标部分分别维护指针 i, j。随后，在每一步中，
     *
     * 如果 A[i] 为奇数，则不断地向前移动 j（每次移动两个单位），直到遇见下一个偶数。
     *
     * 此时，可以直接将 A[i] 与 A[j] 交换。
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        int j = 1;
        // 偶数下标开始
        for (int i = 0; i < n; i += 2) {
            // 如果当前值是奇数
            if (nums[i] % 2 == 1) {
                // 跟下标是奇数的偶数值替换
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
