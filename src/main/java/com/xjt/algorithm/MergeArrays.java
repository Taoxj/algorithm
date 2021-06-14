package com.xjt.algorithm;

/**
 * 合并N个有序数组，每个数组长度为M
 * 
 * @author kevin
 * @date 2021/6/14
 */
public class MergeArrays {

    /**
     * 题目：合并N个有序数组，每个数组的长度为M，合并为N*M的有序数组。时间复杂度要求最低
     *
     * 解法：N个数组进行两两合并，合并后的数组再继续执行合并过程，最后合成N*M的有序数组。
     *
     * 可以认为合并这个递归过程发生了logN次，每一次合并的过程都是N*M个数合并，所以每一次合并的时间复杂度为N*M,总的时间复杂度就是N*M*logN
     */

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 8, 9}, {2, 3, 6, 10}, {5, 18, 20, 36}};
        for (int num : mergeArray(nums)) {
            System.out.println(num);
        }
    }

    public static int[] mergeArray(int[][] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 有序数组个数
        int len = nums.length;
        // 数组个数的奇偶判断
        boolean flag = len % 2 != 0;
        int half = flag ? len / 2 + 1 : len / 2;
        int[][] result = new int[half][];

        for (int i = 0; i < len; i += 2) {
            // 如果是奇数并且是最后一个，那么新二维数组中间那个数组就是最后一个
            if (flag && i == len - 1) {
                result[i / 2] = nums[i];
            } else {
                result[i / 2] = mergeTwoArray(nums[i], nums[i + 1]);
            }
        }
        return mergeArray(result);
    }

    public static int[] mergeTwoArray(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] resultArray = new int[len1 + len2];
        while (index1 < len1 && index2 < len2) {
            if (num1[index1] < num2[index2]) {
                resultArray[index++] = num1[index1++];
            } else {
                resultArray[index++] = num2[index2++];
            }
        }

        while (index1 < len1) {
            resultArray[index++] = num1[index1++];
        }

        while (index2 < len2) {
            resultArray[index++] = num2[index2++];
        }
        return resultArray;
    }
}
